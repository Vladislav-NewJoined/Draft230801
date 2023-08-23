package com.draft_task1_3_9;//        Пример _ ППППППППППППППППППППППППППППППППППП
//  пример взят отсюда: javarush : https://javarush.com/groups/posts/mnogomernye-massivy#%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5,-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-%D0%B4%D0%B2%D1%83%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D1%85-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%B2
//  и отсюда: видео https://yandex.ru/video/preview/13700980576848701175

public class Draft_Task1_3_9_8 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                8. Создайте матрицу char[][], проинициализируйте ее латинским алфавитом,
                   выведите его. Подсказка - можно получить первую букву как char ch = ‘a’,
                   следующую - как ch + 1, и так далее.

                Решение:\s""");

//  Номера символов латиницы 97 - 122 включительно
        int lines = 5;
        int columns =5;

        char[][] LatinAlp = new char[lines][columns];
//        String[][] LatinAlp = new String[lines][columns];
//        LatinAlp[0][0] = 5;  //записали значение 5 в ячейку на пересечении нулевой строки и нулевого столбца
//        LatinAlp[0][1] = 7;  //записали значение 7 в ячейку на пересечении нулевой строки и первого столбца
//        LatinAlp[0][2] = 3;
//        LatinAlp[0][3] = 17;
//        LatinAlp[1][0] = 7;
//        LatinAlp[1][1] = 0;
//        LatinAlp[1][2] = 1;
//        LatinAlp[1][3] = 12;
//        LatinAlp[2][0] = 8;
//        LatinAlp[2][1] = 1;
//        LatinAlp[2][2] = 2;

        char ch = 'a';
        for (int n = 97; n < 123; n++) {
            for (int i = 0; i < lines; i++) {  //идём по строкам
                for (int j = 0; j < columns; j++) {  //идём по столбцам
                    LatinAlp[i][j] = ch;
                    System.out.print(" " + LatinAlp[i][j] + " "); //вывод элемента
                    ch++;
                    n++;
                }
                System.out.println();  //  перенос строки ради визуального сохранения табличной формы
            }
        }
    }
}
//        Конец Примера _ КККККККККККККККК








////        Пример 2 ППППППППППППППППППППППППППППППППППП
////  пример взят отсюда: javarush : https://javarush.com/groups/posts/mnogomernye-massivy#%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5,-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-%D0%B4%D0%B2%D1%83%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D1%85-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%B2
////  и отсюда: видео https://yandex.ru/video/preview/13700980576848701175
//
//public class com.draft_task1_3_9.Draft_Task1_3_9_8 {
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                8. Создайте матрицу char[][], проинициализируйте ее латинским алфавитом,
//                   выведите его. Подсказка - можно получить первую букву как char ch = ‘a’,
//                   следующую - как ch + 1, и так далее.
//
//                Решение:\s""");
//
////  Номера символов латиницы 97 - 122 включительно
//        int lines = 5;
//        int columns =5;
//
////            char[][] LatinAlp = new char[lines][columns];
//        String[][] LatinAlp = new String[lines][columns];
////        LatinAlp[0][0] = 5;  //записали значение 5 в ячейку на пересечении нулевой строки и нулевого столбца
////        LatinAlp[0][1] = 7;  //записали значение 7 в ячейку на пересечении нулевой строки и первого столбца
////        LatinAlp[0][2] = 3;
////        LatinAlp[0][3] = 17;
////        LatinAlp[1][0] = 7;
////        LatinAlp[1][1] = 0;
////        LatinAlp[1][2] = 1;
////        LatinAlp[1][3] = 12;
////        LatinAlp[2][0] = 8;
////        LatinAlp[2][1] = 1;
////        LatinAlp[2][2] = 2;
//
//        for (int n = 97; n < 123; n++) {
//            for (int i = 0; i < lines; i++) {  //идём по строкам
//                for (int j = 0; j < columns; j++) {  //идём по столбцам
//                    LatinAlp[i][j] = Character.toString(n);
//                    System.out.print(" " + LatinAlp[i][j] + " "); //вывод элемента
//                    n++;
//                }
//                System.out.println();  //  перенос строки ради визуального сохранения табличной формы
//            }
//        }
//    }
//}
////        Конец Примера 2 КККККККККККККККК








////        Пример 1 ППППППППППППППППППППППППППППППППППП
////  пример взят отсюда: javarush : https://javarush.com/groups/posts/mnogomernye-massivy#%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5,-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-%D0%B4%D0%B2%D1%83%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D1%85-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%B2
////  и отсюда: видео https://yandex.ru/video/preview/13700980576848701175
//
//import java.util.Arrays;
//
//public class com.draft_task1_3_9.Draft_Task1_3_9_1_Mnogomernye_massivy {
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                8. Создайте матрицу char[][], проинициализируйте ее латинским алфавитом,
//                   выведите его. Подсказка - можно получить первую букву как char ch = ‘a’,
//                   следующую - как ch + 1, и так далее.
//
//                Решение:\s""");
//
////  Номера символов латиницы 97 - 122 включительно
//        int lines = 5;
//        int columns =5;
//
//        //    char[][] LatinAlp = new char[3][4];
//        String[][] LatinAlp = new String[lines][columns];
////        LatinAlp[0][0] = 5;  //записали значение 5 в ячейку на пересечении нулевой строки и нулевого столбца
////        LatinAlp[0][1] = 7;  //записали значение 7 в ячейку на пересечении нулевой строки и первого столбца
////        LatinAlp[0][2] = 3;
////        LatinAlp[0][3] = 17;
////        LatinAlp[1][0] = 7;
////        LatinAlp[1][1] = 0;
////        LatinAlp[1][2] = 1;
////        LatinAlp[1][3] = 12;
////        LatinAlp[2][0] = 8;
////        LatinAlp[2][1] = 1;
////        LatinAlp[2][2] = 2;
//
//
//
//        for (int n = 97; n < 123; n++) {
//            for (int i = 0; i < lines; i++) {  //идём по строкам
//                for (int j = 0; j < columns; j++) {  //идём по столбцам
////                latinskyiAlf[i][j] = Arrays.toString(Character.toChars(n));
//                    LatinAlp[i][j] = Arrays.toString(Character.toChars(n));
//                    System.out.print(" " + LatinAlp[i][j] + " "); //вывод элемента
//                    n++;
//                }
//                System.out.println();  //  перенос строки ради визуального сохранения табличной формы
//            }
//        }
//
//
////        System.out.println(Character.toString(97));
//    }
//}
////        Конец Примера 1 КККККККККККККККК








