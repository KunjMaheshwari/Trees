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
    public static ArrayList<Integer> zigZagTraversal(Node root){
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node curr = s1.pop();
                result.add(curr.data);

                if(curr.left != null){
                    s2.push(curr.left);
                }
                if(curr.right != null){
                    s2.push(curr.right);
                }
            }

            while(!s2.isEmpty()){
                Node curr = s2.pop();
                result.add(curr.data);

                if(curr.right != null){
                    s1.push(curr.right);
                }
                if(curr.left != null){
                    s1.push(curr.right);
                }
            }
        }
        return result;
    }
}

// TC - O(N)
// SC - O(N)