package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    // LoginJFrame 表示登录界面
    // 以后所有跟登录相关的代码，都写在这里

    public LoginJFrame() {
        // 在创建登录界面的时候，同时给这个界面去设置一些信息
        // 比如：宽高，直接展示出来

        // this就表示调用者的地址值（谁调用，谁就是this）
        this.setSize(488,430);
        this.setVisible(true);
    }
}
