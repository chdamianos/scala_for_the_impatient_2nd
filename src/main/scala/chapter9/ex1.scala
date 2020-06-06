package chapter9

import java.io.PrintWriter

import scala.io.Source
import scala.jdk.CollectionConverters.getClass

object ex1 extends App{

  val testFile = getClass.getResource("/chapter9ex1.txt").getPath
  val source = Source.fromFile(testFile, "UTF-8")
  val lineIterator = source.getLines.toBuffer.reverse
  source.close()
  val writeOut = new PrintWriter(testFile)
  for (l <- lineIterator) {
    println(l)
    writeOut.println(l)
  }
  writeOut.close()
}


