import java.util.*;

public class AlgorithmsDataStructures2 {

    public static int[] GenerateBBSTArray(int[] a) {
        if (a == null || a.length == 0) {
            return null; // Handle empty or null input
        }

        Arrays.sort(a); // Sort the input array

        int[] bstArray = new int[a.length];
        buildBST(a, bstArray, 0, a.length - 1, 0); // Recursively build the BST

        return bstArray;
    }

    private static void buildBST(int[] sortedArray, int[] bstArray, int start, int end, int index) {
        if (start > end) {
            return; // Base case: no elements in this subtree
        }

        int mid = (start + end) / 2;
        bstArray[index] = sortedArray[mid]; // Set the root node

        buildBST(sortedArray, bstArray, start, mid - 1, 2 * index + 1); // Left subtree
        buildBST(sortedArray, bstArray, mid + 1, end, 2 * index + 2); // Right subtree
    }
}