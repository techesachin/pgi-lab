package com.logical.java;

import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter number");
        int num=scanner.nextInt();
        if(num% 2==0)
            System.out.println("even");
        else
            System.out.println("odd");



    }
}
