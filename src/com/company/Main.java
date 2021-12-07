package com.company;

import java.util.List;
import java.util.Scanner;

import com.company.PerformanceTester;

public class Main {

    public static void main(String[] args) {

            PerformanceTester test = new PerformanceTester(100000);
            System.out.println(test.toString());
    }
}
