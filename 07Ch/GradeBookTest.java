public class GradeBookTest
{
    public static void main(String[] args)
    {
        int[] gradesArray = { 32, 88, 100, 77, 94, 72, 58, 84, 76, 62 };

        GradeBook myGradeBook = new GradeBook("Still the Java class lasting six chapters", gradesArray);
        myGradeBook.displayMessage();
        myGradeBook.processGrades();
    }
}