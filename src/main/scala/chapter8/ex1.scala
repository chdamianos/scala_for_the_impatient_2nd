package chapter8

object ex1 extends App {
  val bnk1 = new BankAccount(initialBalance = 10.0)
  println(bnk1.currentBalance)
  bnk1.deposit(1.0)
  println(bnk1.currentBalance)
  val bnk2 = new CheckingAccount(initialBalance = 10.0)
  println(bnk2.currentBalance)
  bnk2.deposit(amount = 1.0)
  println(bnk2.currentBalance)
  bnk2.withdraw(amount = 1.0)
  println(bnk2.currentBalance)
}

class BankAccount(initialBalance: Double) {
  protected var balance: Double = initialBalance

  def currentBalance: Double = balance

  def deposit(amount: Double): Double = {
    balance += amount;
    balance
  }

  def withdraw(amount: Double): Double = {
    balance -= amount;
    balance
  }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {
  private val chargeAmount = 1.0

  override def deposit(amount: Double): Double = {
    super.deposit(amount - chargeAmount)
  }


  override def withdraw(amount: Double): Double = {
    super.withdraw(amount + chargeAmount)
  }

}