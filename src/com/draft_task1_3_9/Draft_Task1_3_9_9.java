package com.draft_task1_3_9;//        Пример _ ППППППППППППППППППППППППППППППППППП
//  пример взят отсюда: javarush : https://javarush.com/groups/posts/mnogomernye-massivy#%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5,-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-%D0%B4%D0%B2%D1%83%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D1%85-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%B2
//  и отсюда: видео https://yandex.ru/video/preview/13700980576848701175
//  Unicode здесь: https://www.ssec.wisc.edu/~tomw/java/unicode.html

public class Draft_Task1_3_9_9 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                9. Предыдущее задание, но с русским алфавитом.

                Решение:\s""");

//  Номера символов кириллицы в Unicode (или ASCII): 1072 - 1103 включительно, заглавных: 1040 - 1071 включительно
        int lines = 7;
        int columns =5;

        char[][] LatinAlp = new char[lines][columns];

        char ch = 'а';
        for (int n = 1072; n < 1107; n++) {
            for (int i = 0; i < lines; i++) {  //идём по строкам
                for (int j = 0; j < columns; j++) {  //идём по столбцам
                    LatinAlp[i][j] = ch;
                    System.out.print(" " + LatinAlp[i][j] + " "); //вывод элемента
                    ch++;

                if (ch == 1104) {
                    System.exit(0);
            }
                    n++;
                }
                System.out.println();  //  перенос строки ради визуального сохранения табличной формы
           }
        }






//        for (char ch2 = 'А'; ch2 <= 'я'; ch2++) {
//            System.out.println(ch2 + " (" + ((int) ch2) + ")");
//        }
//        System.out.println(ch + " (" + ((int) "Ё") + ")");
//        System.out.println(ch + " (" + ((int) "ё") + ")");

    }
}
//        Конец Примера _ КККККККККККККККК






