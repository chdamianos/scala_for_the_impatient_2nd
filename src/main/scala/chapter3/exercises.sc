/*1*/

import scala.collection.JavaConverters
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

val n: Int = 11
val a = new Array[Int](n)
for (i <- a.indices) a(i) = Random.between(0, n)
a
/*2*/

val maxInd = (2 * (a.length / 2).floor).toInt
for (i <- 1 until maxInd by 2) {
  val nextElem = a(i)
  val prevElem = a(i - 1)
  a(i) = prevElem
  a(i - 1) = nextElem
}
a
/*3*/
def swapNewArray(x: Array[Int]): Array[Int] = {
  val newA = for (i <- a.indices) yield
    if (i % 2 == 0 && i < a.length - 1)
      a(i + 1)
    else if (i % 2 == 0)
      a(i)
    else
      a(i - 1)
  newA.toArray
}
swapNewArray(a)
/*4*/
val testArray = Array(1, 2, -1, 3, 4, 0, 5, -10)
val positiveInds = for (i <- testArray.indices if testArray(i) > 0) yield i
val negativeInds = for (i <- testArray.indices if testArray(i) <= 0) yield i
val sortedInds = positiveInds.appendedAll(negativeInds)
val sortedTestArray = for (i <- sortedInds) yield testArray(i)
// alternative
testArray.filter(_ > 0) ++ testArray.filter(_ <= 0)
/*5*/
val testArrayDouble = Array(1.0, 2, -1, 3, 4, 0, 5, -10)
testArrayDouble.sum / testArrayDouble.length
/*6*/
def reverseSorted(x: Array[Int]): Array[Int] = {
  x.sorted.reverse
}
testArray
reverseSorted(testArray)
// alternative
testArray.sortWith(_ > _)
/*7*/
val testArrayDup = Array(1, 2, 1, 3, 4, 2, 5, -10)
testArrayDup.distinct
/*8*/
def fun8(a: ArrayBuffer[Int]): Unit = {
  println(s"Before: $a")
  a.indices.filter(a(_) < 0).reverse.dropRight(1).foreach(a.remove)
  println(s"After: $a")
}
fun8(ArrayBuffer(1, 2, 3))
fun8(ArrayBuffer(1, 5, -3, 2, -5, 0, 6))
fun8(ArrayBuffer(1, 2, 3, -4, 5, -6, 7, -8))
/*9*/
def removeNegTrailing(a: ArrayBuffer[Int]): Unit = {
  val indicesLTzero = a.indices.filter(a(_) < 0)
  val indicesToremove = indicesLTzero.drop(1)
  val indicesToKeep = for (i <- a.indices if !(indicesToremove contains i)) yield i
  for (i <- indicesToKeep.indices) {
    a(i) = a(indicesToKeep(i))
  }
  a.trimEnd(indicesToremove.length)
}
val a1 = ArrayBuffer(1, 2, 3, -4, 5, -6, 7, -8)
removeNegTrailing(a1)
println(a1)
val a2 = ArrayBuffer(1, 2, 3, -4, 5)
removeNegTrailing(a2)
println(a2)
val a3 = ArrayBuffer(1)
removeNegTrailing(a3)
println(a3)
/*10*/

import java.util.TimeZone.getAvailableIDs

val prefix = "America/"
val sortedAmericaTz = (for {
  tz <- getAvailableIDs
  if tz.startsWith(prefix)
} yield tz).map(_.drop(prefix.length)).sortWith(_ < _)
/*11*/

import java.awt.datatransfer._
import scala.jdk.CollectionConverters._
val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val nativeFavors = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
val nativeFlavorsScala = nativeFavors.asScala
