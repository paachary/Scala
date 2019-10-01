class ClassExample {

    private [this] var newvar :String = ""

    var var1 = 0

    def var2 :String = newvar
    def var2_= (x: String) = {newvar = x}
}

class Time {
    private[this] var h = 12
    private[this] var m = 0
    def hour: Int = h
    def hour_=(x: Int) = { h = x }

    def minute : Int = m
    def minute_=  
        (x: Int) = { m = x }
    
    }


    class Thermometer {
        var celsius: Float = _
        def fahrenheit = celsius * 9 / 5 + 32
        def fahrenheit_= (f: Float) = {
        celsius = (f - 32) * 5 / 9
        }
        override def toString = s"${fahrenheit} F/ ${celsius} C"
    }