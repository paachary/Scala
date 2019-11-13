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

    override def toString(): String = s"${hour} : ${minute}"
}

class Thermometer {
    var celsius: Float = _
    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_= (f: Float) = {
    celsius = (f - 32) * 5 / 9
    }
    override def toString = s"${fahrenheit} F/ ${celsius} C"
}

trait Queue[+A] {
    def head : A

    def tail: Queue[A]

    def enqueue[U >: A] (x:U): Queue[U]
}
object  Queue { 
    def apply[A](xs: A*): Queue[A] = new QueueImpl[A](xs.toList, Nil)

    private class QueueImpl[+A]  ( 
        private val leading: List[A],
        private val trailing: List[A]
    ) extends Queue[A]{

        override def toString(): String = leading:::trailing mkString " "

        def mirror = if (leading.isEmpty) 
                        new QueueImpl(trailing.reverse, Nil) 
                    else 
                        this

        def head = mirror.leading.head 
        
        def tail :QueueImpl[A] = {
            val q = mirror
            new QueueImpl(q.leading.tail, q.trailing)
        } 
        
        def enqueue[U >: A] (x:U) = new QueueImpl(leading, x::trailing)
    } 
}

class Publication(val title: String)

class Book(title: String) extends Publication(title)

object Library {

    val books : Set[Book] = 
    Set(
        new Book("Programming in Scala"),
        new Book("Prashant's book")
    )

    def printBookList(info: Book => AnyRef) = {
        for (book <- books) println(info(book))
    }
}

object Customer extends App {
    def getTitle(p : Publication) : String = p.title

    Library.printBookList(getTitle)
}

abstract class CurrencyZone {
    
    type Currency <: AbstractCurrency

    def make(x: Long) : Currency

    abstract class AbstractCurrency {
        val amount : Long
        def designation : String

        def + (that: Currency) : Currency = 
            make(this.amount + that.amount)

        def - (that: Currency) : Currency = 
            make(this.amount - that.amount)

        def / (that: Currency) : Currency = 
            make(this.amount / that.amount)

        def / (that: Double) : Currency = 
            make((this.amount / that).toLong)

        def * (that: Currency) : Currency = 
            make(this.amount * that.amount)

        def * (that: Double) : Currency = 
            make((this.amount * that).toLong)

        def from(other: CurrencyZone#AbstractCurrency) : Currency =
          make(math.round(other.amount.toDouble *  
            Converter.exchangeRate(other.designation)(this.designation)))

        def decimals(n:Long) : Int = 
            if (n == 1) 0 else 1 + decimals(n/10)

        override def toString(): String = ((amount.toDouble / CurrencyUnit.amount.toDouble)
            formatted("%." + decimals(CurrencyUnit.amount)+"f") + " " + designation)
    }
    val CurrencyUnit : Currency;
}

object Converter{
    var exchangeRate = Map (
        "USD" -> Map("USD" -> 1.0, "EUR" -> 0.91,
                     "INR" -> 71.2),
        "EUR" -> Map("USD" -> 1.10, "EUR" -> 1.0,
                     "INR" -> 77.99),
        "INR" -> Map("USD" -> 0.0014, "EUR" -> 0.013,
                     "INR" -> 1.0)        
    )
}

object US extends CurrencyZone {
    abstract class Dollar extends AbstractCurrency{
        def designation: String = "USD"
    }
    type Currency = Dollar
    def make(cents: Long): Dollar = new Dollar {val amount: Long = cents}

    val Cent = make(1)
    val Dollar = make(100)
    val CurrencyUnit: Dollar = Dollar
}

object Europe extends CurrencyZone {
    abstract class Euro extends AbstractCurrency{
        def designation: String = "EUR"
    }
    type Currency = Euro
    def make(cents: Long): Euro = new Euro {val amount: Long = cents}

    val Cent = make(1)
    val Euro = make(100)
    val CurrencyUnit : Euro = Euro
}

object India extends CurrencyZone {
    abstract class Rupee extends AbstractCurrency{
        def designation: String = "INR"
    }

    type Currency = Rupee
    def make(paisa: Long): Rupee = new Rupee {val amount: Long = paisa}

    val Paisa = make(1)
    val Rupee = make(100)
    val CurrencyUnit: Rupee = Rupee
}

abstract class Person( firstName: String, lastName : String, dob: String) {

    val g_dob = dob

    override def toString(): String = s"${firstName}:${lastName}:${g_dob}"
}

trait PersonTrait extends Person{
    def calculateAge : Long = {
        import java.time.format.DateTimeFormatter
        import java.time.LocalDate

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val local_dob = LocalDate.parse(g_dob, formatter)
        val age  = (LocalDate.now.toEpochDay() - local_dob.toEpochDay()) / 365
        age
    }
}

case class Employee (firstName: String, lastName: String, dob: String) 
        extends Person (firstName, lastName, dob) with PersonTrait

object Person {
    def identifyEmployee ( emp: Employee) : String = emp match {

        case Employee("Prashant", "Acharya" , _) => "This is me, myself, moi"
        case Employee("Prashant",_,_) => "This is not probably me..."
        case _ => "Are you sure, Etes-vous sure???"
    }

    def compareEmployees(emp1: Employee, emp2: Employee) : Boolean = 
        if (emp1.equals(emp2)) true else false
}