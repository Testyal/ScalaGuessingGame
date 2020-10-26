package com.billys.guessinggame

import java.util.Comparator

import com.billys.guessinggame.controller.GuessingGameController
import com.billys.guessinggame.game.GuessingGame
import com.billys.guessinggame.view.{FromString, GuessingGameTerminalView}

import scala.util.Random

object App {

  implicit val intComp: Comparator[Int] = (o1: Int, o2: Int) => o1 compareTo o2

  implicit val intFromString: FromString[Int] = (value: String) => {
    try {
      Some(Integer.parseInt(value))
    } catch {
      case _: Throwable => None
    }
  }

  def main(args: Array[String]): Unit = {
    val randomAnswer = Random.nextInt(20) + 1
    val game = new GuessingGame[Int](randomAnswer)
    val view = new GuessingGameTerminalView[Int]
    val controller = new GuessingGameController[Int](game, view)

    controller.run.unsafeRunAsyncAndForget()
  }

}
