package com.learning.scala.chapter4.functions

import scala.language.postfixOps

object Chapter4Exercise_08_StringRepresentation {

  def plusStringRepresentation[A, B, C](t: (A, B, C)): (A, String, B, String, C, String) = {
    (t._1, s"'${t._1.toString}'", t._2, s"'${t._2.toString}'", t._3, s"'${t._3.toString}'")
  }

  def main(args: Array[String]): Unit = {
    println(plusStringRepresentation(BigDecimal(0), 123.0, true))
  }

}
