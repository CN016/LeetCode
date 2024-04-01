package com.my016.arithmetic.review;

public class Dijkstra {

    public static void main(String[] args) {

    }

    /**
     * Dijkstra最短路径。
     * 即，统计图(G)中"顶点vs"到其它各个顶点的最短路径。
     * @param G 图
     * @param vs 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径.
     * @param prev 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     * @param dist 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    private static void dijkstra(Graph G, int vs, int[] prev, int[] dist){
        int i,j,k;
        int min;
        int tmp;
        
    }
}
class Graph{
    private char[] vexs; //顶点集合
    private int    vexNum; //顶点数
    private int    edgeNum; //边数
    private int[][] matrix; //邻接矩阵

    public char[] getVexs() {
        return vexs;
    }

    public void setVexs(char[] vexs) {
        this.vexs = vexs;
    }

    public int getVexNum() {
        return vexNum;
    }

    public void setVexNum(int vexNum) {
        this.vexNum = vexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
class Edge{
    private char start; //边的起点
    private char end  ; //边的终点
    private int  weight;//边的权重

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
