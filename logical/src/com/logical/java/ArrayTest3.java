package com.logical.java;

import java.util.Scanner;

public class ArrayTest3 {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enetr how many integer");
        int n= scanner.nextInt();
        String name[]=new String[n];
        System.out.println("Enter Nmaes");
        for (int i = 0; i < name.length;i++)
            name[i]=scanner.next();
        System.out.println("names are");
        for (String value:name)
            System.out.println(value.toUpperCase());
    }   }