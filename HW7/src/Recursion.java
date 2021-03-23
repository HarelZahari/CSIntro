/*
 
 Assignment number     :    7.1, 7.2, 7.3, 7.4, 7.5
 
 File Name             :    Recursion.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class Recursion {

    public static void main(String[] args) {
        // hailstone function tests until N
        int N = 16;
        hailstoneTests(N);
        System.out.println("================================================================================");

        // integerToBinary function tests N times
        integerToBinaryTests(N);
        System.out.println("================================================================================");

        // parity function sanity tests
        if (parity("1") == 1 && parity("11") == 0 && parity("") == 0 && parity("1101") == 1 && parity("11011") == 0
                && parity("11011101010111") == 0 && parity("1101110101011") == 1) {
            System.out.println("===============parity function: Sanity tests - Passed===============");
        } else {
            System.out.println("===============parity function: Sanity tests - Failed===============");
        }
        System.out.println("================================================================================");
        // parity function random tests N times
        System.out.println("************Starting parity function random tests:************");
        parityTests(N);
        System.out.println();

        // banachCurve function test
        banachCurve(6);
        // increasing function sanity tests
        int[] arr0 = { 10, 8, 7, 6 };
        int[] arr1 = { 6, 7, 8, 9 };
        int[] arr2 = { 10, 7, 8, 9 };
        int[] arr3 = { 11, 10, 8, 9 };
        int[] arr4 = {};
        if (increasing(arr0, 0) == true && increasing(arr0, 1) == true && increasing(arr0, 2) == false
                && increasing(arr1, 3) == true && increasing(arr1, 5) == false && increasing(arr2, 3) == true
                && increasing(arr2, 4) == false && increasing(arr3, 3) == false && increasing(arr3, 2) == true
                && increasing(arr4, 0) == true && increasing(arr4, 1) == false) {
            System.out.println("===============increasing function: Sanity tests - Passed===============");
        } else {
            System.out.println("===============increasing function: Sanity tests - Failed===============");
        }
        System.out.println("================================================================================");
        // increasing function random tests
        System.out.println("************Starting increasing function random tests:************");
        System.out.println();
        increasingTests(10);
        System.out.println("================================================================================");
    }
    
    /**
     * The function get a seed and create the hailstone sequence for seed.
     * 
     * @param seed - int that the hailstone sequence start from.
     */
    public static void hailstone(int seed) {
        if (seed == 1) {
            System.out.print(seed);
            return;
        }
        System.out.print(seed + ", ");
        if (seed % 2 == 0) {
            hailstone(seed / 2);
        } else {
            hailstone((seed * 3) + 1);
        }
    }
    
    /**
     * The function returns the binary representation of a given non-negative integer.
     * 
     * @param x - integer number for binary representation.
     * @return - string binary representation of x.
     */
    public static String integerToBinary(int x) {
        if (x == 1) {
            return "1";
        }
        if (x == 0) {
            return "0";
        } else {
            if (x % 2 == 0) {
                return integerToBinary(x / 2) + "0";
            } else
                return integerToBinary(x / 2) + "1";
        }
    }
    
    /**
     * The function check if the number of times that the character '1' appears in
     * this string is even, the parity it 0; if it’s odd, the parity is 1.
     * 
     * @param binaryStr
     *            - the string for parity test
     * @return - int 0 or 1, if '1' appears in binaryStr is even return - 0. if '1'
     *         appears in binaryStr is odd return - 1
     */
    public static int parity(String binaryStr) {
        if (binaryStr.length() == 0) {
            return 0;
        }
        String subStr = binaryStr.substring(1);
        if (binaryStr.charAt(0) == '1') {

            if (1 + parity(subStr) == 2) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return parity(subStr);
        }
    }
    
    /**
     * The function return true if the given array contains an increasing
     * subsequence of the given length, and false otherwise.
     * 
     * @param arr
     *            - array that contains the integer sequence.
     * @param length
     *            - the increasing subsequence length we looking for.
     * @return boolean - return true if the given array contains an increasing
     *         subsequence of the given length, and false otherwise.
     */
    public static boolean increasing(int[] arr, int length) {
        if (increasing(arr, 0, Integer.MIN_VALUE) >= length) {
            return true;
        } else {
            return false;
        }
    }
    
    // The function return the length of the maximal increasing subsequence.
    private static int increasing(int[] arr, int indexOfStart, int prevElement) {
        int inSubsequenceCounter = 0;
        int notInSubsequenceCounter = 0;
        if (indexOfStart == arr.length) {
            return 0;
        }
        notInSubsequenceCounter = increasing(arr, indexOfStart + 1, prevElement);
        if (arr[indexOfStart] >= prevElement) {
            inSubsequenceCounter = 1 + increasing(arr, indexOfStart + 1, arr[indexOfStart]);
        }
        return Math.max(inSubsequenceCounter, notInSubsequenceCounter);
    }
    
    /**
     * The function create Banach Curve fractal on size n.
     * @param n - The size of Banach Curve fractal.
     */
    public static void banachCurve(int n) {
        StdDraw.setCanvasSize(700, 700);
        StdDraw.setXscale();
        StdDraw.setYscale();
        StdDraw.setPenColor(StdDraw.BLUE);
        banachCurve(0.5, 0.5, 1.0 / 3.0, n - 1);
    }
    
    // Create the banachCurve fractal size n
    private static void banachCurve(double x, double y, double r, int n) {
        double pi = Math.PI;
        double towPi = pi * 2;
        // Create colorful circles, randomize the pen color.
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        StdDraw.setPenColor(red, green, blue);

        if (n == 0)
            return;
        else {
            StdDraw.circle(x, y, r);
            banachCurve(x, y, r / 3, n - 1);
            banachCurve(x + r * Math.cos(0), y + r * Math.sin(0), r / 3, n - 1);
            banachCurve(x + r * Math.cos(1. / 8. * towPi), y + r * Math.sin(1. / 8. * towPi), r / 3, n - 1);
            banachCurve(x + r * Math.cos(2. / 8. * towPi), y + r * Math.sin(2. / 8. * towPi), r / 3, n - 1);
            banachCurve(x + r * Math.cos(3. / 8. * towPi), y + r * Math.sin(3. / 8. * towPi), r / 3, n - 1);
            banachCurve(x + r * Math.cos(4. / 8. * towPi), y + r * Math.sin(4. / 8. * towPi), r / 3, n - 1);
            banachCurve(x + r * Math.cos(5. / 8. * towPi), y + r * Math.sin(5. / 8. * towPi), r / 3, n - 1);
            banachCurve(x + r * Math.cos(6. / 8. * towPi), y + r * Math.sin(6. / 8. * towPi), r / 3, n - 1);
            banachCurve(x + r * Math.cos(7. / 8. * towPi), y + r * Math.sin(7. / 8. * towPi), r / 3, n - 1);
        }
    }
    
    // Print hailstone results until seed
    private static void hailstoneTests(int seed) {
        for (int i = 1; i <= seed; i++) {
            hailstone(i);
            System.out.println();
        }
    }

    // Print the integerToBinary results for integers until x.
    private static void integerToBinaryTests(int x) {
        for (int i = 0; i <= x; i++) {
            System.out.println("Decimal: " + i + " ,Binary: " + integerToBinary(i));
        }
    }
    
    // Create random strin and print parity function results on random string numberOfTest times, and the expected results.
    private static void parityTests(int numberOfTest) {
        for (int j = 0; j < numberOfTest; j++) {
            int stringSize = 8;
            int oneCounter = 0;
            String str = "";
            for (int i = 0; i < stringSize; i++) {
                String whatToConcat = "0";
                if (Math.random() > 0.5) {
                    whatToConcat = "1";
                    oneCounter++;
                }
                str += whatToConcat;
            }
            System.out.println();
            System.out.println("Random string is: " + str + " Number of one's is: " + oneCounter
                    + " - partiy function return: " + parity(str));
        }
    }
    
    // Create random arrays, on random size, and print arrays and increasing function results, numberOfSequence times.
    private static void increasingTests(int numberOfSequence) {
        int subsequenceSize = 5;
        for (int i = 0; i < numberOfSequence; i++) {
            int arrLength = 2 + ((int) (Math.random() * 10));
            int[] arr = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                int posOrNag = 1;
                if (Math.random() > 0.5) {
                    posOrNag = -1;
                }
                arr[j] = posOrNag * ((int) (Math.random() * 1000));
            }
            System.out.println(
                    "Looking for subsequence size:" + subsequenceSize + " the arr random size is: " + arr.length);
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + ", ");
            }
            System.out.println();
            System.out.println("Looking for increase subsequence bigger than " + subsequenceSize
                    + ". \nThe biggest increase subsequence found in size " + increasing(arr, 0, Integer.MIN_VALUE));
            System.out.println(increasing(arr, 5));
            System.out.println();
        }
    }
}
