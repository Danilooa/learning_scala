package com.learning.scala.chapter4.functions

object Chapter4Exercise_02_InputAsStringToAreaFunction {

  def area(radious: String): Double = {
    radious.isEmpty match {
      case true => 0
      case false => Math.PI * Math.pow(radious.toDouble, 2)
    }
  }

  def main(args: Array[String]): Unit = {
    println(f"${area("8")}%.2f")
    println(f"${area("")}%.2f")
  }

}
