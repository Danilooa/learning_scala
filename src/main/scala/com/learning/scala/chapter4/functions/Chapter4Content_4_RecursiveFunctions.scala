package com.learning.scala.chapter4.functions

object Chapter4Content_4_RecursiveFunctions {
  @annotation.tailrec
  def power(x: Int, n: Int, t: Int = 1): Int = {
    if (n < 1) t
    else power(x, n-1, x*t)
  }
  def main(args: Array[String]): Unit = {
    println(power({val x = 2 + 2; x;}, 2, 2))
  }
}
