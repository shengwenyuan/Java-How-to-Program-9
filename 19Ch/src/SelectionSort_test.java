public class SelectionSort_test
{
    public static void main(String[] args) {
        SelectionSort sortArray = new SelectionSort(10);

        System.out.println("Unsorted array: ");
        System.out.println(sortArray + "\n");

        sortArray.sort();

        System.out.println("Sorted Array: ");
        System.out.println(sortArray);
    }
}
