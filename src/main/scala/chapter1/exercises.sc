/*1*/
val three = 3
//three.
// 3d.
/*2*/

import scala.math.sqrt

sqrt(2)
/*3*/
//res0=res0+1 error: reassignment to val
/*4*/
"scala" * 3
// https://www.scala-lang.org/api/current/scala/collection/StringOps.html
/*5*/
10 max 2
// max is defined in the RichInt class
/*6*/

import scala.math.pow

BigInt(pow(2, 32).toInt) * BigInt(pow(2, 32).toInt)
/*7*/

import scala.BigInt.probablePrime
import scala.util.Random

probablePrime(100, Random)
/*8*/
BigInt.apply(64, Random).toString(36)
/*9*/
val someString = "12345"
someString(0)
someString(someString.length - 1)
someString.last
/*10*/
someString.take(2)
someString.drop(3)
someString.takeRight(3)
someString.dropRight(3)
someString.substring(0, 2)
// with substring it would take more code to drop and also for
// the other functions