package cn.com.liandisys.derc;

import org.apache.log4j.Logger;

import java.util.Scanner;


/**
 * @author zhkai
 * @date 2021年3月22日11:23:08
 */


public class App {
    public static Logger logger = Logger.getLogger(App.class);
    private String str1 = "Hello";
    

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLong()){
            long num = scanner.nextLong();
            long t = num;
            for(int i = 2; i <= t; i++){
                while(num%i == 0){
                    num = num/i;
                    System.out.println(i);
                }
            }
        }
    }

}


