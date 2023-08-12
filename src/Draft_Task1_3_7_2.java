import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

//        Пример _ ППППППППППППППППППППППППППППППППППП  СДЕЛАН ОКОНЧАТЕЛЬНО, ОТПРАВЛЕН В ЭТОМ ВИДЕ !!!!!
//  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
public class Draft_Task1_3_7_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                Задание:\s
                2. Реализуйте метод, который из двух массивов строк собирает третий, в
                   котором чередуются элементы первых двух

                Решение:\s""");

        System.out.println("Шаг 1.   Создаем два исходных строковых массива (состоящих из слов исходных строк):");
        getCombinedArray();
    }

    private static void getCombinedArray(/*String str1, String str2*/){  //  ЭТО ИСПОЛЬЗУЕМ
        String str1 = "В теории, теория и практика неразделимы.";
        String str2 = "Насколько проще было бы писать программы, если бы не заказчики.";
        System.out.println("Шаг 2.1. Исходная строка 1: " + str1);
        System.out.println("Шаг 2.2. Исходная строка 2: " + str2);

        List<String> str1Array = new ArrayList<>();
        BreakIterator breakIterator1 = BreakIterator.getWordInstance();
        breakIterator1.setText(str1);
        int lastIndex1 = breakIterator1.first();
        while (BreakIterator.DONE != lastIndex1) {
            int firstIndex = lastIndex1;
            lastIndex1 = breakIterator1.next();
            if (lastIndex1 != BreakIterator.DONE && Character.isLetterOrDigit(str1.charAt(firstIndex))) {
                str1Array.add(str1.substring(firstIndex, lastIndex1));
            }
        }
        System.out.println("Шаг 3.1. Исходный массив 1: " + str1Array);

        List<String> str2Array = new ArrayList<>();
        BreakIterator breakIterator2 = BreakIterator.getWordInstance();
        breakIterator2.setText(str2);
        int lastIndex2 = breakIterator2.first();
        while (BreakIterator.DONE != lastIndex2) {
            int firstIndex = lastIndex2;
            lastIndex2 = breakIterator2.next();
            if (lastIndex2 != BreakIterator.DONE && Character.isLetterOrDigit(str2.charAt(firstIndex))) {
                str2Array.add(str2.substring(firstIndex, lastIndex2));
            }
        }
        System.out.println("Шаг 3.2. Исходный массив 2: " + str2Array);

        List<String> combinedArray = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i < str1Array.size() && i < str2Array.size()) {
                if (i % 2 == 0) {
                    combinedArray.add(str1Array.get(i));
                } else {
                    combinedArray.add(str2Array.get(i));
                }
            }
        }
        System.out.println("Шаг 4.   Результат: " + combinedArray);
    }
}
//        Конец Примера _ КККККККККККККККК







////        Пример 5 ППППППППППППППППППППППППППППППППППП  Работает уже правильно, с объединенными методами, убрать лишние строки
////  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
//public class Draft_Task1_3_7_2 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//                Задание:\s
//                2. Реализуйте метод, который из двух массивов строк собирает третий, в
//                   котором чередуются элементы первых двух
//
//                Решение:\s""");
//
//        System.out.println("Шаг 1.   Создаем два исходных строковых массива (состоящих из слов исходных строк):");
////        String str1 = "В теории, теория и практика неразделимы.";
//////        String str2_old = "Всегда пишите код так, будто сопровождать его будет " +
//////                "склонный к насилию психопат, который знает, где вы живете.";
////        String str2 = "Насколько проще было бы писать программы, если бы не заказчики.";
////        System.out.println("Шаг 2.1. Исходная строка 1: " + str1);
////        System.out.println("Шаг 2.2. Исходная строка 2: " + str2);
//
////        List<String> str1Array = getStr1Array(str1);
//
////        List<String> str2Array = getStr2Array(str2);
//
////        getCombinedArray(str1Array, str2Array);
//
//
//        System.out.println("\n");
//        getCombinedArray(/*str1Array, str2Array*/);
////        display2("Bob", 28);
////        display2("Sam", 23);
//
////        System.out.println("");
////        display("Tom", 34);
////        display("Bob", 28);
////        display("Sam", 23);
//
//
//    }
//
////    private static List<String> getStr1Array(String str1) {
////        List<String> str1Array = new ArrayList<>();
////        BreakIterator breakIterator1 = BreakIterator.getWordInstance();
////        breakIterator1.setText(str1);
////        int lastIndex1 = breakIterator1.first();
////        while (BreakIterator.DONE != lastIndex1) {
////            int firstIndex = lastIndex1;
////            lastIndex1 = breakIterator1.next();
////            if (lastIndex1 != BreakIterator.DONE && Character.isLetterOrDigit(str1.charAt(firstIndex))) {
////                str1Array.add(str1.substring(firstIndex, lastIndex1));
////            }
////        }
////        System.out.println("Шаг 3.1. Исходный массив 1: " + str1Array);
////        return str1Array;
////    }
//
////    private static List<String> getStr2Array(String str2) {
////        List<String> str2Array = new ArrayList<>();
////        BreakIterator breakIterator2 = BreakIterator.getWordInstance();
////        breakIterator2.setText(str2);
////        int lastIndex2 = breakIterator2.first();
////        while (BreakIterator.DONE != lastIndex2) {
////            int firstIndex = lastIndex2;
////            lastIndex2 = breakIterator2.next();
////            if (lastIndex2 != BreakIterator.DONE && Character.isLetterOrDigit(str2.charAt(firstIndex))) {
////                str2Array.add(str2.substring(firstIndex, lastIndex2));
////            }
////        }
////        System.out.println("Шаг 3.2. Исходный массив 2: " + str2Array);
////        return str2Array;
////    }
//
////    private static void getCombinedArray(List<String> str1Array, List<String> str2Array) {
////        List<String> combinedArray = new ArrayList<>();
////        for (int i = 0; i < 20; i++) {
////            if (i < str1Array.size() && i < str2Array.size()) {
////                if (i % 2 == 0) {
////                    combinedArray.add(str1Array.get(i));
////                } else {
////                    combinedArray.add(str2Array.get(i));
////                }
////            }
////        }
////        System.out.println("Шаг 4.   Результат: " + combinedArray);
////    }
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
//    private static void getCombinedArray(/*String str1, String str2*/){  //  ЭТО ИСПОЛЬЗУЕМ
//        String str1 = "В теории, теория и практика неразделимы.";
//        String str2 = "Насколько проще было бы писать программы, если бы не заказчики.";
//        System.out.println("Шаг 2.1. Исходная строка 1: " + str1);
//        System.out.println("Шаг 2.2. Исходная строка 2: " + str2);
//
//        List<String> str1Array = new ArrayList<>();
//        BreakIterator breakIterator1 = BreakIterator.getWordInstance();
//        breakIterator1.setText(str1);
//        int lastIndex1 = breakIterator1.first();
//        while (BreakIterator.DONE != lastIndex1) {
//            int firstIndex = lastIndex1;
//            lastIndex1 = breakIterator1.next();
//            if (lastIndex1 != BreakIterator.DONE && Character.isLetterOrDigit(str1.charAt(firstIndex))) {
//                str1Array.add(str1.substring(firstIndex, lastIndex1));
//            }
//        }
//        System.out.println("Шаг 3.1. Исходный массив 1: " + str1Array);
//
//        List<String> str2Array = new ArrayList<>();
//        BreakIterator breakIterator2 = BreakIterator.getWordInstance();
//        breakIterator2.setText(str2);
//        int lastIndex2 = breakIterator2.first();
//        while (BreakIterator.DONE != lastIndex2) {
//            int firstIndex = lastIndex2;
//            lastIndex2 = breakIterator2.next();
//            if (lastIndex2 != BreakIterator.DONE && Character.isLetterOrDigit(str2.charAt(firstIndex))) {
//                str2Array.add(str2.substring(firstIndex, lastIndex2));
//            }
//        }
//        System.out.println("Шаг 3.2. Исходный массив 2: " + str2Array);
//
//        List<String> combinedArray = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            if (i < str1Array.size() && i < str2Array.size()) {
//                if (i % 2 == 0) {
//                    combinedArray.add(str1Array.get(i));
//                } else {
//                    combinedArray.add(str2Array.get(i));
//                }
//            }
//        }
//        System.out.println("Шаг 4.   Результат: " + combinedArray);
//
////        System.out.println(name + " " + age);
////        System.out.println(age);
//    }
//
//
//
////    static void display(String name, int age){  //  ЭТО ПРИМЕР
////
////        System.out.println(name + " " + age);
////    }
//}
////        Конец Примера 5 КККККККККККККККК







