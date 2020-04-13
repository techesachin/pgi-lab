package com.logical.java;

import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter any number");
        int year= Integer.parseInt(scanner.nextLine());
        if(year%4 == 0|| year% 400==0)
            System.out.println("leap year");
        else
            System.out.println("not lea year");
    }
}
