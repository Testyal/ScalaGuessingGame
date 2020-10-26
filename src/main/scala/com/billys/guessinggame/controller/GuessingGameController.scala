package com.billys.guessinggame.controller

import java.util.Comparator

import cats.effect.IO
import com.billys.guessinggame.game.{Exact, GuessingGame}
import com.billys.guessinggame.view.{FromString, GuessingGameTerminalView}

class GuessingGameController[T: Comparator: FromString](game: GuessingGame[T], view: GuessingGameTerminalView[T]) {

  def run: IO[Unit] = {
    def runTurn: IO[Unit] = {
      view.askGuess
        .map(game.makeGuess)
        .flatMap(result => view.showGuessResult(result) *> IO(result))
        .flatMap(result => if (result == Exact) IO () else runTurn)
    }

    view.showTitle *> runTurn
  }

}
