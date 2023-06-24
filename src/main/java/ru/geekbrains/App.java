package ru.geekbrains;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        task1();
        task2();
        task3();
        scanner.close();
    }

    private static void task1() {
        System.out.println();
        System.out.println("Задание 1");
        System.out.println();
        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();
        long sum = 0;
        long factor = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            factor *= i;
        }

        System.out.println(n + "-е треугольное число равно " + sum);
        System.out.println("Факториал числа " + n + " равен " + factor);
    }

    private static void task2() {
        System.out.println();
        System.out.println("Задание 2");
        System.out.println();
        ArrayList<Integer> simple = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            int devider = 1;
            for (int j : simple) {
                devider = i % j;
                if (devider == 0) {
                    break;
                }
            }
            if (devider != 0) {
                simple.add(i);
            }
        }

        System.out.println("Простые числа от 1 до 1000");
        System.out.println(simple.toString());
    }

    private static void task3() {
        System.out.println();
        System.out.println("Задание 3");
        System.out.println();
        String command = "";
        int a, b;
        String operator = "", next = "";
        float result = 0;
        while (command != null) {
            try {
                System.out.print("Введите первое число: ");
                a = scanner.nextInt();
                System.out.print("Введите оператор +, -, * или / : ");
                operator = scanner.next("[+-/*//]");
                System.out.print("Введите второе число: ");
                b = scanner.nextInt();
                switch (operator) {
                    case ("+"):
                        result = (int) a + b;
                        break;
                    case ("-"):
                        result = (int) a - b;
                        break;
                    case ("/"):
                        result = (float) a / b;
                        break;
                    case ("*"):
                        result = (int) a * b;
                        break;
                }
                System.out.println("Результат: " + a + operator + b + "=" + new DecimalFormat("#.###").format(result));
            } catch (Exception e) {
                System.out.println("Не верный ввод, попробуйте снова");
                scanner.next();
            }
            System.out.print("Для завершения введите Y, для продолжения любой символ: ");
            next = scanner.next();
            if (Objects.equals(next, "Y")) {
                command = null;
            }
        }
    }
}
