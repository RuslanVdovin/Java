package lesson1;

import java.util.Scanner;

public class HomeWork {

        public static void main(String[] args) {
            byte a = 127;
            short b = 32766;
            int c = 2147483646;
            long g = 1000000000000000000L;
            float f = 0.758f;
            double d = 1.5584;
            char k = 'R';
            boolean x = true;
            System.out.println(calculate(2.5f, 5.5f, 6.2f,2.2f));
            System.out.println(checkSum());
            positiveOrNegative(-5);
            System.out.println(isNegative(5));
            greeting("Руслан");
            leapYear(2100);

        }

        public static float calculate (float a, float b, float c, float d) {
            float f = a * (b + (c / d));
            return f;
        }

        public static boolean checkSum () {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (10 <= (a + b) && (a + b) <= 20) return true;
            else return false;
        }

        public static void positiveOrNegative (int x) {
            if (x >= 0) System.out.println ("Число X положительное");
            else System.out.println("Число X отрицательное");
        }

        public static boolean isNegative (int a) {
            if (a < 0) return true;
            else return false;
        }

        public static void greeting (String name){
            System.out.println("Привет, " + name + "!");
        }
        public static void leapYear(int x) {
            if (x % 4 == 0 && x % 100 != 0 || x % 400 == 0) {
                System.out.println(x + " високосный год");
            } else System.out.println(x + " не является високосным годом");
        }

}

