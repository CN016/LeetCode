package com.my016.lab2;

import com.my016.lab2.object.Student;
import com.my016.lab2.page.StartMenu;

import java.util.LinkedList;
import java.util.List;

public class Application {
    static List<Student> students = new LinkedList<>();   //多态
    public static void main(String[] args) {
        StartMenu startMenu = new StartMenu(students);

        try {

            while (true) {
                startMenu.hello();
            }

        } catch (Exception ignored) {
        }
    }
}
