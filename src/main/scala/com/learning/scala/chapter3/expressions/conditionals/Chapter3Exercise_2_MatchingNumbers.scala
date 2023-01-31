package com.learning.scala.chapter3.expressions.conditionals

object Chapter3Exercise_2_MatchingNumbers {
  def main(args: Array[String]): Unit = {
    val number = 2
    val nonemptyName = number match {
      case number if number < 0 => "less"
      case number if number > 0 => "greater"
      case _ => "same"
    }
    println(nonemptyName)
  }
}
