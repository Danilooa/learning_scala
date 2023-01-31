package com.learning.scala.chapter4.functions

object Chapter4Content_3_FunctionInvocationWithExpressionBlocks {
  def byTen(anyNumber: Double): Double = {
    anyNumber * 10
  }

  def main(args: Array[String]): Unit = {
    val input = 100
    val d = byTen {
      val x = 10
      val y = x * 10
      val z = y * 10
      z
    }
    println(d)
  }
}
