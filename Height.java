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
    public int height(Node root){
        if(root == null){
            return 0; // return -1;
        }

        int leftSubTree = height(root.left);
        int rightSubTree = height(root.right);

        int maxHeight = Math.max(leftSubTree, rightSubTree)+1;

        return maxHeight;
    }
}