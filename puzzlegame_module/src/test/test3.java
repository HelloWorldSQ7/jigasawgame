package test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        // 设置界面的宽高
        jFrame.setSize(603,680);
        // 设置界面的标题
        jFrame.setTitle("事件演示");
        // 设置界面置顶
        jFrame.setAlwaysOnTop(true);
        // 设置界面居中
        jFrame.setLocationRelativeTo(null);
        // 设置关闭模式
        //DO_NOTHING_ON_CLOSE or 0 都表示点击关闭无反应
        // 2表示如果有多个界面时，只有关闭最后一个界面，虚拟机才会停止
        jFrame.setDefaultCloseOperation(3);

        // 取消默认居中方式，只有取消了才会按照XY轴的形式添加组件
        jFrame.setLayout(null);

        // 创建一个按钮对象
        JButton jbt = new JButton("点我啊");
        jbt.setBounds(0,0,100,50);
        // 给按钮添加动作监听
        // jbt：组件对象，表示你要给哪个组件添加事件
        // addActionListener：表示我要给组件添加哪个事件监听（动作监听包含鼠标左键点击，空格）
        // 参数：表示事件被触发之后要执行的代码
        // MyActionListener mal = new MyActionListener();
        // jbt.addActionListener(new MyActionListener());

        // 这个功能只被用到一次，因此用匿名内部类替换
        jbt.addActionListener(new MyActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("不要点我");
            }
        });

        // 把按钮添加到界面当中
        jFrame.getContentPane().add(jbt);

    }
}
