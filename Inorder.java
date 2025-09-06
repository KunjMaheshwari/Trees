import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution{
    public static void helper(Node root, ArrayList<Integer> result){
        if(root == null){
            return;
        }

        helper(root.left, result);
        result.add(root.data);
        helper(root.right, result);
    }
    public static ArrayList<Integer> inOrderTraversal(Node root){
        ArrayList<Integer> result = new ArrayList<>();

        helper(root, result);

        return result;
    }
}