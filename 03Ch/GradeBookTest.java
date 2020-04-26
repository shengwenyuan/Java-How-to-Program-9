import java.util.Scanner;

public class GradeBookTest
{
    public static void main( String[] args )
    {
        Scanner write = new Scanner(System.in);
        // String name = write.nextLine();
        GradeBook gagaBook1 = new GradeBook( write.nextLine() );
        GradeBook gagaBook2 = new GradeBook( "AAZkfff" );

        System.out.printf( "course1# : %s\n", gagaBook1.getCourseName() );
        System.out.printf( "course2# : %s\n", gagaBook2.getCourseName() );
        gagaBook2.displayMessage();
    }
}