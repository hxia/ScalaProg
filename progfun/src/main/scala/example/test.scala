package example

/**
 * Created by haxia on 5/28/2016.
 */
object test {

  def main(args: Array[String]) {
    val q: Queue[Int] = Queue[Int](1,2,3)
    println(q.toString)
    println(q.head)
    println(q.tail.toString)

    val q1 = q.enqueue(9)
    println(q1.head)
    println(q1.tail.toString)

    println(q1.toString)

  }

}
