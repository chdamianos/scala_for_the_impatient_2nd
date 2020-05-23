package chapter8
/**
 * Solution:
 *
 * When we use def in both superclass and subclass the array length is initialized with expected,
 * overrided value 2. This happens because there is no field to hold the value, and we don't have
 * initialization order problem.
 *
 * But when we use def in superclass and val in subclass initialization order problem is back
 * again. Since now the range value in subclass is backed by field and at the moment when
 * corresponding generated range getter method is called from superclass constructor the value is
 * not initialized yet and equals to 0 by default.
 */
object ex9 extends App {
  val c1 = new Creature
  println(c1.range)
  println(c1.env.length)
  //Def range is defined before primary constructor call =>
  val a1 = new AntDef
  println(a1.range)
  println(a1.env.length)
  //Val range is defined after primary constructor call =>
  val a2 = new AntVal
  println(a2.range)
  println(a2.env.length)
}

class Creature {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class AntDef extends Creature {
  override def range: Int = 2
}

class AntVal extends Creature {
  override val range: Int = 5
}