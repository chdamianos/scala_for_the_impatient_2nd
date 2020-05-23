package chapter8

import scala.collection.mutable.ArrayBuffer

object ex3 extends App{
  val item1 = new SimpleItem(10.0, "item1")
  println(item1)
  println(item1.price)
  val bundle1 = new Bundle()
  bundle1.addItem(item1)
  println(bundle1.description)
  bundle1.addItem(new SimpleItem(5.0, "item2"))
  println(bundle1.price)
  println(bundle1.description)
}

abstract class Item {
  def price: Double = ???

  def description: String = ???
}

class SimpleItem(override val price: Double, override val description: String) extends Item {
  override def toString: String = f"The price for $description is $$$price"
}

class Bundle extends Item {

  private var items = ArrayBuffer[Item]()

  override def price: Double = items.foldLeft(0.0)(_+_.price)
  override def description: String = items.map(_.description).mkString(",")

  def addItem(i: Item) {
    items += i
  }

}