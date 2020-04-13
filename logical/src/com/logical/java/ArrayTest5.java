package com.logical.java;

import java.util.Scanner;

class Employee{
    private int empno;
    private String ename;
    private float salary;
    void read(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter empno");
        empno=scanner.nextInt();
        System.out.println("Enter ename");
        ename=scanner.next();
        System.out.println("Enter salary");
        salary=scanner.nextFloat();
    }
    void print(){
        System.out.println(empno+","+ename+","+salary);
    }
}
public class ArrayTest5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Employee[] emp=new Employee[n];
        for (int i=0;i<emp.length;i++){
            emp[i]=new Employee();
            emp[i].read();
        }
        for (Employee emp1:emp)
            emp1.print();

    }

}
