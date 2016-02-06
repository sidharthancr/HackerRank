/**
 * Created by sidharthan on 6/2/16.
 */

import java.util.Scanner;

public class MaxSubArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] res1 = new int[n];
        int[] res2 = new int[n];
        for (int i = 0; i < n; i++) {
            subArray(res1, res2, i, scan);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res1[i] + " " + res2[i]);
        }
    }

    static void subArray(int[] res1, int[] res2, int i, Scanner scan) {
        int t = scan.nextInt();
        if(t==0)
        {
            return;
        }
        int max = 0, currMax = 0, currNCMax = 0, maxNC = 0;
        int vals = scan.nextInt();
        //Choose first number as max
        currMax = vals;
        currNCMax = vals;
        maxNC = vals;
        max = vals;
        for (int j = 1; j < t; j++) {
            vals = scan.nextInt();
            currMax = Math.max(currMax + vals, vals);
            max = Math.max(currMax, max);
            //If the negative number in array, check its greater or not.
            if (currNCMax + vals > vals) {
                currNCMax = Math.max(currNCMax + vals, currNCMax);
            } else {
                currNCMax = vals;
            }
            maxNC = Math.max(currNCMax, maxNC);
        }
        res1[i] = max;
        res2[i] = maxNC;
    }

}
