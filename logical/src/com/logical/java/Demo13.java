package com.logical.java;

import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter any number");
        int num=scanner.nextInt();
        int count =0;
        if(num ==0)
            count=1;
        else{
            while (num!=0){
                count++;
                num=num/10;
            }
        }
        System.out.println("\nlenth of number "+ count);


    }
}
