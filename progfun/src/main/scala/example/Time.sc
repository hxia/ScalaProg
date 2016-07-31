class Time {
//  private[this] var h = 12
//  private[this] var m = 10
  var hour = 12
  var minute = 10
  var k: Int = _
  k = 10
//  def hour: Int = h
//  def hour_=(x: Int) {
//    h = x
//  }
//  def minute: Int = m
//  def minute_=(x: Int) {
//    m = x
//  }
  override def toString = hour + ":" + minute
}
val t1 = new Time()
t1.hour
t1.minute
t1.hour = 7
t1
var k = 0
