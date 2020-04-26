import java.util.Random;

public class Tree_test
{
    public static void main(String[] args) {
        Tree< Integer > tree = new Tree<Integer>();
        int value;
        Random randomNumber = new Random();

        System.out.println("Inserting the following values: ");

        for(int i = 0; i <= 10; i++)
        {
            value = randomNumber.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.println("\n\nPreorder traversal");
        tree.preorderTraversal();
        System.out.println("\n\nInorder traversal");
        tree.inorderTraversal();
        System.out.println("\n\nPostorder traversal");
        tree.postorderTraversal();
    }
}
