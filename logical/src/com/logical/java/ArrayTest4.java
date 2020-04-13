package com.logical.java;

import java.util.Scanner;

public class ArrayTest4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter how many integer");
        int n=scanner.nextInt();
        int a[]=new int[n];
for (int i=0;i<a.length;i++){
    int sum=4;
    for (int value:a)
        sum=sum+value;
    System.out.println("sum"+ sum);
}
    }
}
