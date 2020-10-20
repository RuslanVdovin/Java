package lesson2;

import java.util.Arrays;

public class HomeWork2 {

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
// первое задание
        int[] array = {1, 0, 0, 1, 0, 1, 1, 0};
        System.out.print(Arrays.toString(array) + '\n');
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        System.out.print(Arrays.toString(array) + '\n');
// второе задание
        int[] x = new int[8];
        for (int i = 1; i < x.length; i++) {
            x[i] = x[i - 1] + 3;
        }
        System.out.print('\n' + Arrays.toString(x) + '\n');
// третье задание
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print('\n' + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.print('\n' + Arrays.toString(arr) + '\n');
        System.out.println();
// четвертое задание
        int[][] m = new int[7][7];
        for (int i = 0; i < m.length; i++) {
            m[i][i] = 1;
            m[(m.length - 1) - i][i] = 1;
        }
        printArray(m);
        System.out.println();
// пятое задание
        int[] v = new int[10];
        int max = 0;
        int min = 0;
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) ((Math.random() * 1000) - 500);
        }
        System.out.print(Arrays.toString(v) + '\n');
        for (int i = 0; i < v.length; i++) {
            if (v[i] > max) max = v[i];
            if (v[i] < min) min = v[i];
        }
        System.out.print("max = " + max + " min = " + min + '\n');
        System.out.println();

        int[] balance = new int[5];
        for (int i = 0; i < balance.length; i++) {
            balance[i] = (int) (Math.random() * 4);
        }
        System.out.print(Arrays.toString(balance) + '\n');
        System.out.println(checkBalance(balance));
        System.out.println();

        int[] last = new int[6];
        for (int i = 0; i < last.length; i++) {
            last[i] = i;
        }
        System.out.println(Arrays.toString(last));
        shiftArray(last, -2);
        System.out.println(Arrays.toString(last));
    }

    // шестое задание
    public static boolean checkBalance(int[] b) {
        int x = 0, y = 0;
        boolean check = false;
        for (int i = 0; i < b.length; i++) {
            x += b[i];
        }
        for (int j = b.length - 1; j > 0; j--) {
            y += b[j];
            x -= b[j];
            if (x == y) {
                check = true;
                break;
            } else check = false;
        }
        return check;
    }

    // седьмое задание
    public static int[] shiftArray(int[] c, int shift) {
        if (shift > 0) {
            if (shift > c.length) {
                shift = shift % c.length;
            }
        }
        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                int temp = c[0];
                c[0] = c[c.length - 1];
                for (int j = 1; j < c.length - 1; j++) {
                    c[c.length - j] = c[c.length - j - 1];
                }
                c[1] = temp;
            }
        } else if (shift < 0) {
            for (int i = 0; i > shift; i--) {
                int temp = c[c.length - 1];
                c[c.length - 1] = c[0];
                for (int j = 1; j < c.length - 1; j++) {
                    c[j - 1] = c[j];
                }
                c[c.length - 2] = temp;
            }
        }
        return c;
    }
}

