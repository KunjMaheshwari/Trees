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
    //Seriaization 
    public static void serializeUtils(Node root, ArrayList<Integer> result){
        if(root == null){
            result.add(-1);
            return;
        }

        result.add(root.data);

        serializeUtils(root.left, result);
        serializeUtils(root.right, result);
    }
    public ArrayList<Integer> serialize(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        serializeUtils(root, result);
        return result;
    }

    //DeSerialization

    public static Node deSerializeUtils(ArrayList<Integer> arr, int i[]){
        if(arr.get(i[0]) == -1){
            i[0]++;
            return null;
        }

        Node root = new Node(arr.get(i[0]));
        i[0]++;

        root.left = deSerializeUtils(arr, i);
        root.right = deSerializeUtils(arr, i);

        return root;
    }

    public Node deSerialize(ArrayList<Integer> arr){
        int i[] = {0};
        return deSerializeUtils(arr, i);
    }
}