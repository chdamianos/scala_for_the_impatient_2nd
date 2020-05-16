/*1*/
class Counter {
  private var value = Int.MaxValue

  def increment() {
    if (value + 1 < 0) value = 0 else value += 1
  }

  def current() = value
}

val myCounter = new Counter
myCounter.increment()
println(myCounter.current())

/*2*/
class BankAccount {
  private var _balance = 0.0

  def deposit(amount: Double): Unit = {
    if ((_balance + amount) >= Double.MaxValue) throw new ArithmeticException("balance overflow")
    _balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if ((_balance - amount) < Double.MinValue) throw new ArithmeticException("balance underlow")
    if ((_balance - amount) < 0) throw new IllegalStateException("not enough funds")
    _balance -= amount
  }

  def balance = _balance

}

val myAccount = new BankAccount
println(myAccount.balance)
myAccount.deposit(10)
println(myAccount.balance)
myAccount.withdraw(5)
println(myAccount.balance)

//myAccount.withdraw(50)
//println(myAccount.balance)
//myAccount.deposit(Double.MaxValue)
//println(myAccount.balance)
/*3*/
class Time(val hours: Int, val minutes: Int) {
  if (0 > hours || hours > 23) throw new IllegalStateException("illegal hour format")
  if (0 > minutes || minutes > 59) throw new IllegalStateException("illegal minute format")

  def before(other: Time): Boolean = {
    if (other.hours > hours) {
      true
    } else if (other.hours == hours && other.minutes > minutes) {
      true
    } else {
      false
    }
  }

  override def toString: String = hours + ":" + minutes
}

val myTime = new Time(0, 0)
println(myTime)
val anotherTime = new Time(23, 0)
myTime.before(anotherTime)
println(myTime.hours)
println(myTime.minutes)

/*4*/
class TimeNew(val hours: Int, val minutes: Int) {
  if (0 > hours || hours > 23) throw new IllegalStateException("illegal hour format")
  if (0 > minutes || minutes > 59) throw new IllegalStateException("illegal minute format")
  private val internalTime = hours * 60 + minutes

  def before(other: TimeNew): Boolean = {
    if (other.internalTime > internalTime) {
      true
    } else {
      false
    }
  }

  override def toString: String = hours + ":" + minutes
}

val myNewTime = new TimeNew(0, 0)
println(myTime)
val anotherNewTime = new TimeNew(23, 0)
myNewTime.before(anotherNewTime)
println(myNewTime.hours)
println(myNewTime.minutes)
/*5*/

import scala.beans.BeanProperty

class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {

}

/*
scala> :javap -public Student
Compiled from "<console>"
public class $line5.$read$$iw$$iw$Student {
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public long id();
  public void id_$eq(long);
  public long getId();
  public java.lang.String getName();
  public void setId(long);
  public void setName(java.lang.String);
  public $line5.$read$$iw$$iw$Student(java.lang.String, long);
}
 */
val student1 = new Student("John", 123)
student1.setName("Andrew")
println(student1.getName)

/*No we shouldn't use these BeanProperty methods since they are a java naming
 convention
*/

/*6*/
class Person(a: Int) {
  var age: Int = _
  if (a < 0) age = 0
}

val fred = new Person(-10)
println(fred.age)
fred.age = 20
println(fred.age)

/*7*/
class Person1(val input: String) {
  private val splitString = input.split(" ", 2)
  val firstName = splitString(0)
  val lastName = splitString(1)
}

class PersonAlt(_fullName: String) {
  val (firstName, lastName) = _fullName.split(" ") match {
    case Array(x: String, y: String, _*) => (x, y)
    case _ => (null, null)
  }
}

val john = new Person1("John Smith")
println(john.firstName)
println(john.lastName)
val john1 = new PersonAlt("John Smith")
println(john1.firstName)
println(john1.lastName)

/*8*/
class Car(val manufacturer: String, val model: String, val year: Int,
          var licencePlate: String) {
  def this(manufacturer: String, model: String, year: Int) {
    this(manufacturer, model, year, "")
  }

  def this(manufacturer: String, model: String, licencePlate: String) {
    this(manufacturer, model, -1, licencePlate)
  }

  def this(manufacturer: String, model: String) {
    this(manufacturer, model, -1, "")
  }
}

val car1 = new Car("fiat", "500")
println(car1.manufacturer)
println(car1.model)
println(car1.year)
println(car1.licencePlate)

/*10*/
class Employee(val name: String, var salary: Double) {
  def this() {
    this("John W. Public", 0.0)
  }
}

class Employee(val name: String = "John W. Public", var salary: Double = 0.0)