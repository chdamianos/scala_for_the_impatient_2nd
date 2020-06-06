package chapter9

import chapter9.ex1.getClass

import scala.io.Source

object ex2 extends App{

  val testFile = getClass.getResource("/chapter9ex2.txt").getPath
  val source = Source.fromFile(testFile, "UTF-8")
  val iter = source.buffered.mkString("\t")
  for (i <- iter) {
    println(i=="\t")
  }

}
