class Account(initialBalance: Double) {
  var balance = initialBalance
  
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance -= balance * 0.1
    }
  }
  
  def getBalance: Double = balance
}
object Bank {
  def sumBalances(accounts: List[Account]): Double = {
    accounts.map(_.getBalance).sum
  }
  def negativeBalances(accounts: List[Account]): List[Account] = {
    accounts.filter(account => account.getBalance < 0)
  }
  def applyInterestAcc(accounts: List[Account]): Unit = {
    accounts.foreach(_.applyInterest())
  }
  
  def main(args: Array[String]): Unit = {
    val account1 = new Account(2000.0)
    val account2 = new Account(500.0)
    val account3 = new Account(-200.0)
    val account4 = new Account(400.0)
    
    val bankAccounts = List(account1, account2, account3 , account4)
    
    println("negative balance Account:")
    val negativeBalanceAccounts = negativeBalances(bankAccounts)
    negativeBalanceAccounts.foreach(account => println(s"Account balance: ${account.getBalance}"))
    
    val totalBalance = sumBalances(bankAccounts)
    println(s"Total balance of all accounts: $totalBalance")
    
    applyInterestAcc(bankAccounts)
    
    println("Balances of accounts after applying interest:")
    bankAccounts.foreach(account => println(s"Account balance: ${account.getBalance}"))
  }
}
