import java.util

import scala.collection.SortedMap
import scala.io.Source
import scala.jdk.CollectionConverters._

/*1*/
val gizmos = Map("monitor" -> 10, "mouse" -> 20)
val gizmosDisc = for ((k, v) <- gizmos) yield (k, v * 0.9)
/*2*/
val testFile = getClass.getResource("/myfile.txt").getPath
val source = Source.fromFile(testFile, "UTF-8")
val tokens = source.mkString.split("\\s+")

val mutMap = scala.collection.mutable.Map[String, Int]()
for (i <- tokens) {
  mutMap(i) = mutMap.getOrElse(i, 0) + 1
}
println(mutMap)
/*3*/
var immuWords = scala.collection.Map[String, Int]()
for (i <- tokens)
  immuWords += (i -> (immuWords.getOrElse(i, 0) + 1))
println(immuWords)
/*4*/
var sortedWords = scala.collection.mutable.SortedMap[String, Int]()
for (i <- tokens)
  sortedWords += (i -> (sortedWords.getOrElse(i, 0) + 1))
println(sortedWords)
/*5*/
val treeJavaMap = new util.TreeMap[String, Int]().asScala
for (i <- tokens)
  if (treeJavaMap contains i) treeJavaMap(i) += 1 else treeJavaMap(i) = 1
println(treeJavaMap)
/*6*/

import java.util.Calendar

val mon = Calendar.MONDAY

val mapDays = scala.collection.mutable.LinkedHashMap("Monday" -> Calendar.MONDAY,
  "Tuesday" -> Calendar.TUESDAY, "Wednesday" -> Calendar.WEDNESDAY,
  "Thursday" -> Calendar.THURSDAY, "Friday" -> Calendar.FRIDAY, "Saturday" -> Calendar.SATURDAY,
  "Sunday" -> Calendar.SUNDAY)
mapDays.foreach(println)
for ((d, c) <- mapDays) println(s"$d -> $c")
/*7*/
val props = java.lang.System.getProperties.asScala
println(props)
val maxKeyLetters = props.maxBy(_._1.length)._1.length
for ((k, v) <- props) {
  val addSpace = maxKeyLetters - k.length
  println(k + " " * addSpace + "|" + v)
}
for ((k, v) <- props) {
  println(k.padTo(maxKeyLetters, " ").mkString + "|" + v)
}
/*8*/
val testArray = Array(2, 1, 3, 4)
def minMax(values: Array[Int]): (Int, Int) = {
  (values.min, values.max)
}
minMax(testArray)
/*9*/
def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
  (values.count(_<v), values.count(_==v), values.count(_>v))
}
lteqgt(testArray, 1)
/*10*/
//use case => find difference between two strings
val diff = "Hello world !".zip("hello world!").filter(t => t._1!=t._2)