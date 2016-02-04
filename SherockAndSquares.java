import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;
//Find Perfect square within a range
public class SherlockAndSquares {

    public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int arr[]= new int[n];
        for(int i =0;i<n;i++)
            {
            int s=scan.nextInt();
            int e=scan.nextInt();
            int a=(int)Math.ceil(Math.sqrt(s));
            int b=(int)Math.floor(Math.sqrt(e));
            arr[i]=b-a+1;
        }
        for(int ar:arr)
            {
            System.out.println(ar);
        }
    }
  }
