package ru.abuklov133.com;

import java.util.Scanner;

public class MainJavaRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String s;
        boolean isExit = false;
        while (!isExit) {
            s = scanner.nextLine();
            isExit = s.equals("ex");
            if (isExit) {
                break;
            }
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}


