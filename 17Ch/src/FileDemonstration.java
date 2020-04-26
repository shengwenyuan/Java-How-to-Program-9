import java.util.Scanner;
import java.io.File;

public class FileDemonstration
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter: ");
        analyzePath(input.nextLine());
    }

    public static void analyzePath(String path)
    {
        File name = new File(path);
        if (name.exists()) {
            System.out.printf("%s%s\n%s%s\n%s%s\n%s%s\n\n%s%s\n%s%s\n\n%s%s\n%s%s\n%s%s\n",
                    name.getName(), "exists",
                    (name.isFile() ? "is a file" : "is not a file"),
                    (name.isDirectory() ? "is a directory" : "is not a directory"),
                    (name.isAbsolute() ? "is absolute path" : "is not absolute path"),
                    "Last modified: ", name.lastModified(),
                    "Length: ", name.length(),
                    "Path: ", name.getPath(),
                    "Absolute path: ", name.getAbsolutePath(),
                    "Parent: ", name.getParent());

            if(name.isDirectory())
            {
                String[] directory = name.list();
                System.out.println("\nDirectory contents: ");

                for(String content : directory)
                    System.out.println(content);
            }
        } else {System.out.println("Does not exist");
        }
    }
}
