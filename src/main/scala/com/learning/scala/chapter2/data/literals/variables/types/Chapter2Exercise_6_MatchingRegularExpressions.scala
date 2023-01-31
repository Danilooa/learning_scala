package com.learning.scala.chapter2.data.literals.variables.types

object Chapter2Exercise_6_MatchingRegularExpressions {
  def main(args: Array[String]): Unit = {
    val input = "Frank,123 Main,925-555-1943,95122"
    val phonePartsRegex = """.*,(\d{3})-(\d{3})-(\d{4}),.*""".r
    val phonePartsRegex(p1, p2, p3) = input
    println(s"${p1.toInt}, ${p2.toInt}, ${p3.toInt}")
  }
}
