package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork3 {

    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        guessNumber();
        while (true) {
            System.out.println("Сыграть еще раз? 1 - да/ 0 - нет");
            int x = scr.nextInt();
            if (x == 1) guessNumber();
            else if (x == 0) {
                System.out.println("Спасибо за игру!");
                break;
            }
            else System.out.println("Вы ввели не верную команду. " +
                                    "Повторите ввод: ");
        }
        guessWord();

    }
    public static void guessNumber() {
        System.out.println("Игра угадайте число");
        int num = (int) (Math.random()*10);
        int lives = 3;
        while(lives > 0) {
            System.out.println("Угадайте число от 0 до 9");
            int input = scr.nextInt();
            if (input == num) {
                System.out.println("Вы угадали!");
                break;
            }
            else if (input > num) {
                System.out.println("Загаданное число меньше");
                lives--;
            }
            else {
                System.out.println("Загаданное число больше");
                lives--;
            }
            if (lives == 0) System.out.println("Вы проиграли, " +
                                        "загаданное число = " + num);
        }
    }

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int x = (int) (Math.random() * (words.length));
        System.out.println("Игра угадайте выбранное слово из перечисленных: ");
        System.out.println(Arrays.toString(words));
        String enigma = words[x];
        char[] plug = new char[15];
        for (int i = 0; i < plug.length; i++) {
            plug[i] = '#';
        }
        while(true) {
        String answer = scr.next();
        if (answer.equals(enigma)) {
                System.out.println("Вы угадали!");
                break;
        }
        else {
            System.out.println("Не верно! Правильно названные буквы в слове: ");
            for (int i = 0; i < 15; i++) {
                if (i < enigma.length() && i < answer.length() &&
                        enigma.charAt(i) == answer.charAt(i))
                        plug[i] = enigma.charAt(i);
            }
            for (int i = 0; i < plug.length; i++) {
                System.out.print(plug[i]);
                }
            System.out.println("\n Попробуйте еще раз: ");
            }
        }
    }
}
