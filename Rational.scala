class Rational(n : Int, d:Int)   {// n & d -> class parameters     
    require( d != 0 ) // data quality pre-check ; denominator in a rational number must never be 0
    
    def this( n: Int) = this (n , 1)
    
    private val gcdNum = gcd(n.abs, d.abs)

    val numer : Int = n / gcdNum
    val denom : Int = d / gcdNum
        
    override def toString = s"${numer} / ${denom}" // normal println would display the class with a hexadecimal value.    
    
    def add( that : Rational ) : Rational = 
        new Rational ( numer * that.denom + denom * that.numer , denom * that.denom )    
    
    def + (that: Rational) : Rational = add(that)
    
    def + (num : Int) : Rational = new Rational( (num * denom) + numer , denom)
    
    def mul( that: Rational) : Rational = new Rational( numer * that.numer, denom * that.denom)
    
    def * (that : Rational) : Rational = mul(that)
    
    def * (num : Int) : Rational = new Rational(numer * num , denom)
    
    def sub(that: Rational) : Rational = new Rational( numer * that.denom - denom * that.numer , denom * that.denom )
    
    def - (that: Rational) : Rational = sub( that)
    
    def - (num : Int) : Rational = new Rational( numer - (num * denom) , denom)
    
    def div( that: Rational) : Rational = new Rational( numer * that.denom, denom * that.numer)
    
    def / ( that: Rational) : Rational = div(that)
    
    def / (num : Int) : Rational = new Rational(numer , denom * num)
    
    def lessThan( that: Rational) = (this.numer * that.denom) < (this.denom * that.numer)
    
    def max( that : Rational) = if ( this.lessThan(that)) that else this 
    
    def gcd( num1 : Int, num2 : Int) : Int = if ( num2 == 0 ) num1 else gcd ( num2, num1 % num2)    
    
}