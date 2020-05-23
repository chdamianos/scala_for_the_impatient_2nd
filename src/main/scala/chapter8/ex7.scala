package chapter8


object ex7 extends App {
  val sq1 = new Square((2, 3), 10)
  println(sq1)
  val sq2 = new Square(10)
  println(sq2)
  val sq3 = new Square()
  println(sq3)
  val sq3alt = new SquareAlt()
  println(sq3alt)
}

class Square extends java.awt.Rectangle {
  def this(corner: (Int, Int), width: Int) {
    this()
    this.x = corner._1
    this.y = corner._2
    this.height = width
    this.width = width
  }

  def this(width: Int) {
    this((0, 0), width)
  }

  def this(default: String = "default") {
    this((0, 0), 0)
  }


}

class SquareAlt(x: Int, y: Int, size: Int) extends java.awt.Rectangle(x, y, size, size) {
  def this(size: Int) = this(0, 0, size)

  def this() = this(0, 0, 0)
}