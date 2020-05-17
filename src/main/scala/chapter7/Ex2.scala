object Ex2 extends App {
  import p1.p2.com._
  val inst = new Ex2a
  println(inst.hello())
}

package p1.p2.com {

  class Ex2a {
    def hello(): Unit = println("Hi!")
  }

}
