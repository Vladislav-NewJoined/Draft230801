package com.draft_task1_3_6;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


//        Пример _ ППППППППППППППППППППППППППППППППППП
 //  Заборчиком : Module1_Tema2_Urok7   видео мин 11 20
 // Найти последнее слово: Module1_Tema2_Urok7  26 11
public class Draft_Task1_3_6_4 {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("""
                Задание:\s
                4. Найдите последнее слово в массиве, которое написано ЗаБоРчИкОм (чтоб узнать, заглавная 
                ли буква, используйте Character.isUpperCase(letter))

                Решение:\s""");

        Scanner scanner = new Scanner (System.in);
        System.out.print("Введите строку из нескольких слов: ");
        String line = scanner.nextLine();

        char[] chars = line.toCharArray();
        int size = chars.length;

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
//        for (int i = 0; i < size; i++) {
//            System.out.print(chars[i]);
//        }
//        System.out.println();  //  перенос строки
        String convertedLine = new String(chars);
        System.out.println("Итоговая строка \"ЗаБоРчИкОм\": " + convertedLine);



        int lastSpase = convertedLine.length() - 1;
        while (convertedLine.charAt(lastSpase) != ' ' && lastSpase >= 0) {
            lastSpase--;
        }
        char[] word = new char[convertedLine.length() - lastSpase];

        for (int i = lastSpase; i < convertedLine.length(); i++) {
            word[i-lastSpase] = convertedLine.charAt(i);
        }
//
//        for (int i =0; i < word.length; i++) {
//            System.out.print(word[i]);
//        }
        String wordStrWithSpaces = new String(word);
        String wordStr = /*new String(*/wordStrWithSpaces.trim()/*)*/;
        System.out.println("Последнее слово в строке: " + wordStr);

        for (int i = 0; i < 1; i++) {
            if (Character.isUpperCase(wordStr.charAt(i))) {
                System.out.println("Первая буква в слове заглавная");
            } else {
                System.out.println("Первая буква в слове строчная");
            }
        }
    }
}
//        Конец Примера _ КККККККККККККККК
 //  закончил на видео мин 28 17








