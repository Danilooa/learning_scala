package com.learning.scala.chapter7.more.collections

import scala.language.postfixOps
import scala.util.Random



object Chapter7Content_04_LazyList {

  def main(args: Array[String]): Unit = {

    //Randomly function that generates a list that could be infinity or finish radomly
    def lazyListHead(): LazyList[Customer] = {
      val index = Random.between(0, Customer.allUsers.size)
      val customer = Customer.allUsers(index)
      //Randomly finishes the collection deciding to return empty to finish or a recursive call to continue
      val tail = if (index % 20 == 0) LazyList.empty else lazyListHead
      customer.copy(name = customer.name + s" $index") #:: tail
    }

    val lazyCustomers: LazyList[Customer] = lazyListHead()

    println(lazyCustomers.takeWhile(_.id % 9 != 0).map(c => c).mkString("\n") + "\n" + lazyCustomers.size)

  }

}
