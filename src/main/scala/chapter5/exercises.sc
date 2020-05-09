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
