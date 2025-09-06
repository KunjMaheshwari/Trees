class Solution{
    public int helper(Node root){
        if(root == null){
            return 0;
        }

        int currentSum = root.data;

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        root.data = leftSum+ rightSum;

        return root.data + currentSum;
    }
    public void transformTree(Node root){
        helper(root);
    }
}