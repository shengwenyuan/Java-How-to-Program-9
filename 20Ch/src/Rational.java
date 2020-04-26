import java.util.Scanner;
public class Rational {
    private long num=0;//分子
    private long den=1;  //分母

    public Rational(){
        this(0,1); //调用该类自身的构造方法
    }
    public Rational(long num, long den) {
        //TO DO YOUR CODE HERE
        this.num = num;
        this.den = den;
    }

    /************Begin*****************/
    public Rational add(Rational rtinl)
    {
        Rational temp = new Rational((this.num * rtinl.den + this.den * rtinl.num),
                (this.den * rtinl.den));
        return temp.standard();
    }

    public Rational subtract(Rational rtinl)
    {
        Rational temp = new Rational((this.num * rtinl.den - this.den * rtinl.num),
                (this.den * rtinl.den));
        return temp.standard();
    }

    public Rational multiply(Rational rtinl)
    {
        Rational temp = new Rational(this.num * rtinl.num,
                this.den * rtinl.den);
        return temp.standard();
    }

    public Rational divide(Rational rtinl)
    {
        Rational temp = new Rational(this.num * rtinl.den,
                this.den * rtinl.num);
        return temp.standard();
    }

    public Rational standard()
    {
        Rational result = this.reductionFraction();
        if (result.getNum() * result.getDen() < 0) {
            result.setNum(Math.abs(result.getNum())*(-1));
            result.setDen(Math.abs(result.getDen()));
        }
        return result;

    }

    private Rational reductionFraction()
    {
        Rational result = new Rational(num, den);

        if( absCompare(num, den) && (den % num == 0) ) {
            result.setNum(1);
            result.setDen(den / num);
            return result;
        }

        else if( !absCompare(num, den) && (num % den == 0) ) {
            result.setNum(num / den);
            result.setDen(1);
            return result;
        }

        for(int count = 2; count <= ( absCompare(num, den) ? (Math.abs(num)/2) :
                (Math.abs(den)/2) ); count++)
        {
            if( (num % count == 0) && (den % count == 0) ) {
                result.setNum(num / count);
                result.setDen(den / count);
                result.reductionFraction();
            }
        }

        return result;
    }

    private boolean absCompare(long num, long den)
    {
        if(Math.abs(den) >= Math.abs(num))
            return true;
        else
            return false;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public long getDen() {
        return den;
    }

    public void setDen(long den) {
        this.den = den;
    }

    @Override
    public String toString() {
        return  num +
                "/" + den;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rational r1 = new Rational(scanner.nextLong(), scanner.nextLong());
        Rational r2 = new Rational(scanner.nextLong(), scanner.nextLong());

        System.out.println(r1.add(r2));
        System.out.println(r1.subtract(r2));
        System.out.println(r1.multiply(r2));
        System.out.println(r1.divide(r2));
    }
    /**************End*****************/
}