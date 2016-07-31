package example

import scala.util.parsing.combinator._

class Arith extends JavaTokenParsers {

  def expr: Parser[Any] = term~rep("+"~term | "-"~term)

  def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)

  def factor: Parser[Any] = floatingPointNumber | "("~expr~")"
}


object ParseExpr extends Arith {
  def main(args: Array[String]): Unit ={
    if(args.equals(null) || args.size == 0){
      val a = Array("2 * (3 + 7 )")
      println("input : " + a(0))
      println(parseAll(expr, a(0)))
    } else {
      println("input : " + args(0))
      println(parseAll(expr, args(0)))
    }
  }

}
