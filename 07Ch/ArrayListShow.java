import  java.util.ArrayList;

public class ArrayListShow
{
    public static void main(String[] args)
    {
        ArrayList< String > items = new ArrayList< String >();

        items.add("red");
        items.add(0, "yellow");
        display(items, "format:");

        items.add("green");
        display(items, "change1:");

        items.remove(1);
        display(items, "deleted:");

        boolean judge = items.contains("green");

        System.out.printf("Size: %s\n", items.size());
    }

    public static void display(ArrayList<String> items, String header)
    {
        System.out.print(header);

        for(String item : items)
            System.out.printf(" %s", item);

        System.out.println();
    }
}