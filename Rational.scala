class Rational(n : Int, d:Int)   {// n & d -> class parameters     
    require( d != 0 ) // data quality pre-check ; denominator in a rational number must never be 0

    val numer : Int = n
    val denom : Int = d
        
    override def toString = s"${numer} / ${denom}" // normal println would display the class with a hexadecimal value.
    
    def add( that : Rational ) : Rational = {
        new Rational ( numer * that.denom + denom * that.numer , denom * that.denom )
    }
}