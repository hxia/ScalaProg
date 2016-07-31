package example


trait Queue[T] {
  def head: T

  def tail: Queue[T]

  def enqueue(x: T): Queue[T]

//  def xx(xs: T*): Queue[T]
}

object Queue {

  def apply[T](xs: T*): Queue[T] =  xx [T] (xs.toList)
//    new QueueImpl[T](xs.toList, Nil)

  def xx [T] (xs: List[T]): Queue[T] = new QueueImpl[T](xs, Nil)

  private class QueueImpl[T](
                              private val leading: List[T],
                              private val trailing: List[T]
                              ) extends Queue[T] {

    def mirror =
      if (leading.isEmpty) new QueueImpl(trailing.reverse, Nil)
      else this

    def head: T = mirror.leading.head

    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)

    override def toString = leading.mkString(" ") + " " + trailing.mkString(" ")
  }

}
