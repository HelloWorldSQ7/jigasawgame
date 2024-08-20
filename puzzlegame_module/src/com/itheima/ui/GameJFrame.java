package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // JFrame界面 窗体
    // 子类也表示界面、窗体
    // 规定：GameJFrame这个界面表示的就是游戏的主界面
    // 以后跟游戏相关的逻辑都写在这个类中

    // 创建一个二维数组
    // 目的：用来管理数据
    int[][] data = new int[4][4];

    // 定义一个变量，记录当前展示图片的路径
    String path = "/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/src/Resource/animal/segment_";

    // 定义正确拼图的数组
    int[][] win = {
            {0,1,2,3},
            {4,5,6,7},
            {8,9,10,11},
            {12,13,14,15}
    };

    // 定义变量用来统计步数
    int step = 0;

    // 创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");


    // 调用空参构造的意义？为什么
    public GameJFrame() {
        /*
        // 初始化界面
        // 设置界面的宽高
        this.setSize(603,680);
        // 设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        //DO_NOTHING_ON_CLOSE or 0 都表示点击关闭无反应
        // 2表示如果有多个界面时，只有关闭最后一个界面，虚拟机才会停止
        this.setDefaultCloseOperation(3);

        // 初始化菜单
        // 创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        // 创建菜单上面的两个选项的对象（功能、关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        // 创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        // 将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        // 将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 给整个界面设置菜单（把上面的菜单加入到创建的界面当中）
        this.setJMenuBar(jMenuBar);

         */

        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        // 初始化数据（打乱）
        initData();

        // 初始化图片（根据打乱后的结果去加载图片）
        initImage();

        // 让界面显示出来，建议写在最后
        this.setVisible(true);
    }
    // 判断data数组中的数据是否与win相同 相同true不同false
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i][j] != win[i][j]) {
                    // 只要有一个数据不一样，就返回false
                    return false;
                }
            }
            // 循环结束表示数组遍历比较完毕，全部一样返回true
        }
        return true;
    }
    // 打乱数据
    int x = 0;
    int y = 0;
    public void initData(){
        // 需求：把一个数组中的数据：0-15打乱顺序
        // 然后再按照4个一组的方式添加到二维数组中
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            // 拿着遍历到的每一个数据，跟随机索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        // 给二维数组添加数据
        // 解法一：
        // 遍历一堆数组tempArr得到每一个元素，把每一个元素依次添加到二维数组当中
        for (int i = 0; i < tempArr.length; i++) {
            // i=0 --- 0 0
            // i=1 --- 0 1
            // i=2 --- 0 2
            if (tempArr[i] == 0){
                // 记录空白方块在二维数组中的位置
                x = i / 4;
                y = i % 4;
                // 重新开始后空白方块会消失（因为0不被添加，原位置还保留原有数据未被覆盖）所以删掉else
            }// else{
                data[i / 4][i % 4] = tempArr[i];

        }
    }

    // 初始化界面优化为方法
    private void initJFrame(){
        // 设置界面的宽高
        this.setSize(603,680);
        // 设置界面的标题
        this.setTitle("拼图单机版 v1.0");
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

        // 给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    // 初始化菜单优化为方法
    private void initJMenuBar(){
        // 创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        // 创建菜单上面的两个选项的对象（功能、关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        // 将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        // 给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        // 将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 给整个界面设置菜单（把上面的菜单加入到创建的界面当中）
        this.setJMenuBar(jMenuBar);
    }
    // 初始化图片
    // 添加图片的时候，按照二维数组中管理的数据添加图片
    private void initImage() { // 初始化图片
        // 清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        if (victory()) {
            // 显示胜利的图标
            this.getContentPane().removeAll();
            JLabel winJaLbel = new JLabel("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/src/Resource/win.jpeg");
            winJaLbel.setBounds(203,283,241,180);
            this.getContentPane().add(winJaLbel);
        }

        JLabel stepCount = new JLabel("步数" + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 获取当前要加载图片的序号
                int num = data[i][j];
                // 路径分为两种：
                // 绝对路径：一定是从盘符开始的 C:\D:\
                // 相对路径：不是从盘符开始的
                // 相对路径对当前项目而言的 aaa\\bbb
                // 在当前项目下，去找aaa文件夹，里面再找bbb文件夹
                ImageIcon icon = new ImageIcon( path + num + ".jpeg" );
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(125 * j + 70, 125 * i + 100, 125, 125);
                // 给图片添加边框
                // 1/BevelBorder.LOWERED：下凹
                // 0/BevelBorder.RAISED：上凸
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                this.getContentPane();
                this.add(jLabel);
            }
        }

        // 添加背景图片
        // 先加载的图片在上方，后加载的图片塞在下方
        ImageIcon bg = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/src/Resource/background.jpeg");
        JLabel background = new JLabel(bg);
        background.setBounds(70,100,500,500);
        // 把背景图片添加到界面当中
        this.getContentPane();
        this.add(background);

        // 刷新一下界面
        this.getContentPane().repaint();

