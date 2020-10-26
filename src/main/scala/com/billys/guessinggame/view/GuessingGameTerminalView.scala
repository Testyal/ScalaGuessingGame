package com.billys.guessinggame.view

import cats.effect.IO
import cats.data.OptionT
import com.billys.guessinggame.game.{Exact, GuessResult, Higher, Lower}

class GuessingGameTerminalView[T: FromString] {

  def showTitle: IO[Unit] = Console.putStrLn("Welcome to the Guessing Game!")

  /**
   * Retrieves a guess from a user, asking continually until a parsable one is entered.
   */
  def askGuess: IO[T] = {
    val parser = implicitly[FromString[T]]

    OptionT.liftF(Console.promptLn("Enter your guess: "))
      .flatMapF(guessLine => IO(parser.fromString(guessLine)))
      .getOrElseF(askGuess)
  }

  def showGuessResult(result: GuessResult): IO[Unit] = result match {
    case Higher => Console.putStrLn("Too high!")
    case Lower  => Console.putStrLn("Too low!")
    case Exact  => Console.putStrLn("You win!")
  }

}
