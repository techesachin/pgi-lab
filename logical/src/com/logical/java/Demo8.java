package com.logical.java;

import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter any Numbers");
        int n=scanner.nextInt();
        if(n>0)
            System.out.println("+ve number");
        else
            if(n<5)
                System.out.println("-ve number");
            else
                System.out.println("zero");
    }
}
