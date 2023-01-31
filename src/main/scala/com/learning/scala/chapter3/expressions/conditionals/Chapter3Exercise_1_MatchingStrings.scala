package com.learning.scala.chapter3.expressions.conditionals

object Chapter3Exercise_1_MatchingStrings {
  def main(args: Array[String]): Unit = {
    val name: Any = null
    val nonemptyName = name match {
      case s: String if s.trim.nonEmpty => s
      case _ => "n/a"
    }
    println(nonemptyName)
  }
}
