package com.learning.scala.chapter10.advancedtyping

object Chapter10Content_03_ImplicitClasses {

  implicit class TargetClass(input: String) {
    def repeatManyTimes(times: Int, separator: String): String = {
      List.fill(times)(input).mkString(separator)
    }
  }

  def main(args: Array[String]): Unit = {
    val times = 3
    println(s"will repeat $times times".repeatManyTimes(times, "\n"))
  }

}
