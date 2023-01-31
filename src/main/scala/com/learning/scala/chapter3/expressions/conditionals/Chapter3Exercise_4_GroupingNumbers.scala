package com.learning.scala.chapter3.expressions.conditionals

object Chapter3Exercise_4_GroupingNumbers {
  def main(args: Array[String]): Unit = {
    for (x <- 1 to 100 by 5;  jl1 = true; y <- x to x + 4; jl1 = false) {
      println(y)
    }
  }
}
