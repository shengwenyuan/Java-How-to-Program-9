public class List_test
{
    public static void main(String[] args) {
        List< Integer > list = new List< Integer >();

        list.insertAtFront(-1);
        list.print();
        list.insertAtFront(77);
        list.print();
        list.insertAtBack(46);
        list.print();
        list.insertAtBack(0);
        list.print();

        try {
            int removedItem = list.removeFromFront();
            System.out.printf("\n%d removed\n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("\n%d removed\n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("\n%d removed\n", removedItem);
            list.print();

            removedItem = list.removeFromFront();
            System.out.printf("\n%d removed\n", removedItem);
            list.print();
        }

        catch (EmptyListException empty)
        {
            empty.printStackTrace();
        }
    }
}
