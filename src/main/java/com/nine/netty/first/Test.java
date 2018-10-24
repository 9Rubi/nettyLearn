package com.nine.netty.first;

/**
 * @author : Rubi
 * @version : 2018-10-24 11:23
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("格点个数为"+calc(125));
    }

    /**
     * rSquare = r^2
     * @param rSquare
     * @return num 格点个数
     */
    public static int  calc(int rSquare){
        //格点数量
        int num=0;
        int x=0;
        while(x*x<rSquare){
            //开更号
           double y= Math.sqrt(rSquare-x*x);
           //如果y是整数 ,即 x^2 + y^2 = rSquare 且x ,y都为整数
           if(y==(int)y){
               System.out.println("整数");
               System.out.println(x+","+y);
               num++;
           }
            x+=1;

        }
        return 4*num;
    }
}
