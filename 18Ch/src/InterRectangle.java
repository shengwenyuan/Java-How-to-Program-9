
import java.util.Scanner;

public class InterRectangle {
    private double width;
    private double length;
    /*********请在此编写构造函数及求周长和面积的方法*********/

    public InterRectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    public double peri()
    {
        return (length + width) * 2;
    }

    public double area()
    {
        return length * width;
    }
    /*********end**********/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total=scanner.nextDouble();//获取土地数目
        /*********begin*********/
        //请获取到每块土地的长和宽，并输出土地块数，总面积和总周长


        double sumP = 0;
        double sumA = 0;
        for (int count = 0; count < total; count++)
        {
            InterRectangle land = new InterRectangle(scanner.nextDouble(), scanner.nextDouble());
            sumP += land.peri();
            sumA += land.area();
        }

        System.out.printf("总共有%.1f块土地\n", total);
        System.out.printf("土地总面积为：%.1f平米\n", sumA);
        System.out.printf("土地总周长为：%.1f平米\n", sumP);
        /*********end*********/
    }

}
