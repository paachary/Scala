package bobdelights

abstract class Fruit (
    val name : String,
    val color : String
)

object Fruits {
    object Apple extends Fruit("apple","red")
    object Orange extends Fruit("orange","orange")
    object Pear extends Fruit ("pear","yellowish")

    val menu = List(Apple, Orange, Pear)
}

package object bobdelights {
    def showFruit(fruit: Fruit) = {
        import fruit._
        println(s"${name}s are ${color}")
    }
}