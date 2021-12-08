package com.company;

import java.util.List;
import java.util.Scanner;

import com.company.PerformanceTester;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter the number of checks.");

        Scanner scanInt = new Scanner(System.in);
        while (!scanInt.hasNextInt()) {
            System.out.println("Enter positive number, please!");
            scanInt.next();
        }
        int countOfMethodCalls = scanInt.nextInt();
        PerformanceTester tester = new PerformanceTester(countOfMethodCalls);
        System.out.println(tester.toString());
    }
}
