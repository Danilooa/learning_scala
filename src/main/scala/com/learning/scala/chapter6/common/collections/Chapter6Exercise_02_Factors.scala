package com.learning.scala.chapter6.common.collections

object Chapter6Exercise_02_Factors {
  def main(args: Array[String]): Unit = {
    val long = 0 to 20
    val odds = long.filter(_ % 2 != 0)
    println(odds)
  }
}
