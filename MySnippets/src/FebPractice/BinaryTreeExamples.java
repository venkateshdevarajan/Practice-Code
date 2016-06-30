package FebPractice;
import java.util.*;

/**
 * Created by venkatesh.d on 02/03/16.
 */
public class BinaryTreeExamples {
    public static void main(String[] args){
        createBasicBinaryTree();
    }

    static void createBasicBinaryTree(){
        /**
         *                 1
         *         2                3
         *     4       5         6     7
         */

        node root;

        root=new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        printInOrderRecursive(root);
        System.out.println();
        //mirrorImage(root);
        //printInOrderRecursive(root);
        printInOrder(root);
        printPreOrderRecursive(root);
        System.out.println();
        printPreOrder(root);
        printPostOrderRecursive(root);
        System.out.println();
        printPostOrder(root);
    }

    static void printInOrderRecursive(node root){
        if(root == null){
            return;
        }

        printInOrderRecursive(root.left);
        System.out.print(root.key);
        printInOrderRecursive(root.right);
    }

    static void printInOrder(node root){
        if(root == null) return;
        node temp = root;
        Stack<node> stack = new Stack<node>();

        while(temp!=null){
            stack.push(temp);
            temp = temp.left;
        }

        while(stack.size() > 0){
            temp = stack.pop();
            System.out.println(temp.key);

            if(temp.right != null){
                temp = temp.right;

                while(temp!=null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    static void printPreOrderRecursive(node root){
        if(root ==null) return;

        System.out.print(root.key);
        printPreOrderRecursive(root.left);
        printPreOrderRecursive(root.right);
    }

    static void printPreOrder(node root){
        if(root == null) return;

        Stack<node> stack = new Stack<node>();
        node temp = root;

        stack.push(temp);

        while(stack.size()>0){
            temp = stack.pop();
            System.out.println(temp.key);

            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    static void printPostOrderRecursive(node root){
        if(root == null) return;
        printPostOrderRecursive(root.left);
        printPostOrderRecursive(root.right);
        System.out.print(root.key);

    }

    static void printPostOrder(node root){
        if(root == null) return;

        Stack<node> stack = new Stack<node>();
        Stack<node> stack1 = new Stack<node>();

        node temp = root;
        stack.push(temp);
        while(stack.size() > 0){
            temp = stack.pop();
            stack1.push(temp);
            if(temp.left!=null)
                stack.push(temp.left);
            if(temp.right!=null)
                stack.push(temp.right);
        }

        while(stack1.size() > 0 ){
            System.out.println(stack1.pop().key);
        }
    }

    static void mirrorImage(node root){
        if(root==null) return;
        node temp = root;
        node temp1 = null;

        Stack<node> stack = new Stack<node>();
        stack.push(temp);

        while(stack.size() > 0){
            temp = stack.pop();
            temp1 = temp.left;
            temp.left = temp.right;
            temp.right = temp1;

            if(temp.left!=null)
                stack.push(temp.left);
            if(temp.right!=null)
                stack.push(temp.right);
        }
    }

}

class node{
    int key;
    node left,right;

    node(int num){
        key = num;
        left=right=null;
    }
}
