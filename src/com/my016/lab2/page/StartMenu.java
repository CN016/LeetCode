package com.my016.lab2.page;

import com.my016.lab2.object.Student;
import com.my016.lab2.utils.ScannerUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StartMenu {
    private final List<Student> students;

    public StartMenu(List<Student> students){
        this.students = students;
    }

    public void hello() throws Exception{
        System.out.println("welcome to 016's student-score-system!");
        if (students.isEmpty()){
            System.out.println("now the students-list is empty , please add some student's info QAQ");
            while (true) {
                System.out.print("please enter yes or no:");
                String s = ScannerUtil.getLine();
                if ("yes".equalsIgnoreCase(s)){
                    inputInfo();
                    return;
                }else if ("no".equalsIgnoreCase(s)){
                    exit();
                }else {
                    System.out.println("unknown type:"+s);
                }
            }
        }else {
            System.out.println("please enter the user_code for next process:");
            System.out.println("1.add_students");
            System.out.println("2.count all students score");
            System.out.println("3.find student‘s score");
            System.out.println("4.exit");
            System.out.print("you choice:");
            String s = ScannerUtil.getLine();
            if ("1".equals(s)){
                inputInfo();
            }else if ("2".equals(s)){
                count();
            }else if ("3".equals(s)){
                findStudentByName();
            } else if ("4".equals(s)){
                exit();
            }else {
                System.out.println("unknown :"+s);
            }
        }
    }

    private void findStudentByName() {
        System.out.print("请输入学生姓名：");
        String name = ScannerUtil.getNext();
        for (Student student : students) {
            if (student.getName().equals(name)){
                System.out.println(student);
                return;
            }
        }
        System.out.println("没找到QAQ");
    }

    private void count() {
        int _60_70_ = 0;
        int _70_80_ = 0;
        int _80_90_ = 0;
        int _big_90 = 0;
        float sum   = 0;

        Set<String> low60 = new HashSet<>();
        Set<String> big60 = new HashSet<>();
        Collections.sort(students);
        System.out.println("最低分："+students.get(0));
        System.out.println("最高分："+students.get(students.size()-1));
        for (Student student : students) {
            sum += student.getScore();
            if (student.getScore() < 60){
                low60.add(student.getName());
            }else if (student.getScore()>= 60 && student.getScore()<70){
                big60.add(student.getName());
                _60_70_++;
            }else if (student.getScore()>=70 && student.getScore()<80){
                big60.add(student.getName());
                _70_80_++;
            }else if (student.getScore()>=80 && student.getScore()<90){
                big60.add(student.getName());
                _80_90_++;
            }else if (student.getScore()>=90){
                big60.add(student.getName());
                _big_90++;
            }
        }
        System.out.println("lower 60 students:" + low60);
        System.out.println("count:"+low60.size());
        System.out.println("bigger 60 students:" + big60);
        System.out.println("count:"+big60.size());

        System.out.println("lower 60:" + low60.size());
        System.out.println("60 - 70 :"+_60_70_);
        System.out.println("70 - 80 :"+_70_80_);
        System.out.println("80 - 90 :"+_80_90_);
        System.out.println("90 - 100 :"+_big_90);

        System.out.println("sum :"+ sum);
        System.out.println("avg:"+sum/students.size());
    }

    private void exit() throws Exception{
        System.out.println("bye bye ~~");
        int a = 1/0;
    }

    public void inputInfo(){
        System.out.println("please enter the student's name and score forever until scan the '-1', between name and score user 'space' , like :");
        System.out.println("林英茂 99 ");
        System.out.println("莫成妮 100");
        while (true) {
            System.out.println("enter your data:");
            String name = ScannerUtil.getNext();
            if ("-1".equalsIgnoreCase(name)){
                name = ScannerUtil.getLine();
                System.out.println("finish!" + name);
                return;
            }
            float score = ScannerUtil.getNextFloat();
            Student student = new Student(name,score);
            students.add(student);
            System.out.println("success add:" + student);
        }
    }
}
