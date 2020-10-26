package com.billys.guessinggame.view

import cats.effect.IO

import scala.io.StdIn

object Console {

  def putStrLn(x: Any): IO[Unit] = IO(println(x))

  def promptLn(prompt: String): IO[String] = IO(StdIn.readLine(prompt))

}
