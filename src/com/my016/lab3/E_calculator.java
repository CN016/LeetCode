package com.my016.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Vector;

public class E_calculator {
    JButton st;	 // st的作用类似于寄存器
    /* 以下i_1至i_5为状态开关 */
    int i_1 = 1;
    int i_2 = 1; 	// 开关2用于记录符号键的次数
    int i_3 = 1; 	// 开关3用于标识 str1 是否可以被清 0
    int i_4 = 1; 	// 开关4用于标识 str2 是否可以被清 0
    int i_5 = 1;	 // 开关5用于控制小数点可否被录入
    String str1 = "0";	 // 操作数1，为了程序的安全，初值设置为0
    String str2 = "0"; 	// 操作数2
    String signal = "+";	 // 运算符
    String result = ""; 	// 运算结果
    Vector vt = new Vector(20, 20);
    // 创建一个 JFrame 对象并初始化
    JFrame frame = new JFrame("简易计算器");
    // JTextField用于显示操作和计算结果的文本框
    JTextField TextField = new JTextField(result, 30);
    JButton clear_Button = new JButton("清 除"); 	// 清除按钮
    /* 数字键0到9 */
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    // 计算命令按钮，加减乘除以及小数点等
    JButton button_jia = new JButton("+");
    JButton button_jian = new JButton("—");
    JButton button_cheng = new JButton("*");
    JButton button_chu = new JButton("/");
    JButton button_dy = new JButton("=");
    JButton button_Dian = new JButton(".");
    //创建E_calculator()方法中编写数字键的响应逻辑
    public E_calculator() {
        button0.setMnemonic(KeyEvent.VK_0);
        TextField.setHorizontalAlignment(JTextField.RIGHT);
        JPanel panel = new JPanel();// 创建一个 Jpanel 对象并初始化
// 设置该容器的布局为四行四列，边距为10像素
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setSize(500, 800);
        panel.setBackground(Color.gray); 	// 设置背景颜色为灰色
        /* 将用于计算的按钮添加到容器内 */
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button_cheng);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button_chu);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button_jian);
        panel.add(button0);
        panel.add(button_Dian);
        panel.add(button_dy);
        panel.add(button_jia);
