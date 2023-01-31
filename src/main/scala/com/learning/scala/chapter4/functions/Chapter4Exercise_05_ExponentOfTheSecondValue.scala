package com.learning.scala.chapter4.functions

import scala.language.postfixOps

object Chapter4Exercise_05_ExponentOfTheSecondValue {

  def pow(base: Int, exponent: Int): Int = exponent match {
    case 0 => 0
    case _ => base * base + pow(base, exponent - 1)
  }

  def main(args: Array[String]): Unit = {
    println(pow(2, 2))
  }

}
