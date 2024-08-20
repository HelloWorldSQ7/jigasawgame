package test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame2 extends JFrame implements MouseListener {

    JButton jbt1 = new JButton("点我啊");

    public MyFrame2() {
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
        // 给按钮绑定鼠标事件
        jbt1.addMouseListener(this);

        // 将按钮添加到整个界面当中
        this.getContentPane().add(jbt1);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
