package chapter8

object ex2 extends App {
  val bnk2 = new SavingsAccount(initialBalance = 10.0)
  bnk2.deposit(amount = 1.0)
  println(bnk2.currentBalance)
  bnk2.deposit(amount = 1.0)
  println(bnk2.currentBalance)
  bnk2.deposit(amount = 1.0)
  println(bnk2.currentBalance)
  bnk2.deposit(amount = 1.0)
  println(bnk2.currentBalance)
  bnk2.earnMonthlyInterest
  println(bnk2.currentBalance)
  bnk2.deposit(amount = 1.0)
  println(bnk2.currentBalance)
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private val chargeAmount: Double = 1.0
  private val interest: Double = 0.01
  private var countDeposit: Int = 0

  def charge() {
    countDeposit += 1
    if (countDeposit > 3) balance -= chargeAmount
  }

  override def deposit(amount: Double): Double = {
    charge()
    super.deposit(amount)
  }


  override def withdraw(amount: Double): Double = {
    charge()
    super.withdraw(amount)
  }

  def earnMonthlyInterest: Double = {
    countDeposit = 0
    balance *= (1.0 + interest)
    balance
  }

}
