import java.util.Arrays;
import java.util.Scanner;

//        Пример _ ППППППППППППППППППППППППППППППППППП
public class Draft_Task1_3_6_1_Oper_Continue_break {
    public static void main(String[] args) {
        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
        int breakMark = 0;

        String[] words = new String[10];
        for (int i = 0; i < words.length; i++) {
            words[i] = scanner.nextLine();
        }
        System.out.println("Исходный массив слов: " + Arrays.toString(words));
//        String inputWords = String.join(", ", words);
//        System.out.println("Исходный массив слов: " + inputWords);

        for (int i = 0; i < words.length; i++) {
            String word2 = words[i];
            for (int n = 1; n < word2.length(); n++) {

                if (("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word2.charAt(n)) > -1)
                        && ("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word2.charAt(n - 1)) > -1)) {
                    System.out.println("Найдено первое слово: \"" + word2 + "\", в котором две гласные подряд: \"" + word2.charAt(n - 1) + word2.charAt(n) + "\"");
                    breakMark = 1;
                    break;
                }
            }
            if (breakMark == 1) {
                break;
            }
        }
    }
}

//        Конец Примера _ КККККККККККККККК


////        Пример 6 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_1_Oper_Continue_break {
//    public static void main(String[] args) {
//        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
//                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
//        Scanner scanner = new Scanner (System.in);
//        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
//
//        String[] words = new String[4];
//        for (int i = 0; i < words.length; i++) {
//            words[i] = scanner.nextLine();
//        }
//        System.out.println("Исходный массив слов: " + Arrays.toString(words));
////        String inputWords = String.join(", ", words);
////        System.out.println("Исходный массив слов: " + inputWords);
//
//
//        for (int i = 0; i < words.length; i++) {
//            String word2 = words[i];
//            for (int n = 1; n < word2.length(); n++) {
//
//                if (("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word2.charAt(n)) > -1) && ("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word2.charAt(n - 1)) > -1)) {
//                    System.out.println("Найдено первое слово: " + word2 + ", в котором две гласные подряд: " + word2.charAt(n - 1) + word2.charAt(n));
////                    System.out.print("Слово, в котором Две гласные подряд: " + word2);
//                    break;
//                }
//            }
//        }
//    }
//}
////        Конец Примера 6 КККККККККККККККК


////        Пример 5 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_1_Oper_Continue_break {
//    public static void main(String[] args) {
//        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
//                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
//        Scanner scanner = new Scanner (System.in);
//        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
//
//        String[] words = new String[3];
//        for (int i = 0; i < words.length; i++) {
//            words[i] = scanner.nextLine();
//        }
//        System.out.println("Исходный массив слов, как массив: " + Arrays.toString(words));
//        String wordsWithoutSpaces = String.join(", ", words);
//        System.out.println("Исходный массив слов: " + wordsWithoutSpaces);
//
//
//
//
//
//
//
//
//
////        Scanner inp = new Scanner(System.in);
////        System.out.print("In: ");
////        String word = inp.nextLine();
//        String word1 = "длинношеее";
//
//        //write your code below
//
//        // This will hold any matching vowels we find
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < word1.length(); i++) {
//
//            // Check if our list of vowels contains the current char. If the current char exists in the String of vowels, it will have an index of 0 or greater.
//            if ("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word1.charAt(i)) > -1) {
//
//                // If so, add it to our StringBuilder
//                sb.append(word1.charAt(i));
//            }
//        }
//
//        // Finally, print the result
//        System.out.println("\n" + sb.toString());
//
//
//    }
//}
////        Конец Примера 5 КККККККККККККККК


////        Пример 4 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_1_Oper_Continue_break {
//    public static void main(String[] args) {
//        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
//                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
//        Scanner scanner = new Scanner (System.in);
//        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
//
//        String[] words = new String[3];
//        for (int i = 0; i < words.length; i++) {
//            words[i] = scanner.nextLine();
//        }
//        System.out.println(Arrays.toString(words));
//        String wordsWithoutSpaces = String.join(", ", words);
//        System.out.println("Исходный массив слов: " + wordsWithoutSpaces);
//
//
//
//
//
//
//
//
//
////        Scanner inp = new Scanner(System.in);
////        System.out.print("In: ");
////        String word = inp.nextLine();
//        String word1 = "длинношеее";
//
//        //write your code below
//
//        // This will hold any matching vowels we find
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < word1.length(); i++) {
//
//            // Check if our list of vowels contains the current char. If the current char exists in the String of vowels, it will have an index of 0 or greater.
//            if ("АЕЁИОУЫЭЮЯаеёиоуыэюяAEIOUaeiou".indexOf(word1.charAt(i)) > -1) {
//
//                // If so, add it to our StringBuilder
//                sb.append(word1.charAt(i));
//            }
//        }
//
//        // Finally, print the result
//        System.out.println(sb.toString());
//
//
//    }
//}
////        Конец Примера 4 КККККККККККККККК


////        Пример 3 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_1_Oper_Continue_break {
//    public static void main(String[] args) {
//        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
//                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
//        Scanner scanner = new Scanner (System.in);
//        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
//
//        String[] words = new String[3];
//        for (int i = 0; i < words.length; i++) {
//            words[i] = scanner.nextLine();
//        }
////        System.out.println(Arrays.toString(words));
//        String wordsWithoutSpaces = String.join(", ", words);
//        System.out.println("Исходный массив слов: " + wordsWithoutSpaces);
//
//
//
//
//    }
//}
////        Конец Примера 3 КККККККККККККККК


////        Пример 2 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_1_Oper_Continue_break {
//    public static void main(String[] args) {
//        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
//                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
//        Scanner scanner = new Scanner (System.in);
//        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
//
//        String[] words = new String[3];
//        for (int i = 0; i < words.length; i++) {
//            words[i] = scanner.nextLine();
//        }
//        System.out.println(Arrays.toString(words));
//        String str = String.join(", ", words);
//        System.out.println(str);
//
////  СНАЧАЛА ПРЕОБРАЗОВЫВАЕМ МАССИВ В СТРОКУ СО СЛОВАМИ ЧЕРЕЗ ЗАПЯТУЮ И ПРОБЕЛ
//        System.out.println("СНАЧАЛА ПРЕОБРАЗОВЫВАЕМ МАССИВ В СТРОКУ СО СЛОВАМИ ЧЕРЕЗ ЗАПЯТУЮ И ПРОБЕЛ");
//        String[] test = {"апельсины", "лимоны", "мандарины"};
//        System.out.println(Arrays.toString(test));
//        String strTest = String.join(", ", test);
//        System.out.println("strTest: " + strTest);
//        String testOutput = strTest.replaceAll(",$", "");
//        System.out.println("testOutput: " + testOutput);
//
//
//
////        for (int i = 0; i < words.length; i++) {
////            System.out.println(words[i] + " ");
////        }
//
//
////        extracted();
////
////        //  УБИРАЕМ ЗАПЯТУЮ И ПРОБЕЛ В КОНЦЕ СТРОКИ _ УДАЛИТЬ ЗАПЯТУЮ И ПРОБЕЛ В КОНЦЕ СТРОКИ
////        String s = "апельсины, лимоны, мандарины,";
////        String output = s.replaceAll(",$", "");
////        System.out.println(output);
////        //  или
////        String s2 = "a,b,c,";
////        String s3 = "a, b, c, ";
////        String s4 = "a , b , c , ";
////        String output2 = s2.replaceAll(",$", "");
////        String output3 = s3.replaceAll(", $", "");
////        String output4 = s4.replaceAll(" , $", "");
////        //  Всё вышеперпчисленное
////        String outputAll = s4.replaceAll("\\s*,\\s*$", "");
////
////        System.out.println();
////        System.out.println();
////        System.out.println(s2.replaceAll(",$", ""));
////        System.out.println(s3.replaceAll(", $", ""));
////        System.out.println(s4.replaceAll(" , $", ""));
////        System.out.println("//  Всё вышеперпчисленное");
////        System.out.println(s4.replaceAll("\\s*,\\s*$", ""));
//
//    }
//
//
////    //  Убираем запятую и пробел в конце
////    //  https://java-lessons.ru/strings/remove-trailing-comma
////    private static void extracted() {
////        String str = "kushal, mayurv, narendra, dhrumil, mark, ";
////        String splitted[] = str.split(", ");
////        StringBuffer sb = new StringBuffer();
////        String retrieveData = " ";
////        int x = splitted.length;
////        System.out.println(x);
////        for(int i =0; i<splitted.length; i++){
////            retrieveData = splitted[i];
////            if((retrieveData.trim()).length()>0){
////
////                if(i!=0){
////                    sb.append(", ");
////                }
////                sb.append(retrieveData);
////
////            }
////        }
////
////        str = sb.toString();
////        System.out.println(str);
////    }
//}
////        Конец Примера 2 КККККККККККККККК


////        Пример 1 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_1_Oper_Continue_break {
//    public static void main(String[] args) {
//        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
//                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
////        Scanner scanner = new Scanner (System.in);
////        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
////
////        String[] words = new String[3];
////        for (int i = 0; i < words.length; i++) {
////            words[i] = scanner.nextLine();
////        }
////        System.out.println(Arrays.toString(words));
////
////        for (int i = 0; i < words.length; i++) {
////            System.out.println(words[i] + " ");
////        }
//
//
////        extracted();
////
////        //  УБИРАЕМ ЗАПЯТУЮ И ПРОБЕЛ В КОНЦЕ СТРОКИ _ УДАЛИТЬ ЗАПЯТУЮ И ПРОБЕЛ В КОНЦЕ СТРОКИ
////        String s = "апельсины, лимоны, мандарины,";
////        String output = s.replaceAll(",$", "");
////        System.out.println(output);
////        //  или
////        String s2 = "a,b,c,";
////        String s3 = "a, b, c, ";
////        String s4 = "a , b , c , ";
////        String output2 = s2.replaceAll(",$", "");
////        String output3 = s3.replaceAll(", $", "");
////        String output4 = s4.replaceAll(" , $", "");
////        //  Всё вышеперпчисленное
////        String outputAll = s4.replaceAll("\\s*,\\s*$", "");
////
////        System.out.println();
////        System.out.println();
////        System.out.println(s2.replaceAll(",$", ""));
////        System.out.println(s3.replaceAll(", $", ""));
////        System.out.println(s4.replaceAll(" , $", ""));
////        System.out.println("//  Всё вышеперпчисленное");
////        System.out.println(s4.replaceAll("\\s*,\\s*$", ""));
//
//    }
//
//
////    //  Убираем запятую и пробел в конце
////    //  https://java-lessons.ru/strings/remove-trailing-comma
////    private static void extracted() {
////        String str = "kushal, mayurv, narendra, dhrumil, mark, ";
////        String splitted[] = str.split(", ");
////        StringBuffer sb = new StringBuffer();
////        String retrieveData = " ";
////        int x = splitted.length;
////        System.out.println(x);
////        for(int i =0; i<splitted.length; i++){
////            retrieveData = splitted[i];
////            if((retrieveData.trim()).length()>0){
////
////                if(i!=0){
////                    sb.append(", ");
////                }
////                sb.append(retrieveData);
////
////            }
////        }
////
////        str = sb.toString();
////        System.out.println(str);
////    }
//}
////        Конец Примера 1 КККККККККККККККК






