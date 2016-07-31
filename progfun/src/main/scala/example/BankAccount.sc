
trait Account  {
  def balance: Int
  def deposit(x: Int): Unit
  def withdraw(x: Int): Boolean
}

object Account {

   new BankAccount()

  private class BankAccount extends Account {
    private var bal: Int = 0

    def balance: Int = bal

    def deposit(amount: Int) {
      require(amount > 0)
      bal += amount
    }

    def withdraw(amount: Int): Boolean = {
      if (amount > bal) false
      else {
        bal -= amount
        true
      }
    }
  }


}
//b1.deposit(100)
//b1.withdraw(20)
//b1.balance
//b1.deposit(10)
//b1.balance
//b1 deposit 100
//b1 balance