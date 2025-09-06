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
    public ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 0;

        while(!q.isEmpty()){
            result.add(new ArrayList<>());

            Node curr = q.remove();

            result.get(i).add(curr.data);

            if(root.left != null){
                q.add(curr.left);
            }

            if(root.right != null){
                q.add(curr.right);
            }
            i++;
        }
        return result;
    }
}