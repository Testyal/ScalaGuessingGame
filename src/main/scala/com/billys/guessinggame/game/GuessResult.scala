package com.billys.guessinggame.game

sealed trait GuessResult
case object Higher extends GuessResult
case object Lower extends GuessResult
case object Exact extends GuessResult