package com.learning.scala.chapter10.advancedtyping

class A

class B extends A

class C extends B

class TesterInvariantB[T](parameter: T) {
  def testerSomethingB(): T = parameter
}

class TesterVariantB[+T](parameter: T) {
  def testerSomethingB(): T = parameter
}

class TesterCovariantMethodParameter[+T]() {
  //def testerSomethingB(parameter: T): String = "Fails to compile"
}

class TesterContraCovariantMethodParameter[T]() {
  def testerSomethingB(parameter: T): T = parameter
}

object Chapter10Content_04_BoundedTypes {

  //Fails to compile
  //val attemptBtoA: TesterInvariantB[A] = new TesterInvariantB[B](new B)

  //succeeds to compile
  val attemptBtoA: TesterVariantB[A] = new TesterContraCovariantMethodParameter[B]().testerSomethingB(new B)

}

