class TreeNode<T extends Comparable<T>>
{
    TreeNode<T> leftNode;
    T data;
    TreeNode<T> rightNode;

    public TreeNode(T nodeData){
        data = nodeData;
        leftNode = rightNode = null;
    }

    public void insert(T insertValue)
    {
        if(insertValue.compareTo(data) < 0)
        {
            if(leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else
                leftNode.insert(insertValue);
        }

        else if(insertValue.compareTo(data) > 0)
        {
            if(rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else
                rightNode.insert(insertValue);
        }
    }
}

public class Tree< T extends Comparable<T> >
{
    private TreeNode<T> root;

    public Tree()
    {
        root = null;
    }

    public void insertNode(T insertValue)
    {
        if(root == null)
            root = new TreeNode<T>(insertValue);
        else
            root.insert(insertValue);
    }

    public void preorderTraversal(){
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode<T> node)
    {
        if(node == null)
            return;

        System.out.printf("%s ", node.data);
        preorderHelper(node.leftNode);
        preorderHelper(node.rightNode);
    }

    public void inorderTraversal(){
        inorderHelper(root);
    }   //52 29 5 89 95 3 91 88 53 66 86

    private void inorderHelper(TreeNode<T> node)
    {
        if (node == null)
            return;

        inorderHelper(node.leftNode);
        System.out.printf("%s ", node.data);
        inorderHelper(node.rightNode);
    }

    public void postorderTraversal(){

    }

    private void postorderHelper(TreeNode<T> node)
    {
        if(node == null)
            return;

        postorderHelper(node.leftNode);
        postorderHelper(node.rightNode);
        System.out.printf("%s ", node.data);
    }
}
