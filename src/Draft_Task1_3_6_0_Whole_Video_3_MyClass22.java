//public class Draft_Task1_3_6_0_Whole_Video_4_MyClass22 {   //  itunes ДжейСон JSON_2
//    public static void main(String[] args) throws IOException {
//        String term = getUserInput();
//        String url = buildUrl(term);
//        String page = downLoadWebPage(url);
//        printResult(page);
//    }
//
//    static void printResult(String page) {
//        int start = page.indexOf("wrapperType") + 14;
//        int end = page.indexOf("\",", start);
//        System.out.println(page.substring(start, end));
//    }
//
//    static String buildUrl(String partOfRequest) {
//        String termWithoutSpaces = partOfRequest.replaceAll(" ", "")  //  16 51
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
//    }
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
//            String wrapperType = getWrapperTgpeipage);
//            StringBuitder result = new StringBuilder();
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




//        Пример _ ППППППППППППППППППППППППППППППППППП
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Draft_Task1_3_6_0_Whole_Video {
//    public static void main(String[] args) {
//  Урок 6. Операторы Continue, break
//  видео мин 03 01 - найти певый элемент массива, кот. больше 10-ти
//  видео мин 04 30 - вывести только первое слово
//  видео мин 06 55 - в случае с вложенными циклами
//  видео мин 07 16 - оператор continue
//  видео мин 09 40 - вывести только нечетные числа
//  видео мин 11 04 - вывести все заглавные символы со StringBuilder

// вывести, если больше 10
//        int[] arr = new int[5];
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter array of 5 elements: ");
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//
//        System.out.println("result:");
//        for (int i=0; i<arr.length; i++) {
//            if (arr[i] > 10) {
//                System.out.println(arr[i]);
//                break;
//            }
//        }

// вывести первое слово
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter line: ");
//
//        String line = scanner.nextLine();
//        System.out.println("result:");
//        for (int i = 0; i < line.length(); i++) {
//            if (line.charAt(i) == ' ') {
//                break;
//            }
//            System.out.print(line.charAt(i));
//        }

//        int x = 0;
//        while (x < 100) {
//            if (x == 50) {
//                break;
//            }
//            x++;
//            System.out.println(x);
//        }
//        System.out.println(); //  перенос строки
//        System.out.println("end of program");


//        //  Вывести нечетные
//        int x = 0; while (x<100) {
//            x++;
//            if (x % 2 == 0) {
//                continue;
//            }
//            System.out.println(x);
//        }


//        //  видео мин 11 04 - вывести все заглавные символы со StringBuilder
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        StringBuilder builder = new StringBuilder(line);
//        int count = 0;
//        for (int i=0; i<builder.length(); i++) {
//            char ch = builder.charAt(i);
//            if (Character.isLowerCase(ch)) {
//                continue;
//            }
//            char small = Character.toLowerCase(ch);
//            builder.deleteCharAt(i);
//            builder.insert(i, small);
//            count++;
//        }
//        System.out.println("There is " + count + " not-lowercase symbols");
//        System.out.println(builder.toString());
//        Конец Примера _ КККККККККККККККК

