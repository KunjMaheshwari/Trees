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

    public static void dfs(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }else {
            dfs(root.left, path, result);
            dfs(root.right, path, result);
        }

        path.remove(path.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> main(Node root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> path = new ArrayList<>();

        dfs(root, path, result);

        return result;
    }
}