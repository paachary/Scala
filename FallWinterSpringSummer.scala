import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {

  for ( list <- args ) 
    println(list + ":" + calculate(list))
}
