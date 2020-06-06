package chapter9

import chapter9.ex2.getClass

import scala.io.Source

object ex3 extends App {
  val testFile = getClass.getResource("/chapter9ex3.txt").getPath
  val source = Source.fromFile(testFile, "UTF-8")
  source.mkString.split("""\s+""").filter(_.length>12).foreach(println)
  source.close()

}