////        Пример 4 ППППППППППППППППППППППППППППППППППП  из интернет
////  отсюда https://metanit.com/java/tutorial/2.16.php?ysclid=ll8j2nh1vz285380969
//public class Draft_Task1_3_7_2 {
//    public static void main(String[] args) throws IOException {
//
//        display("Tom", 34);
//        display("Bob", 28);
//        display("Sam", 23);
//    }
//    static void display(String name, int age){
//
//        System.out.println(name);
//        System.out.println(age);
//    }
//}
////        Конец Примера 4 КККККККККККККККК







////        Пример 4 ППППППППППППППППППППППППППППППППППП  из интернет
////  отсюда https://www.daniweb.com/programming/software-development/threads/133321/how-methods-with-multiple-parameters-are-declared#post643232
////  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
//public class Draft_Task1_3_7_2 {
//    public static void main(String[] args) throws IOException {
//        String values1[] = {"Mom", "Dad", "Sis"};
//
//        Draft_Task1_3_7_2 VarArgTest = null;
//        VarArgTest.myVarArgMethod(values1);
//        VarArgTest.myVarArgMethod(" ", " ");
//        VarArgTest.myVarArgMethod("Yo", "This", "Rocks", "My", "Socks");
//
//    }
//
//    public static void myVarArgMethod(String... strings){
//
//        for(String element : strings)
//            System.out.println(element);
//    }
//}
////        Конец Примера 4 КККККККККККККККК







