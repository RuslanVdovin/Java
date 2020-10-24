package lesson4;

import java.util.Scanner;

public class TicTacToe {

    public static Scanner scr = new Scanner(System.in);
    private static char[][] map;
    private static int SIZE;
    private static boolean checkMove;
    private static char user = 'X';
    private static char pc = 'O';
    private static final char DEFAULT = '_';

    public static void initMap(int size){
        SIZE = size;
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DEFAULT;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static boolean moveUser(int x, int y, char user) {
        checkMove = false;
            try {
                if (map[x][y] == DEFAULT) {
                    map[x][y] = user;
                    checkMove = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                checkMove = false;
            }
        return checkMove;
    }

    private static boolean moveAI() {
        if (checkMove) {
            System.out.println("Ход компьютера");

            for (int i = 0; i < SIZE; i++) {
                if (map[0][i] == user && map[0][i] == map[1][i] && map[2][i] == DEFAULT ||
                        map[0][i] == pc && map[0][i] == map[1][i] && map[2][i] == DEFAULT) {
                    map[2][i] = pc;
                    checkMove = false;
                    break;
                } else if (map[i][0] == user && map[i][0] == map[i][1] && map[i][2] == DEFAULT ||
                        map[i][0] == pc && map[i][0] == map[i][1] && map[i][2] == DEFAULT) {
                    map[i][2] = pc;
                    checkMove = false;
                    break;
                } else if (map[i][2] == user && map[i][2] == map[i][1] && map[i][0] == DEFAULT ||
                        map[i][2] == pc && map[i][2] == map[i][1] && map[i][0] == DEFAULT) {
                    map[i][0] = pc;
                    checkMove = false;
                    break;
                } else if (map[i][0] == user && map[i][0] == map[i][2] && map[i][1] == DEFAULT ||
                        map[i][0] == pc && map[i][0] == map[i][2] && map[i][1] == DEFAULT) {
                    map[i][1] = pc;
                    checkMove = false;
                    break;
                } else if (map[0][i] == user && map[0][i] == map[2][i] && map[1][i] == DEFAULT ||
                        map[0][i] == pc && map[0][i] == map[2][i] && map[1][i] == DEFAULT) {
                    map[1][i] = pc;
                    checkMove = false;
                    break;
                } else if (map[0][0] == user && map[0][0] == map[1][1] && map[2][2] == DEFAULT ||
                        map[0][0] == pc && map[0][0] == map[1][1] && map[2][2] == DEFAULT) {
                    map[2][2] = pc;
                    checkMove = false;
                    break;
                } else if (map[2][2] == user && map[2][2] == map[1][1] && map[0][0] == DEFAULT ||
                        map[2][2] == pc && map[2][2] == map[1][1] && map[0][0] == DEFAULT) {
                    map[0][0] = pc;
                    checkMove = false;
                    break;
                } else if (map[2][0] == user && map[2][0] == map[1][1] && map[0][2] == DEFAULT ||
                        map[2][0] == pc && map[2][0] == map[1][1] && map[0][2] == DEFAULT) {
                    map[0][2] = pc;
                    checkMove = false;
                    break;
                } else if (map[0][2] == user && map[0][2] == map[1][1] && map[2][0] == DEFAULT ||
                        map[0][2] == pc && map[0][2] == map[1][1] && map[2][0] == DEFAULT) {
                    map[2][0] = pc;
                    checkMove = false;
                    break;
                } else if (map[0][0] == user && map[0][0] == map[2][2] && map[1][2] == DEFAULT) {
                    map[1][2] = pc;
                    checkMove = false;
                    break;
                } else if (map[0][0] == user && map[0][2] == map[0][0] && map[2][1] == map[0][0]
                        && map[1][0] == DEFAULT) {
                    map[1][0] = pc;
                    checkMove = false;
                    break;
                } else if (map[2][0] == user && map[2][0] == map[2][2] && map[2][1] == DEFAULT) {
                    map[2][1] = pc;
                    checkMove = false;
                    break;
                } else if (map[2][0] == user && map[2][0] == map[2][1] && map[2][2] == DEFAULT) {
                    map[2][2] = pc;
                    checkMove = false;
                    break;
                } else if (map[2][2] == user && map[2][2] == map[2][1] && map[2][0] == DEFAULT) {
                    map[2][0] = pc;
                    checkMove = false;
                    break;
                } else if (map[0][2] == user && map[0][2] == map[2][2] && map[1][2] == DEFAULT) {
                    map[1][2] = pc;
                    checkMove = false;
                    break;
                } else if (map[0][0] == user && map[2][0] == map[0][0] && map[1][2] == map[0][0]
                        && map[0][1] == DEFAULT) {
                    map[0][1] = pc;
                    checkMove = false;
                    break;
                } else if (map[i][i] == DEFAULT) {
                    map[i][i] = pc;
                    checkMove = false;
                    break;
                }
            }

        }
            return checkMove;
    }

    static boolean checkMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DEFAULT)
                    return false;
            }
        }
        return true;
    }

    static boolean checkWin(char mark) {
        for (int i = 0; i < SIZE; i++) {
                if(map[0][i] == mark && map[0][i] == map[1][i] && map[0][i] == map[2][i])
                    return true;
                else if (map[i][0] == mark && map[i][0] == map[i][1] && map[i][0] == map[i][2])
                    return true;
            }
        if (map[0][0] == mark && map[0][0] == map[1][1] && map[0][0] == map[2][2])
            return true;
        else if (map[2][0] == mark && map[2][0] == map[1][1] && map[2][0] == map[0][2])
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Игра крестики-нолики.");
        System.out.println("Для совершения хода, введите номер стороки и номер столбца");
        System.out.println("Вы играете за Х");
        initMap(3);
        printMap();
        while (true) {
            System.out.println("Ваш ход: ");
            int x, y;
            try {
                x = scr.nextInt() - 1;
                y = scr.nextInt() - 1;
            } catch(Exception e) {
                System.out.println("Введите корректные данные");
                scr.nextLine();
                continue;
            }
            if (moveUser(x, y, user)) {
                printMap();
                if (checkWin(user)) {
                    System.out.println("Вы выйграли!");
                    break;
                }
                if (checkMove) {
                    moveAI();
                    printMap();
                }
                if (checkWin(pc)) {
                    System.out.println("Вы проиграли!");
                    break;
                }
                if (checkMap()) {
                    System.out.println("Ничья!");
                    break;
                }
            }
            else System.out.println("Введите корректные данные");
        }
    }
}