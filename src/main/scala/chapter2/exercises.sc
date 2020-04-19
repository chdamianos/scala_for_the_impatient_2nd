/*1*/
def signum(x: Float): Int = if (x > 0) 1 else if (x < 0) -1 else 0
signum(10)
signum(-100)
signum(0)
/*2*/
def emptyBlock(): Unit = {}
emptyBlock()
// Unit
/*3*/
var x: Unit = ()
var y: Int = 1
x = y = 1
println(x)
/*4*/
for (i <- 10 to 0 by -1) println(f"$i")
/*5*/
def countdown(n: Int) {
  for (i <- n to 0 by -1) {
    println(f"$i")
  }
}
countdown(10)
/*5*/
val testString = "Hello"
def isEmpty(x: String) = Option(x).forall(_.isEmpty)
def calcStringProd(x: String): Long =  x match {
  case "" => 1
  case _ => x.head.toLong * calcStringProd(x.tail)
}
calcStringProd(testString)
var prodString: Long = 1
for (ch <- testString) {
  prodString = prodString * ch.toLong
}
println(prodString)
