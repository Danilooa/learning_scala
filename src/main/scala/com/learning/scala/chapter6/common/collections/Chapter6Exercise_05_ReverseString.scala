package com.learning.scala.chapter6.common.collections

object Chapter6Exercise_05_ReverseString {

  def reverse(strings: List[String]): List[String] = {
    strings match {
      case h :: t => reverse(t) ::: List(h)
      case Nil => Nil
    }

  }

  def main(args: Array[String]): Unit = {

    val strings = List("01 One", "02 Two", "03 Three", "04 Four", "05 Five")

    val reverseString = reverse(strings)

    println(reverseString)

  }
}
