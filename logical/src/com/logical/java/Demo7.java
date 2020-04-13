package com.logical.java;

import java.util.Scanner;

public class Demo7 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("User Name");
        String user =scanner.next();
        System.out.println("Password");
        String pwd=scanner.next();
        if(user.equals("sipu") && pwd.equals("1234@"))
            System.out.println("Welcome to my Application");
        else
            System.out.println("invalid username or password");

    }
}
