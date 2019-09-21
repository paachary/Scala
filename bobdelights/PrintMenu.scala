package printmenu

import bobdelights.Fruits
import bobdelights.bobdelights.showFruit
object PrintMenu{
    def main(args: Array[String]) : Unit = {
        for (fruit <- Fruits.menu)
              showFruit(fruit)
    }
}
