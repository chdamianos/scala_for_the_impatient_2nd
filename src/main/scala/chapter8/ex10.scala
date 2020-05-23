package chapter8

object ex10 extends App {
  //A protected constructor can only be accessed by an auxiliary constructor from same or descendant class
  val P = new Employee("John", age = 42)
  val M = new Manager("Paul")

}

class Employee protected(protected val name: String) {
  def this(n: String, age: Int) {
    this(n)
  }
}

class Manager(n: String) extends Employee(n)