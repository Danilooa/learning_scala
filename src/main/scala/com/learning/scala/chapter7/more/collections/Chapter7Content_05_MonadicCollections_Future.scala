package com.learning.scala.chapter7.more.collections

import concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Chapter7Content_05_MonadicCollections_Future {

  def main(args: Array[String]): Unit = {

    def doSomething(timeToWait: Int): String = {
      Thread.sleep(timeToWait)
      s"Something was done after waiting $timeToWait"
    }


    val doSomethingFuture = Future {
      println(5000)
      doSomething(5000)
    }

    val eventualString = doSomethingFuture.flatMap(x => Future[String] {
      println(0)
      doSomething(0)
    })

    val functionToFuture = eventualString.map(x => x)

    functionToFuture.onComplete( _ match {
      case Success(value) => println(value)
      case Failure(exception) => println(exception)
      case _ => println("none")
    })

    val wouldBlock = Future{ "doesnt block, the next line will print only the future reference"}
      .map(r => {
        println("when it will println")
        r
      })
    println("doesnt print what is expected: " + wouldBlock)

    Thread.sleep(10_000)
  }


}
