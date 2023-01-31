package com.learning.scala.chapter4.functions

object Chapter4Content_5_NestedFunctions {
  def max(a: Int, b: Int, c: Int): Int = {
    def max(x: Int, y: Int) = if (x > y) x else y
    max(a, max(b, c))
  }

  def main(args: Array[String]): Unit = {
    println(max({
      val x = 2 + 2; x;
    }, 2, 2))
  }
}
