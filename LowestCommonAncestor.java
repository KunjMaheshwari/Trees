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
    public Node lcs(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLcs = lcs(root.left, n1, n2);
        Node rightLcs = lcs(root.right, n2, n2);

        if(leftLcs == null){
            return rightLcs;
        }

        if(rightLcs == null){
            return leftLcs;
        }

        return root; // if n1 is present in left lcs and n2 is present in the right lcs.
    }
}

// TC - O(N)
// SC - O(N)