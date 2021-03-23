/*
 
 Assignment number     :    3.2
 
 File Name             :    ArrayOps.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
// Performs various array operations
public class ArrayOps {

    public static void main(String[] args) {
        test_printArr();
        test_maxArr();
    }

    public static void test_printArr() {
        int[] a = { 2, 1, 9, 7, 0 };
        printArr(a);
    }

    public static void test_maxArr() {
        int[] a = { 2, 1, 9, 7, 0 };
        int[] b = { 3, 0, 8, 11, -1, 9, -2 };
        int[] maxArr = maxArr(a, b);
        System.out.print("a = ");
        printArr(a);
        System.out.print("b = ");
        printArr(b);
        System.out.print("max = ");
        printArr(maxArr);
    }

    /**
     * Returns an array whose elements are the maxima of the respective elements of
     * the two given arrays. The size of the returned array is the size of the
     * longer array. For example, if the two given arrays are [3,4,1] and
     * [2,6,8,5,1], returns [3,6,8,5,1].
     */
    public static int[] maxArr(int[] a, int[] b) {
        int lengthOfMaximalArray = Math.max(a.length, b.length);
        int[] maxArray = new int[lengthOfMaximalArray];         // Set the length of the new array as the maximum length, between a and b arrays
        for (int i = 0; i < lengthOfMaximalArray; i++) { // The loop check all the values of the a and b arrays and create the new maximal array, maxArray
            if (i < a.length && i < b.length) {
                if (a[i] >= b[i]) {
                    maxArray[i] = a[i];
                } else {
                    maxArray[i] = b[i];
                }
            }
            else {
                if(i>=a.length) {
                    maxArray[i]=b[i];
                }
                else {
                    maxArray[i]=a[i];
                }
            }
        }
        return maxArray;
    }

    /**
     * Prints the given array in one line, with space separators, and then skips to
     * the next line.
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
