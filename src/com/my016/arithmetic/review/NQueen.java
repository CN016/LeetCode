package com.my016.arithmetic.review;

import com.my016.arithmetic.Scanner;

import java.util.Arrays;

public class NQueen {
    private static  int N;

    private static  int[][] board ;

    private static void init(){
        board = new int[N][N];
    }

    public static void main(String[] args) {
        N = Scanner.nextInt();
        init();
        int solutions = solveNQueens(0);
        System.out.printf("总共有 %d 个解决方案。\n", solutions);
    }

    private static boolean isSafe(int row,int col){
        int i, j;

        // 检查当前列上方的所有行
        for (i = 0; i < row; i++)
        {
            if (board[i][col] >0)
                return false;
        }

        // 检查左上对角线
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] >0)
                return false;
        }

        // 检查右上对角线
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
        {
            if (board[i][j] >0)
                return false;
        }

        return true;
    }

    private static int solveNQueens(int row){

        //所有行都已经放置好皇后
        if (row == N){
            for (int[] ints : board) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.print("\n");
            return 1;
        }

        int count = 0;

        // 尝试在当前行的每个位置放置皇后
        for (int col = 0; col < N; col++)
        {
            if (isSafe(row, col))
            {
                // 放置皇后
                board[row][col] = 1;

                // 递归地尝试放置下一行的皇后
                count += solveNQueens(row + 1);

                // 回溯并移除当前位置的皇后
                board[row][col] = 0;
            }
        }

        return count;
    }
}
