package com.logical.java;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Enter rollNO");
        int rno=scanner.nextInt();
        System.out.println("Enter Name");
        String name=scanner.next();
        System.out.println("Enter fee");
        float fee=scanner.nextFloat();
        System.out.printf("\n rollNo:",rno);
        System.out.printf("\n Name:",name);
        System.out.printf("\n fee:",fee);
    }
}
