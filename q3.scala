class Account(initialBalance: Double) {
  var balance = initialBalance
  
  def withdraw(amount: Double): Unit = {
      balance -= amount
      println(s"Withdrew $amount. Updated balance: $balance")
  }
    def deposit(amount: Double): Unit = {
      balance += amount
      println(s"Deposited $amount. Updated balance: $balance")
  }
  def transfer(amount: Double, targetAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      targetAccount.deposit(amount)
      println(s"Transferred $amount to mentioned account.")
    } else {
      println("insufficient balance.")
    }
  }
  
  def getBalance: Double = balance
}

object Main {
  def main(args: Array[String]): Unit = {
    val acc1 = new Account(1500.0)
    val acc2 = new Account(5000.0)
    
    acc1.deposit(300.0)
    acc1.withdraw(100.0)
    acc1.transfer(400.0, acc2)
    
    println(s"Account 1 balance: ${acc1.getBalance}")
    println(s"Account 2 balance: ${acc2.getBalance}")
  }
}
