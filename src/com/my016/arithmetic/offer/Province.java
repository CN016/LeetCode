package com.my016.arithmetic.offer;

import java.util.Arrays;

public class Province {

    public static void main(String[] args) {
//        new Solution().findCircleNum(new int[20][]);
        int[][] citys = { {1,1,0,0,0,0},{1,1,0,0,0,0},{0,0,1,1,0,0},{0,0,1,1,0,0},{0,0,0,0,1,1},{0,0,0,0,1,1} };
//        int[][] citys = { {1,1,0,0,0,0},{1,1,0,0,0,0},{1,1,0,0,0,0},{1,1,0,0,0,0},{1,1,0,0,0,0},{1,1,0,0,0,0} };
        System.out.println(new Solution().findCircleNum(citys));
    }
    //有 n 个城市，其中一些彼此相连，另一些没有相连。
    //如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
    //
    //省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
    //
    //给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
    //而 isConnected[i][j] = 0 表示二者不直接相连。
    //
    //返回矩阵中 省份 的数量。
    private static class Solution {
        public int findCircleNum(int[][] isConnected) {
            boolean[] cityRecode = new boolean[isConnected.length];
//            System.out.println(Arrays.toString(cityRecode));
            int count = 0;
            for (int i = 0; i < cityRecode.length; i++) {
                if (cityRecode[i]){
                    continue;
                }
                dfs(cityRecode,isConnected,i);
                count++;
            }
            return count;
        }
        private void dfs(boolean[] citys, int[][] isConnected, int start){
            for (int j = 0 ; j < isConnected.length ; j++ ){
                if (citys[j]){
                    continue;
                }
                if (isConnected[start][j] == 1){
                    citys[j] = true;
                    dfs(citys, isConnected, j);
                }
            }

        }
    }

}
