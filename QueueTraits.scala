abstract class IntQueue {
    def get() : Int
    def put(x: Int) : Unit
}

trait Doubling extends IntQueue{
    abstract override def put(x: Int) : Unit = { super.put(2*x)}
}

trait Filtering extends IntQueue {
    abstract override def put(x:Int) : Unit = { if (x >= 0) super.put(x)}
}

trait Incrementing extends IntQueue {
    abstract override def put(x:Int) : Unit = { super.put(x+1)}
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
    
    val buf = new ArrayBuffer[Int]
    def get(): Int = buf.remove(0)
    def put(x: Int) : Unit = { buf += x }
    
    def list  = buf.foreach(println)
}

val myqueue = new BasicIntQueue with Doubling // using the required trait directly when defining an instance of a class

val newqueue = (new BasicIntQueue with Incrementing with Doubling with Filtering) // order of mixins follows a rule:
                                    // traits further to the right take effect first

val newqueue1 = (new BasicIntQueue with Doubling with Incrementing)