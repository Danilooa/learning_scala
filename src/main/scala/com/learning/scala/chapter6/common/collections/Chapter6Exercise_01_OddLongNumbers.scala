package com.learning.scala.chapter6.common.collections

import scala.util.Random

object Chapter6Exercise_01_OddLongNumbers {
  def main(args: Array[String]): Unit = {

    def factor(number: Long): List[Long] = {
      (2L to number - 1).filter(number % _ == 0).toList
    }

    val long = 1 to 20
    val odds = long.filter(_ % 2 != 0)

    println(odds.map(factor(_)).flatten)
  }
}
