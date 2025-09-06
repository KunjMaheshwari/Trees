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
    public ArrayList<Integer> reversal(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();

        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.remove();

            s.push(curr);

            if(curr.right != null){
                q.add(curr.right);
            }

            if(curr.left != null){
                q.add(curr.left);
            }
        }

        while(!s.isEmpty()){
            Node curr = s.pop();
            result.add(curr.data);
        }

        return result;

    }
}