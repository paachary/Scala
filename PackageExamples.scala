package bobsrocket 
    package navigation {
        private [bobsrocket] class Navigator {
        //class Navigator {
            protected[navigation] def useStarChart()  = {}
            class LegOfJourney {
                //private[Navigator] val distance = 100
                val distance = 140
            }
            private[this] val speed = 200
        }
    }

package launch {
    import navigation._
    object Vehicle {
        private[launch] val guide = new Navigator
    }
}
