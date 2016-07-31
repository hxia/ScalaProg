package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  
  
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
        
    val u1 = union(s1, s2)
    printSet(u1)
    
    val s = Set(1,3,4,5,6,7,1000)
    printSet(s.map(x => x-1))
    
    println ("====== test filter =====")
    printSet(filter(s, x => x > 10))
    
    println("forall:" + forall(s, x => x > 0))
    println("forall:" + forall(s, x => x > 1))
    
    println("exists:" + exists(s, x => x > 100))
    println("exists1:" + exists1(s, x => x > 100))
}