/*
        // 创建一个图片ImageIcon的对象
        ImageIcon icon1 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        // 创建一个JLabel的对象（管理容器）
        JLabel jLabel1 = new JLabel(icon1);
        // 指定图片位置
        jLabel1.setBounds(0, 0, 110, 110);
        // 分为三部分 顶 中 下 JFrame只是大的架子，下才是装载所有组件的
        // 窗体getContenPane()获取，将要显示的图片都交给它，如果没有特殊要求，默认放在中间
        // 调用setLayout(null)取消默认居中方式（在初始化界面时就取消）

        // 将管理容器添加到界面当中
        this.getContentPane();
        this.add(jLabel1);

        ImageIcon icon2 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel2 = new JLabel(icon2);
        jLabel2.setBounds(150, 0, 150, 150);
        this.getContentPane();
        this.add(jLabel2);

        ImageIcon icon3 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel3 = new JLabel(icon3);
        jLabel3.setBounds(300, 0, 150, 150);
        this.getContentPane();
        this.add(jLabel3);

        ImageIcon icon4 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel4 = new JLabel(icon4);
        jLabel4.setBounds(315, 0, 150, 150);
        this.getContentPane();
        this.add(jLabel4);


        ImageIcon icon5 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel5 = new JLabel(icon5);
        jLabel5.setBounds(0, 105, 150, 150);
        this.getContentPane();
        this.add(jLabel5);

        ImageIcon icon6 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel6 = new JLabel(icon6);
        jLabel6.setBounds(105, 105, 110, 110);
        this.getContentPane();
        this.add(jLabel6);

        ImageIcon icon7 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel7 = new JLabel(icon7);
        jLabel7.setBounds(210, 105, 110, 110);
        this.getContentPane();
        this.add(jLabel7);

        ImageIcon icon8 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel8 = new JLabel(icon8);
        jLabel8.setBounds(315, 105, 110, 110);
        this.getContentPane();
        this.add(jLabel8);


        ImageIcon icon9 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel9 = new JLabel(icon9);
        jLabel9.setBounds(0, 210, 110, 110);
        this.getContentPane();
        this.add(jLabel9);

        ImageIcon icon10 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel10 = new JLabel(icon10);
        jLabel10.setBounds(105, 210, 110, 110);
        this.getContentPane();
        this.add(jLabel10);

        ImageIcon icon11 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel11 = new JLabel(icon11);
        jLabel11.setBounds(210, 210, 110, 110);
        this.getContentPane();
        this.add(jLabel11);

        ImageIcon icon12 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel12 = new JLabel(icon12);
        jLabel12.setBounds(315, 210, 110, 110);
        this.getContentPane();
        this.add(jLabel12);


        ImageIcon icon13 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel13 = new JLabel(icon13);
        jLabel13.setBounds(0, 315, 110, 110);
        this.getContentPane();
        this.add(jLabel13);

        ImageIcon icon14 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel14 = new JLabel(icon14);
        jLabel14.setBounds(105, 315, 110, 110);
        this.getContentPane();
        this.add(jLabel14);

        ImageIcon icon15 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel15 = new JLabel(icon15);
        jLabel15.setBounds(210, 315, 110, 110);
        this.getContentPane();
        this.add(jLabel15);

        ImageIcon icon16 = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
        JLabel jLabel16 = new JLabel(icon16);
        jLabel16.setBounds(315, 315, 110, 110);
        this.getContentPane();
        this.add(jLabel16);



        for (int i = 0; i < 4; i++) {
            ImageIcon icon = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(150 * i, 0, 150, 150);
            this.getContentPane();
            this.add(jLabel);
        }

        for (int i = 0; i < 4; i++) {
            ImageIcon icon = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(150 * i, 150, 150, 150);
            this.getContentPane();
            this.add(jLabel);
        }

        for (int i = 0; i < 4; i++) {
            ImageIcon icon = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(150 * i,300, 150, 150);
            this.getContentPane();
            this.add(jLabel);
        }

        for (int i = 0; i < 4; i++) {
            ImageIcon icon = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/Resource/animal/download.jpeg");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(150 * i,450 , 150, 150);
            this.getContentPane();
            this.add(jLabel);
        }
*/

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    // 按下不松时会调用这个方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // 按的是A
        if (code == 65){
            // 把界面中所有的图片都删除
            this.getContentPane().removeAll();
            // 加载第一张完整的图片
            JLabel all = new JLabel(new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/src/Resource/animal/all.jpeg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            // 加载背景图片
            // 先加载的图片在上方，后加载的图片塞在下方
            ImageIcon bg = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/src/Resource/background.jpeg");
            JLabel background = new JLabel(bg);
            background.setBounds(70,100,500,500);
            // 把背景图片添加到界面当中
            this.getContentPane();
            this.add(background);
            // 刷新
            this.getContentPane().repaint();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 判断游戏是否胜利，如果胜利，游戏直接结束，无法再移动代码
        if (victory()){
            // return: 1.返回结果 2.结束方法
            return;
        }

        // 对上下左右进行判断
        // 左：37 上：38 右：39 下：40
        int code = e.getKeyCode();
        if (code == 37){
            System.out.println("向左移动");
            if (y == 3){
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            // x++理解为 [2][0] --- [2][1] 向右移动，因此x增加
            y++;
            // 每移动一次，计数器就自增一次
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 38) {
            System.out.println("向上移动");
            if (x == 3){
                // 空白方块在最下方，下方无图片
                return;
            }
            // 逻辑：把空白方块下方的数字向上移动
            // x,y 表示空白方块
            // x+1,y 表示空白方块下方的数字
            // 把空白方块下方的数字赋值给空白方块（实际是空白方块在移动）
            // Bug：x等于4 超过边界
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            // x++理解为 [2][0] --- [2][1] 向右移动，因此x增加
            x++;
            // 每移动一次，计数器就自增一次
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 39) {
            System.out.println("向右移动");
            if (y == 0){
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            // x++理解为 [2][0] --- [2][1] 向右移动，因此x增加
            y--;
            // 每移动一次，计数器就自增一次
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 40) {
            System.out.println("向下移动");
            if (x == 0){
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            // x++理解为 [2][0] --- [2][1] 向右移动，因此x增加
            x--;
            // 每移动一次，计数器就自增一次
            step++;
            // 调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 65) {
            // 松开时，重新加载拼图图片
            initImage();
        } else if (code == 87) {
            data = new int[][] {
                    {0,1,2,3},
                    {4,5,6,7},
                    {8,9,10,11},
                    {12,13,14,15}
            };
            initImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取被点击条目的对象 因此需要放到成员位置
        Object obj = e.getSource();
        // 判断点击的对象
        if (obj == replayItem) {
            System.out.println("重新游戏");
            // 计步器清零（加载图片的时候还没清零，因此先清零）
            step = 0;
            // 再次打乱二维数组中的数据
            initData();
            // 重新加载图片
            initImage();

        } else if (obj == reLoginItem) {
            System.out.println("重新登录");
            // 关闭当前的游戏界面
            this.setVisible(false);
            // 打开登录界面(创建登录界面的对象)
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            // 直接关闭虚拟机即可
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("公众号");
            // 创建一个弹框对象
            JDialog jDialog = new JDialog();
            // 创建一个管理图片的容器JLabel
            ImageIcon icon = new ImageIcon("/Users/spencerqin_7/IdeaProjects/jigasawgame/puzzlegame_module/src/Resource/about.jpeg");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(0,0,267,180);
            // 把图片添加到弹框当中
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            // 让弹框置顶
            jDialog.setAlwaysOnTop(true);
            // 让弹框居中
            jDialog.setLocationRelativeTo(null);
            // 弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            // 让弹框显示出来
            jDialog.setVisible(true);
        }

    }
}
