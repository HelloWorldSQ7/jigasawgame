package test;

import java.util.Random;

public class test2 {
    public static void main(String[] args) {
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
        for (int i = 0; i < tempArr.length; i++) {
            System.out.println(tempArr[i] + ",");
        }
        // 分隔作用
        System.out.println();

        // 创建一个二维数组
        int [][] data = new int[4][4];

        // 解法2
        // 遍历二维数组，给里面每一个数据赋值
        // 遍历二维数组
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = tempArr[index];
                index++;
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
