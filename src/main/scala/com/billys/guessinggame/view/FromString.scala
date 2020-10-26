package com.billys.guessinggame.view

/**
 * Represents types which can be parsed from a string.
 */
trait FromString[T] {

  def fromString(value: String): Option[T]

}
