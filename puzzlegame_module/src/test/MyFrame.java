package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {
    // 创建第一个按钮对象
    JButton jbt1 = new JButton("点我啊");

    // 创建第二个按钮对象
    JButton jbt2 = new JButton("点我啊");
    public MyFrame(){
        // 设置界面的宽高
        this.setSize(603,680);
        // 设置界面的标题
        this.setTitle("事件演示");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        //DO_NOTHING_ON_CLOSE or 0 都表示点击关闭无反应
        // 2表示如果有多个界面时，只有关闭最后一个界面，虚拟机才会停止
        this.setDefaultCloseOperation(3);

        // 取消默认居中方式，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);


        jbt1.setBounds(0,0,100,50);
        // 给按钮添加事件
        jbt1.addActionListener(this);


        jbt2.setBounds(0,0,100,50);
        // 给按钮添加事件
        jbt2.addActionListener(this);

        // this表示本类的对象，就会执行本类里面对应的代码（actionPerformed）

        // 将按钮添加到整个界面当中
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 对当前的按钮进行判断

        // 获取当前被操作对象的那个按钮对象
        Object source = e.getSource();
        if (source == jbt1){
            jbt1.setSize(200, 200);
        } else if (source == jbt2) {
            Random r = new Random();
            jbt2.setLocation(r.nextInt(500), r.nextInt(500));
        }
    }

}
