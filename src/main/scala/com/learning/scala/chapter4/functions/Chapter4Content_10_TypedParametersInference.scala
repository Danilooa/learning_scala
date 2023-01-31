package com.learning.scala.chapter4.functions

object Chapter4Content_10_TypedParametersInference {
  def doAnything[A](parameter: A): A = {
    parameter
  }

  //With explicit types
  val result1: String = doAnything[String]("2")

  //With type inference
  val result2: String = doAnything("2")

}
