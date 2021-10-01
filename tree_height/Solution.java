import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    
	public static int height(Node node) {
      	// depth first search, keeping track of height.
        // return the one that's longest
        int leftHeight = 0;
        int rightHeight = 0;
    
        if (node.left == null && node.right == null)
            return 0;
        
        if (node.left != null)
            leftHeight = height(node.left);
        
        if (node.right != null)
            rightHeight = height(node.right);
        
        if (leftHeight > rightHeight) {
            return 1 + leftHeight;
        }
        else {
            return 1 + rightHeight;
        }
        
    }
    
    

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    // example input:
    // 7
    // 3 5 2 1 4 6 7
    
    // result:
    // 3
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}