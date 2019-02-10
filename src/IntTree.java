/**
 * IntTree readTree and writeTree Exercise.
 */
import java.util.Scanner;

public class IntTree {
    private IntTreeNode overallRoot;

    // post: constructs an empty tree
    public IntTree() {
        overallRoot = null;
    }

    // ************ Exercise Part 1 IMPLEMENT THIS METHOD ************* //
    // post: prints a tree in pre-order with "code data" format for each node
    //3 : has both child
    //2 : has right child only
    //1 : has left child only
    //0 : has no child
    public void writeTree(){
        //Write Your Code HERE
        //You need to hire a helper method that does the recursion
        //Think about the same 5 questions in the lecture 12 worksheet
        //Also use below printInfo method to print each node in the helper method
    }

    //In addition ** MUST ** use this method for solving Part 1
    private void printInfo(int code, int data){
        System.out.println(code + " " + data);
    }

    // ************ Exercise Part 2 IMPLEMENT THIS METHOD ************* //
    // post: builds a tree given list of "code data" in pre-order traversal form
    public void readTree(Scanner input) {
        //Write Your Code HERE
        //You need to hire a helper method that does the recursion
        //Think about the same 5 questions in the lecture 12 worksheet
    }

    //----------- Feel free to use printSideways method to debug ----------------//
    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            printData(root.data, level);
            printSideways(root.left, level + 1);
        }
    }

    //helper method for printSideways printing data with spaces given data and level
    private static void printData(int data, int level){
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(data);
    }

    //----- Below methods are implemented for testing purpose ----- //

    // Used only for JUnit Testing purpose
    public IntTree(IntTreeNode overallRoot) {
        this.overallRoot = overallRoot;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && getClass() == obj.getClass()) {
            IntTree other = (IntTree) obj;
            return equals(overallRoot, other.overallRoot);
        }
        else
            return false;
    }

    private static boolean equals(IntTreeNode root1, IntTreeNode root2) {
        if(root1 == root2) return true; //same reference or both null return true
        if(root1 == null || root2 == null || root1.data != root2.data)
            return false;
        if (!equals(root1.left, root2.left)) return false;
        return equals(root1.right, root2.right);
    }
}
