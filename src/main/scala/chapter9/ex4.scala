package chapter9

import chapter9.ex3.getClass

import scala.io.Source

object ex4 extends App{
  val testFile = getClass.getResource("/chapter9ex4.txt").getPath
  val source = Source.fromFile(testFile, "UTF-8")
  val nums: Array[Double] = source.mkString.split("""\s+""").map(_.toDouble)
  val sum_ = nums.sum
  val ave_ = nums.sum/nums.length
  val max_ = nums.max
  val min_ = nums.min
  println(f"""sum = $sum_ average = $ave_ max = $max_ min = $min_""")

  source.close()
}
