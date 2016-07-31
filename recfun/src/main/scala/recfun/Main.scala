package recfun

object Main {
  def main(args: Array[String]) {
    
    /*
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
*/
    println("=====================================")
    println(countChange(3, List(1,2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

    
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    /*
     * extract all parentheses as a string and order is preserved 
     */
    def extractParentheses(chs: List[Char]): String =
      if (chs.isEmpty) ""
      else if (chs.head.toString == "(") "L" + extractParentheses(chs.tail)
      else if (chs.head.toString == ")") "R" + extractParentheses(chs.tail)
      else extractParentheses(chs.tail)

    /*
     * check if parentheses is paired correctly  
     */
    def isPaired(x: String): Boolean = {
      val y = x.replaceAll("LR", "")
      if (y == "") true
      else if (y.indexOf("LR") > -1) isPaired(y)
      else false
    }

    isPaired(extractParentheses(chars))
  }

  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
    def count(x: Int, y: Int): Int = 
      if(x % y == 0) 1
      else 0
      
    if(money == 0) 0
    else if(coins.isEmpty) 0
    else if(coins.size == 1) count(money, coins.head) 
    else {
      val c = coins.head
      val v = (0 to money/c).map(money - _*c).toList
      val cnt = v.map(r => countChange(r, coins.tail)).reduce((x, y) => x + y)
      
      cnt + count(money, coins.head)
    }
  }
}
