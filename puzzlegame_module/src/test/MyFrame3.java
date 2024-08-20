package test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame3 extends JFrame implements KeyListener {

    public MyFrame3(){
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

        // 给整个窗体添加键盘监听
        // 调用者this：本类对象，当前的界面对象，表示我要给整个界面添加监听
        // addKeyListener：表示要给本界面添加键盘监听
        // 参数this：当事件被触发之后，会执行本类中对应的代码
        this.addKeyListener(this);


        this.setVisible(true);
    }
    // 细节1:
    // 如果按下一个按键没有松开，那么会重复调用keyPressed方法
    // 细节2:
    // 键盘里那么多按键，如何进行区分
    // 每一个按键都有一个编号与之对应
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        //获取键盘上每一个按键的编号
        int code = e.getKeyCode();
        if (code == 65){
            System.out.println("A");
        } else if (code == 66) {
            System.out.println('B');
        }
        System.out.println(code);

    }
}
