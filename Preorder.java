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
    public void helper(ArrayList<Integer> result, Node root){
        if(root == null){
            return;
        }

        result.add(root.data); // O(1)
        helper(result, root.left); // recrusive traveral
        helper(result, root.right); 
    }
    public ArrayList<Integer> preOrderTraveral(Node root){
        ArrayList<Integer> result = new ArrayList<>();

        helper(result, root);

        return result;
    }
}

// Time complexity of this code is - O(N)
// Space complexity of this code is - O(N)