////        Пример 3 ППППППППППППППППППППППППППППППППППП  Работает, теперь надо два метода объединить
////  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
//public class Draft_Task1_3_7_2 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//                Задание:\s
//                2. Реализуйте метод, который из двух массивов строк собирает третий, в
//                   котором чередуются элементы первых двух
//
//                Решение:\s""");
//
//        System.out.println("Шаг 1.   Создаем два исходных строковых массива (состоящих из слов исходных строк):");
//        String str1 = "В теории, теория и практика неразделимы.";
////        String str2_old = "Всегда пишите код так, будто сопровождать его будет " +
////                "склонный к насилию психопат, который знает, где вы живете.";
//        String str2 = "Насколько проще было бы писать программы, если бы не заказчики.";
//        System.out.println("Шаг 2.1. Исходная строка 1: " + str1);
//        System.out.println("Шаг 2.2. Исходная строка 2: " + str2);
//
//        List<String> str1Array = getStr1Array(str1);
//
//        List<String> str2Array = getStr2Array(str2);
//
//        getCombinedArray(str1Array, str2Array);
//    }
//
//    private static List<String> getStr1Array(String str1) {
//        List<String> str1Array = new ArrayList<>();
//        BreakIterator breakIterator1 = BreakIterator.getWordInstance();
//        breakIterator1.setText(str1);
//        int lastIndex1 = breakIterator1.first();
//        while (BreakIterator.DONE != lastIndex1) {
//            int firstIndex = lastIndex1;
//            lastIndex1 = breakIterator1.next();
//            if (lastIndex1 != BreakIterator.DONE && Character.isLetterOrDigit(str1.charAt(firstIndex))) {
//                str1Array.add(str1.substring(firstIndex, lastIndex1));
//            }
//        }
//        System.out.println("Шаг 3.1. Исходный массив 1: " + str1Array);
////        return str1Array;
//        return str1Array;
//    }
//
//    private static List<String> getStr2Array(String str2) {
//        List<String> str2Array = new ArrayList<>();
//        BreakIterator breakIterator2 = BreakIterator.getWordInstance();
//        breakIterator2.setText(str2);
//        int lastIndex2 = breakIterator2.first();
//        while (BreakIterator.DONE != lastIndex2) {
//            int firstIndex = lastIndex2;
//            lastIndex2 = breakIterator2.next();
//            if (lastIndex2 != BreakIterator.DONE && Character.isLetterOrDigit(str2.charAt(firstIndex))) {
//                str2Array.add(str2.substring(firstIndex, lastIndex2));
//            }
//        }
//        System.out.println("Шаг 3.2. Исходный массив 2: " + str2Array);
////        return str2Array;
//        return str2Array;
//    }
//
//    private static void getCombinedArray(List<String> str1Array, List<String> str2Array) {
//        List<String> combinedArray = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            if (i < str1Array.size() && i < str2Array.size()) {
//                if (i % 2 == 0) {
//                    combinedArray.add(str1Array.get(i));
//                } else {
//                    combinedArray.add(str2Array.get(i));
//                }
//            }
//        }
//        System.out.println("Шаг 4.   Результат: " + combinedArray);
//    }
//}
////        Конец Примера 3 КККККККККККККККК







