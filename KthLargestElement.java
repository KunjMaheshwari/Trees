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
    int count = 0;
    int result = 0;

    public int kthLargest(Node root, int K){
        reverseInorder(root, K);
        return result;
    }

    public void reverseInorder(Node root, int K){
        if(root == null || count >= K){
            return;
        }

        reverseInorder(root.right, K);

        count++;
        if(count == K){
            result = root.data;
            return;
        }

        reverseInorder(root.left, K);
    }
}