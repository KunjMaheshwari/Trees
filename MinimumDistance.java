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
    public static Node lcaCal(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLcaCal = lcaCal(root.left, n1, n2);
        Node rightLcaCal = lcaCal(root.right, n1, n2);

        if(leftLcaCal == null){
            return rightLcaCal;
        }

        if(rightLcaCal == null){
            return leftLcaCal;
        }
        return root;
    }

    public static int lcaDis(Node lca, int n){
        if(lca == null){
            return -1;
        }

        if(lca.data == n){
            return 0;
        }

        int leftlcadis = lcaDis(lca.left, n);
        int rightlcadis = lcaDis(lca.right, n);

        if(leftlcadis == -1 && rightlcadis == -1){
            return -1;
        }

        else if (leftlcadis == -1){
            return rightlcadis+1;
        }else {
            return leftlcadis+1;
        }
    }
    public static int minDis(Node root, int n1, int n2){
        Node lca = lcaCal(root, n1, n2);
        int dist1 = lcaDis(lca, n1);
        int dist2 = lcaDis(lca, n2);

        return dist1+dist2;
    }
}