////        Пример 2 ППППППППППППППППППППППППППППППППППП Работает, теперь в метод это выделить
////  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
//public class Draft_Task1_3_7_2 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//                Задание:\s
//                2. Реализуйте метод, который из двух массивов строк собирает третий, в
//                   котором чередуются элементы первых двух
//
//                Решение:\s""");
//
//        System.out.println("Шаг 1. Создаем два исходных строковых массива (состоящих из слов исходных строк):");
//        String str1 = "В теории, теория и практика неразделимы.";
////        String str2_old = "Всегда пишите код так, будто сопровождать его будет " +
////                "склонный к насилию психопат, который знает, где вы живете.";
//        String str2 = "Насколько проще было бы писать программы, если бы не заказчики.";
//        System.out.println("Шаг 2.1. Исходная строка 1: " + str1);
//        System.out.println("Шаг 2.2. Исходная строка 2: " + str2);
//
//        List<String> str1Array = new ArrayList<>();
//        BreakIterator breakIterator1 = BreakIterator.getWordInstance();
//        breakIterator1.setText(str1);
//        int lastIndex1 = breakIterator1.first();
//        while (BreakIterator.DONE != lastIndex1) {
//            int firstIndex = lastIndex1;
//            lastIndex1 = breakIterator1.next();
//            if (lastIndex1 != BreakIterator.DONE && Character.isLetterOrDigit(str1.charAt(firstIndex))) {
//                str1Array.add(str1.substring(firstIndex, lastIndex1));
//            }
//        }
//        System.out.println("Шаг 3.1. Исходный массив 1: " + str1Array);
////        return str1Array;
//
//        List<String> str2Array = new ArrayList<>();
//        BreakIterator breakIterator2 = BreakIterator.getWordInstance();
//        breakIterator2.setText(str2);
//        int lastIndex2 = breakIterator2.first();
//        while (BreakIterator.DONE != lastIndex2) {
//            int firstIndex = lastIndex2;
//            lastIndex2 = breakIterator2.next();
//            if (lastIndex2 != BreakIterator.DONE && Character.isLetterOrDigit(str2.charAt(firstIndex))) {
//                str2Array.add(str2.substring(firstIndex, lastIndex2));
//            }
//        }
//        System.out.println("Шаг 3.2. Исходный массив 2: " + str2Array);
////        return str2Array;
//
//        List<String> combinedArray = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            if (i < str1Array.size() && i < str2Array.size()) {
//                if (i % 2 == 0) {
//                    combinedArray.add(str1Array.get(i));
//                } else {
//                    combinedArray.add(str2Array.get(i));
//                }
//            }
//        }
//        System.out.println("Шаг 4. Результат: " + combinedArray);
//    }
//}
////        Конец Примера 2 КККККККККККККККК







////        Пример 1 ППППППППППППППППППППППППППППППППППП
// //  Решение простое  _ЗАПОЛНИТЬ ЭЛЕМЕНТАМИ ДРУГОГО МАССИВА , СТАТИЧЕСКОГО
////  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
//public class Draft_Task1_3_7_2 {
//    public static void main(String[] args) throws IOException {
//        final int[] numbers = new int[] {2,4,6,8,10,12,14,16,18,20};
//        final List<Integer> list = new ArrayList<Integer>();
//        for (int number : numbers) {
//            list.add(number);
//        }
//        System.out.println(list);
//
//    }
//}
////        Конец Примера 1 КККККККККККККККК








