object RationalNum{
    class Rational(val n:Int , val d:Int){
        val numer = n
        val denom = d

        def neg(): Unit ={
            if((n/d)>0){
                println(s"-$numer/$denom")
            }
        }
    }
    def main(args: Array[String]): Unit = {
        val num1 = Rational(23 , 2)
        num1.neg()
    }
}