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
    public int helper(int diam[], Node root){
        if(root == null){
            return 0;
        }

        int leftSubtreeHeight = helper(diam, root.left);
        int rightSubtreeHeight = helper(diam, root.right);

        diam[0] = Math.max(diam[0], leftSubtreeHeight + rightSubtreeHeight);

        return Math.max(leftSubtreeHeight, rightSubtreeHeight)+1;

    }
    public int diamater(Node root){
        int diam[] = new int[1]; // store the current diameter of the tree.

        helper(diam, root);

        return diam[0];
    }
}

// TC - O(N);
// SC - O(h); // where h is the height of the tree.