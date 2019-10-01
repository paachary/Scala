// Refactoring the class element to include the factory methods

//abstract class Element {
//    def contents : Array[String]
//    def height : Int = contents.length
//    def width : Int = if (height == 0) 0 else contents(0).length
//    def demo = println("in element's demo")
//    
//    // this assumes elements having same widths
//    def above(that: Element) : Element = new ArrayElement(this.contents ++ that.contents)
//    
//    def beside(that: Element) : Element = {
//        
//        val contents = new Array[String](this.contents.length)
//    
//        // imperative style of programming
//        /*
//        for (i <- 0 until this.contents.length)
//            contents(i) = this.contents(i) + that.contents(i)
//        
//        new ArrayElement(contents)
//        */
//        
//        // modern functional style of programming
//        
//        new ArrayElement(
//            for (
//                (line1, line2) <- this.contents zip that.contents
//                ) yield line1 + line2
//        )
//    }
//    
//    override def toString = contents mkString "\n"
//}


// defining factor object by means of defining Companion object of class Element

// Now, instead of defining the ArrayElement, LineElement & UniformElement as three publicly available classes,
// we can define them in a single singleton object as Scala allows us to do so.
// They can be declared private as it is accessible only through the factory methods.

object Element {
    
    private class ArrayElement(val contents : Array[String]) extends Element {
    }
    
    private class LineElement (s: String) extends Element {
        val contents = Array(s)
        override def width = s.length
        override def height = 1
    }
    
    private class UniformElement(
        ch: Char,
        override val width: Int,
        override val height: Int
    ) extends Element {
        private val line = ch.toString * width
        def contents = Array.fill(height)(line)
    }
    
    def elem(contents : Array[String]) : Element = new ArrayElement(contents)
    
    def elem(line: String) : Element = new LineElement(line)
    
    def elem(chr: Char, width: Int, height: Int) : Element = new UniformElement(chr, width, height)
}


import Element.elem
abstract class Element{ 
    def contents : Array[String]
    def height : Int = contents.length
    def width : Int = if (height == 0) 0 else contents(0).length    

    def above(that: Element) : Element = {
        
        val this1 = this widen that.width
        val this2 = that widen this.width
        
        elem(this1.contents ++ this2.contents)
    }

    def beside(that: Element) : Element = {
        
        val this1 = this heighten that.height
        val this2 = that heighten this.height

        elem(
            for (
                (line1, line2) <- this1.contents zip this2.contents
                ) yield line1 + line2
        )
    }
    
    def heighten(h: Int) : Element = 
        if ( h <= height) this
        else {
            val top = elem(' ', width, (h - height) / 2)
            val bot = elem(' ',width, h - height - top.height)
            top above this above bot
        }

    
    def widen(w: Int) : Element =
        if ( w <= width) this
        else {
            val left = elem(' ', (w-width /2), height)
            val right = elem(' ',w-width-left.width, height)
            left beside this beside right
        }

    override def toString = contents mkString "\n"
}

import Element.elem

object Spiral {
    val space = elem(" ")
    val corner = elem("+")
    
    def spiral(nEdges: Int, direction: Int): Element = {
        if (nEdges == 1)
            elem("+")
        else {
            val sp = spiral(nEdges - 1, (direction + 3) % 4)
            def verticalBar = elem('|', 1, sp.height)
            def horizontalBar = elem('-', sp.width, 1)
            if (direction == 0)
                (corner beside horizontalBar) above (sp beside space)
            else if (direction == 1)
                (sp above space) beside (corner above verticalBar)
            else if (direction == 2)
                (space beside sp) above (horizontalBar beside corner)
            else
                (verticalBar above corner) beside (space above sp)
        }
    }
    
    def main(args: Array[String]) = {
        val nSides = args(0).toInt
        println(spiral(nSides, 0))
    }
}