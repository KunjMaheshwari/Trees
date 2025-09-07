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
    public static Node conversionUtils(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        Node root = new Node(preorder[preStart]);

        int inIndex = map.get(root.data);
        int leftPart = inIndex - inStart;

        root.left = conversionUtils(preorder, preStart+1, preStart+leftPart, inorder, inStart, inIndex-1, map);
        root.right = conversionUtils(preorder, preStart+leftPart+1, preEnd, inorder, inIndex+1, inEnd, map);

        return root;

    }
    public static Node conversion(Node root, int inorder[], int preorder[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return conversionUtils(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
}