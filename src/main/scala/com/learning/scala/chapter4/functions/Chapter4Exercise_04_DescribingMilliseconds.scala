package com.learning.scala.chapter4.functions

import TimeUnit.{hour, minute, second}

import scala.language.postfixOps

sealed trait TimeUnit

object TimeUnit {
  case object days extends TimeUnit

  case object hour extends TimeUnit

  case object minute extends TimeUnit

  case object second extends TimeUnit
}

object Chapter4Exercise_04_DescribingMilliseconds {

  def millisecondsTo(millis: Long, timeUnit: TimeUnit): Long = {
    timeUnit match {
      case TimeUnit.second => millis / 1000
      case TimeUnit.minute => millisecondsTo(millis, second) / 60
      case TimeUnit.hour => millisecondsTo(millis, minute) / 60
      case TimeUnit.days => millisecondsTo(millis, hour) / 24
      case _ => 0
    }
  }

  def main(args: Array[String]): Unit = {
    println(s"${millisecondsTo(123456789000L, TimeUnit.days)}")
  }

}
