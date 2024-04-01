package com.my016.arithmetic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class 歌手大赛 {
    private static final java.util.Scanner SC = new java.util.Scanner(System.in);

    private static final int 评委人数 = 10;

    private static final List<歌手> 比赛成员 = new LinkedList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            比赛成员.add(new 歌手());
        }

        for (歌手 歌手 : 比赛成员) {
            歌手.开始评分();
        }

        for (歌手 歌手 : 比赛成员) {
            歌手.获取分数();
        }
    }

    private static class 歌手{
        private double sub_score ; // 歌手分数
        private final double[] detail_score; // 各个评委的打分
        private final String name;

        public 歌手(){
            detail_score  = new double[评委人数];
            sub_score = 0;
            System.out.print("请输入选手姓名：");
            name = SC.next();
            System.out.println("选手{" + name + "}创建成功！");
        }

        public void 开始评分(){
            double sub = 0;
            for (int i = 0; i < detail_score.length; i++) {
                System.out.print("评委"+(i+1)+ "给"+name+ "打分：");
                detail_score[i] = SC.nextDouble();
                sub += detail_score[i];
            }
            sub_score = sub/(评委人数*1.0);
            System.out.println("各评委的评分为："+ Arrays.toString(detail_score));
        }

        public void 获取分数(){
            if (sub_score == 0){
                System.out.println( name + "还未评分");
                return;
            }
            System.out.println(name +"得分："+sub_score);
        }
    }
}
