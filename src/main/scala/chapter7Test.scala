import chapter7.random._
import chapter7.random.someClass

import scala.collection.immutable.HashMap

object chapter7Test extends App {
  setSeed(10)
  println(nextInt())
  println(nextDouble())
  println(nextDouble())
  val inst = new someClass
  inst.sayHello()

}

object testEx6 extends App {
  import chapter7.ex6.copyHash
  val map1 = HashMap("C"->"Csharp", "S"->"Scala", "J"->"Java")
  val javaMap1 = copyHash(map1)
  println(javaMap1)
}

object testEx9 extends App {
  import chapter7.ex9._
  passTest()

}