// 设置panel对象的边距为16
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));						JPanel panel2 = new JPanel();	// 按照同样的方式设置第二个JPanel
        panel2.add(TextField, BorderLayout.WEST);
        panel2.add(clear_Button, BorderLayout.EAST);
        frame.setLocation(400, 200);		// 设置主窗口出现在屏幕上的位置
        frame.setResizable(true);		// 设置窗体可以调大小
        frame.getContentPane().setLayout(new BorderLayout());
        // 窗体中可以放置 JPanel，这里我们将面板panel和面板panel2让如窗体
        frame.getContentPane().add(panel2, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        /* Listener类中编写的是数字键的响应逻辑*/
        class Listener implements ActionListener {
            public void actionPerformed(ActionEvent test) {
                String ss = ((JButton) test.getSource()).getText();
                st = (JButton) test.getSource();
                vt.add(st);
                if (i_1 == 1) {
                    if (i_3 == 1) {
                        str1 = "";
                        i_5 = 1;
                    }
                    str1 = str1 + ss;
                    i_3 = i_3 + 1;
                    TextField.setText(str1);
                } else if (i_1 == 2) {
                    if (i_4 == 1) {
                        str2 = "";
                        i_5 = 1;
                    }
                    str2 = str2 + ss;
                    i_4 = i_4 + 1;
                    TextField.setText(str2);
                }
            }
        }

        /* Listener_signal类中编写了运算符号键的响应逻辑 */
        class Listener_signal implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                st = (JButton) e.getSource();
                vt.add(st);
                if (i_2 == 1) {
                    i_1 = 2;
                    i_5 = 1;
                    signal = ss2;
                    i_2 = i_2 + 1;
                } else {
                    int a = vt.size();
                    JButton c = (JButton) vt.get(a - 2);
                    if (!(c.getText().equals("+")) && !(c.getText().equals("—")) 						&& !(c.getText().equals("*"))&& !(c.getText().equals("/"))) {
                        cal();
                        str1 = result;
                        i_1 = 2;
                        i_5 = 1;
                        i_4 = 1;
                        signal = ss2;
                    }
                    i_2 = i_2 + 1;
                }
            }
        }

        /*Listener_clear类中编写了清除键的响应逻辑*/
        class Listener_clear implements ActionListener {
            public void actionPerformed(ActionEvent test) {
                st = (JButton) test.getSource();
                vt.add(st);
                i_5 = 1;
                i_2 = 1;
                i_1 = 1;
                i_3 = 1;
                i_4 = 1;
                str1 = "0";
                str2 = "0";
                signal = "";
                result = "";
                TextField.setText(result);
                vt.clear();
            }
        }

        /*Listener_dy类中编写的是等于号键的响应逻辑*/
        class Listener_dy implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                st = (JButton) e.getSource();
                vt.add(st);
                cal();
                i_1 = 1;
                i_2 = 1;
                i_3 = 1;
                i_4 = 1;
                str1 = result;
            }
        }

        /*Listener_xiaos类中编写的是小数点键的相应逻辑*/
        class Listener_xiaos implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                st = (JButton) e.getSource();
                vt.add(st);
                if (i_5 == 1) {
                    String ss2 = ((JButton) e.getSource()).getText();
                    if (i_1 == 1) {
                        if (i_3 == 1) {
                            str1 = "";
                            i_5 = 1;
                        }
                        str1 = str1 + ss2;
                        i_3 = i_3 + 1;
                        TextField.setText(str1);
                    } else if (i_1 == 2) {
                        if (i_4 == 1) {
                            str2 = "";
                            i_5 = 1;
                        }
                        str2 = str2 + ss2;
                        i_4 = i_4 + 1;
                        TextField.setText(str2);
                    }
                }
                i_5 = i_5 + 1;
            }
        }
        // 监听等于键
        Listener_dy jt_dy = new Listener_dy();
        // 监听数字键
        Listener jt = new Listener();
        // 监听符号键
        Listener_signal jt_signal = new Listener_signal();
        // 监听清除键
        Listener_clear jt_c = new Listener_clear();
        // 监听小数点键
        Listener_xiaos jt_xs = new Listener_xiaos();
        button7.addActionListener(jt);
        button8.addActionListener(jt);
        button9.addActionListener(jt);
        button_chu.addActionListener(jt_signal);
        button4.addActionListener(jt);
        button5.addActionListener(jt);
        button6.addActionListener(jt);
        button_cheng.addActionListener(jt_signal);
        button1.addActionListener(jt);
        button2.addActionListener(jt);
        button3.addActionListener(jt);
        button_jian.addActionListener(jt_signal);
        button0.addActionListener(jt);
        button_Dian.addActionListener(jt_xs);
        button_dy.addActionListener(jt_dy);
        button_jia.addActionListener(jt_signal);
        clear_Button.addActionListener(jt_c);
        // 窗体关闭事件的响应程序
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    // cal()方法中编写了计算逻辑的实现。
    public void cal() {
        double a2,b2;	//定义两个变量a2,b2
        String c = signal;
        double result2 = 0;		//初始化
        if (c.equals("")) {
            TextField.setText("Please input operator");
        } else {
            if (str1.equals("."))
                str1 = "0.0";
            if (str2.equals("."))
                str2 = "0.0";
            a2 = Double.valueOf(str1).doubleValue();
            b2 = Double.valueOf(str2).doubleValue();
            if (c.equals("+")) {
                result2 = a2 + b2;
            }
            if (c.equals("—")) {
                result2 = a2 - b2;
            }
            if (c.equals("*")) {
                BigDecimal m1 = new BigDecimal(Double.toString(a2));
                BigDecimal m2 = new BigDecimal(Double.toString(b2));
                //乘法运算,只需导入组件（import  java.math.BigDecimal）
                result2 = m1.multiply(m2).doubleValue();
            }
            if (c.equals("/")) {
                if (b2 == 0) {
                    result2 = 0;
                } else {
                    result2 = a2 / b2;
                }
            }
            result = ((new Double(result2)).toString());
            TextField.setText(result);
        }
    }
    public static void main(String[] args) {
        E_calculator CT = new E_calculator();
    }
}