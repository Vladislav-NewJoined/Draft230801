package com.draft_task1_3_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

//        Пример _ ППППППППППППППППППППППППППППППППППП
import java.io.IOException;
import java.util.Scanner;

public class Draft_Task1_3_6_0_Whole_Video {
    public static void main(String[] args) {
//  Урок 6. Операторы Continue, break
//  видео мин 03 01 - найти певый элемент массива, кот. больше 10-ти
//  видео мин 04 30 - вывести только первое слово
//  видео мин 06 55 - в случае с вложенными циклами
//  видео мин 07 16 - оператор continue
//  видео мин 09 40 - вывести только нечетные числа
//  видео мин 11 04 - вывести все заглавные символы со StringBuilder

// вывести, если больше 10
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array of 5 elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();

            System.out.println("result:");
            for (int i4 = 0; i4 < arr.length; i4++) {
                if (arr[i4] > 10) {
                    System.out.println(arr[i4]);
                    break;
                }
            }
        }

// вывести первое слово
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter line: ");

            String line = scanner2.nextLine();
            System.out.println("result:");
            for (int i2 = 0; i2 < line.length(); i2++) {
                if (line.charAt(i2) == ' ') {
                    break;
                }
                System.out.print(line.charAt(i2));
            }

            int x = 0;
            while (x < 100) {
                if (x == 50) {
                    break;
                }
                x++;
                System.out.println(x);
            }
            System.out.println(); //  перенос строки
            System.out.println("end of program");


            //  Вывести нечетные
            int x2 = 0;
            while (x2 < 100) {
                x2++;
                if (x2 % 2 == 0) {
                    continue;
                }
                System.out.println(x2);
            }


            //  видео мин 11 04 - вывести все заглавные символы со StringBuilder
            Scanner scanner3 = new Scanner(System.in);
            String line2 = scanner3.nextLine();
            StringBuilder builder = new StringBuilder(line2);
            int count = 0;
            for (int i3 = 0; i3 < builder.length(); i3++) {
                char ch = builder.charAt(i3);
                if (Character.isLowerCase(ch)) {
                    continue;
                }
                char small = Character.toLowerCase(ch);
                builder.deleteCharAt(i3);
                builder.insert(i3, small);
                count++;
            }
            System.out.println("There is " + count + " not-lowercase symbols");
            System.out.println(builder.toString());

        }
    }

//        Конец Примера _ КККККККККККККККК









////        Пример 3 ППППППППППППППППППППППППППППППППППП  из урока Draft_Task1_3_6_0_Whole_Video_2_MyClass19
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.Scanner;
//
//public class Draft_Task1_3_6_0_Whole_Video_2_MyClass19 {   //  itunes ДжейСон JSON_2
//    public static void main(String[] args) throws IOException {
//
//        // userInput
//        String term = getUserInput();
//
//        // buildUrl
//        String url = buildUrl(term);
//
//        // downloadWebPage
//        String page = downloadWebPage(url);
//
//        // parseResult
//        printResult(page);
//        System.out.println(page); // целиком всю страницу не будем выводить
//
//    }
//    // Закончил: видео мин 42 46  (1-3_2) https://lms.synergy.ru/student/updiscipline/4474947/1045153/1/1
//
//    static void/*String*/ /*parseResult*/printResult(String page) {
//        // parseResult
////            int start = page.indexOf("kind") + 7;  // было /*kind*/
//        int start = page.indexOf("wrapperType") + 14;  // было /*kind*/
//        int end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
////        String sub =  page.substring(start + 7, end);  // это я дописал
//        System.out.println(page.substring(start, end));
//    }
//
//    static String/*void*/ buildUrl (String partOfRequest) {
//        // buildUrl
//        String termWithoutSpaces = /*term*/partOfRequest.replaceAll(" ", "+");
//        String itunesApi = "https://itunes.apple.com/search?term="; //  32 41
//        String limitParametr = "&limit=1";
//        String url = itunesApi + termWithoutSpaces + limitParametr; //  32 41
//        return url;
//    }
//
//    static String/*void*/ getUserInput() {
//        // userInput
//        System.out.println("What you looking for in itunes?");
//        Scanner scanner = new Scanner(System.in);
//        String info /*term*/ = scanner.nextLine(); //  war of worlds
//        return info;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    // ПОДПРОГРАММА, КОТОРАЯ ИЩЕТ ПО ОПРЕДЕЛЕННОМУ URL ИНФОРМАЦИЮ
//    static String downloadWebPage(String url) throws IOException {
//        StringBuilder result = new StringBuilder();
//        String line;
//        URLConnection urlConnection = new URL(url).openConnection();
//        try (InputStream is = urlConnection.getInputStream();
//             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
//            while ((line = br.readLine()) != null) {
//                result.append(line);
//            }
//        }
//        return result.toString(); // goto 13 line
//    }
//}
////        Конец Примера 3 КККККККККККККККК

////        Пример 2 ППППППППППППППППППППППППППППППППППП //  itunes ДжейСон JSON
//public class Draft_Task1_3_6_0_Whole_Video_4_MyClass22 {  //  itunes ДжейСон JSON
//    public static void main(String[] args) throws IOException {
//        String term = getUserInput();
//        String url = buildUrl(term);
//        String page = downLoadWebPage(url);
//        printResult(page);
//    }
//    static void printResult(String page) {
//        int start = page.indexOf("wrapperType") + 14;
//        int end = page.indexOf("\",", start);
//
//        StringBuilder result = new StringBuilder();
//        String wrapperType = page.substring(start, end);
//
//        if (wrapperType.equals("audiobook")) {
//            result = buildBookResult(page);
//        } else if (wrapperType.equals("track")) {
//            String kind = getKind(page) ;
//            if (kind.equals("song")) {
//                result = buildSongInformotion(page);
//            } else if (kind.equals("feature-movie")) {
//                result = buildMovielnformation(page);
//            }
//
//
//        String wrapperType = getWrapperTgpeipage);
//        StringBuitder result = new StringBuilder();
//        }
//        if (result.length() == 0) {
//            result.append("Unknown result: "); result.append(page);
//        }
//        System.out.println(result.toStrin());
//
//    }
//}
////        Конец Примера 2 КККККККККККККККК




//
////        Пример 1 ППППППППППППППППППППППППППППППППППП //  itunes ДжейСон JSON
//public class Draft_Task1_3_6_0_Whole_Video_4_MyClass22 {  //  itunes ДжейСон JSON
//    public static void main(String[] args) throws IOException {
//        String term = getUserInput();
//        String url = buildUrl(term);
//        String page = downLoadWebPage(url);
//        printResult(page);
//    }
//    static void printResult(String page) {
//        int start = page.indexOf("wrapperType") + 14;
//        int end = page.indexOf("\",", start);
//
//        StringBuilder result = new StringBuilder();
//        String wrapperType = page.substring(start, end);
//
//        if (wrapperType.equals("audiobook")) {
//            result = buildBookResult(page);
//        } else if (wrapperType.equals("track")) {
//            String kind = getKind(page) ;
//            if (kind.equals("song")) {
//                result = buildSongInformotion(page);
//            } else if (kind.equals("feature-movie")) {
//                result = buildMovielnformation(page);
//            }
//
//
//        String wrapperType = getWrapperTgpeipage);
//        StringBuitder result = new StringBuilder();
//        }
//        if (result.length() == 0) {
//            result.append("Unknown result: "); result.append(page);
//        }
//        System.out.println(result.toStrin());
//
//    }
//}
////        Конец Примера 1 КККККККККККККККК




