import java.util.Scanner;

public class GradeBook
{
    private String courseName;

    private int total;
    private int gradeCounter;
    private int aCount, bCount, cCount, dCount, eCount;

    public GradeBook( String name)
    {
        courseName = name;
    }

    public void setCourseName(String name)
    {
        courseName = name;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void displayMessage()
    {
        System.out.printf("Welcome to the grade book for\n%s!\n\n", getCourseName());
    }

    public void inputGrades()
    {
        Scanner input = new Scanner(System.in);
        int grade;

        System.out.printf("  Enter the integer grades in the rang 0-100.\n  Type the end-of-file indicator to terminate input: <Ctrl> + d\n");

        while(input.hasNext())
        {
            grade = input.nextInt();
            total += grade;
            ++gradeCounter;

            incrementLetterGradeCounter(grade);
        }
    }

    private void incrementLetterGradeCounter(int grade) 
    {
        switch(grade / 10)
        {
            case 10:
            case 9:
                ++aCount;
                break;
            
            case 8:
                ++bCount;
                break;

            case 7:
                ++cCount;
                break;

            case 6:
                ++dCount;
                break;

            default:
                ++eCount;
                break;
        }//end switch
    }

    public void displayGradeReport()
    {
        System.out.println("\nGrade Report:");

        if(gradeCounter != 0)
        {
            double average = (double)total / gradeCounter;

            System.out.printf("Total of the %d grades entered is %d\n", gradeCounter, total);
            System.out.printf("Class average is %.2f\n", average);
            System.out.printf("%s%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n",
                "Number of students who received each grade:\n",
                "A: ", aCount,
                "B: ", bCount,
                "C: ", cCount,
                "D: ", dCount,
                "E: ", eCount);
        }
        else
            System.out.println("No grades were entered");
    }

}