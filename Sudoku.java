import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sudoku {
 static void sudoku_solve(int[][] grid) {
  if (solve(grid)) {
   for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid.length; j++) {
     System.out.print(grid[i][j]+" ");
    }
    System.out.println();
   }
  }
 }
 static boolean solve(int[][] grid) {
  Integer x = -1, y = -1;
  Map<String,Integer> map= new HashMap<>();
  //check for completion
  if (isFull(grid,map)){
   return true;
 }
  else{
    x=map.get("x");
    y=map.get("y");
   for (int i = 1; i <= grid.length; i++) {
     //check is safe to place a digit in a place
        if(isSafe(grid,x,y,i)){
        grid[x][y] = i;
        if (solve(grid))
         return true;
         //Reset values for backtracking
        grid[x][y] = 0;
      }
   }
 }
  return false;
 }
 //used to check its done if not return values
 static boolean isFull(int[][] grid,Map<String,Integer> map) {
  for (int i = 0; i < grid.length; i++) {
   for (int j = 0; j < grid.length; j++) {
    if (grid[i][j] == 0) {
    map.put("x",i);
    map.put("y",j);
     return false;
    }
   }
  }
  return true;
 }
 static boolean isSafe(int[][] grid,int x,int y,int j)
 {
   for(int i=0;i<grid.length;i++)
   {
     //check horizontal
     if(grid[x][i]==j)
     return false;
     //vertical
     if(grid[i][y]==j)
     return false;
   }
   //Find square Block
   int xq=x/3*3;
   int yq=y/3*3;
   for(int a=xq;a<xq+3;a++)
   {
     for(int b=yq;b<yq+3;b++)
     {
       if(grid[a][b]==j)
       return false;
     }
   }
   return true;
 }
 public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  int n;
  int board[][] = new int[9][9];

  n = in .nextInt();

  for (int i = 0; i < n; i++) {
   for (int j = 0; j < 9; j++) {
    for (int k = 0; k < 9; k++) {
     board[j][k] = in .nextInt();
    }
   }
   sudoku_solve(board);
  }
 }
}
