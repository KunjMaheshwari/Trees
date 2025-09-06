import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    static class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Pair> q = new LinkedList<Pair>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();

            int hd = curr.hd;
            Node temp = curr.node;

            if (map.get(hd) == null) {
                map.put(hd, temp.data);
            }

            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}