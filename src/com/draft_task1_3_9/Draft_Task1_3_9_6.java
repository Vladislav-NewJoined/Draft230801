package com.draft_task1_3_9;

import java.util.Arrays;

//        Пример _ ППППППППППППППППППППППППППППППППППП
//  пример взят отсюда: javarush : https://javarush.com/groups/posts/mnogomernye-massivy#%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5,-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-%D0%B4%D0%B2%D1%83%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D1%85-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%B2
//  и отсюда: видео https://yandex.ru/video/preview/13700980576848701175
//  закончил видео мин 19 55

public class Draft_Task1_3_9_6 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                6. Создайте матрицу(двумерный массив) int[][], заполните ее таблицей умножения
                   1-9. Выведите ее.

                Решение:\s""");

        int size = 10;

        for (int i = 1; i <= 9; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();   //  перенос строки

        for (int row = 2; row < size; row++) {
            for (int col = 1; col < size; col++) {
                int mult = row * col;
                if (mult >= 10) {
                    System.out.print(row * col + " ");
                } else {
                    System.out.print(row * col + "  ");
                }
            }
            System.out.println();
        }

    }
}
//        Конец Примера _ КККККККККККККККК






