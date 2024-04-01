package com.my016.lab2.object;

public class Student implements Comparable<Student>{
    private String name;    //学生姓名
    private float  score;   //分数

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Float.compare(this.score, o.getScore());
    }
}
