package com.billys.guessinggame.game

import java.util.Comparator

class GuessingGame[T: Comparator](answer: T) {

  def makeGuess(guess: T): GuessResult = {
    val comparator = implicitly[Comparator[T]]

    if (comparator.compare(answer, guess) < 0) {
      Higher
    } else if (comparator.compare(answer, guess) > 0) {
      Lower
    } else {
      Exact
    }
  }

}