import java.util.Arrays;
import java.util.Scanner;

public class Draft_Task1_3_6_1_Oper_Continue_break {
    public static void main(String[] args) {
        System.out.println("Задание: \n1.  Пользователь вводит 10 слов в массив. Найдите первое слово, " +
                "\nв котором есть две гласные буквы подряд\n\nРешение: ");
//        Scanner scanner = new Scanner (System.in);
//        System.out.println("Введите 10 слов (после ввода каждого слова - клавиша Enter): ");
//
//        String[] words = new String[3];
//        for (int i = 0; i < words.length; i++) {
//            words[i] = scanner.nextLine();
//        }
//        System.out.println(Arrays.toString(words));
//
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i] + " ");
//        }


//        extracted();
//
//        //  УБИРАЕМ ЗАПЯТУЮ И ПРОБЕЛ В КОНЦЕ СТРОКИ _ УДАЛИТЬ ЗАПЯТУЮ И ПРОБЕЛ В КОНЦЕ СТРОКИ
//        String s = "апельсины, лимоны, мандарины,";
//        String output = s.replaceAll(",$", "");
//        System.out.println(output);
//        //  или
//        String s2 = "a,b,c,";
//        String s3 = "a, b, c, ";
//        String s4 = "a , b , c , ";
//        String output2 = s2.replaceAll(",$", "");
//        String output3 = s3.replaceAll(", $", "");
//        String output4 = s4.replaceAll(" , $", "");
//        //  Всё вышеперпчисленное
//        String outputAll = s4.replaceAll("\\s*,\\s*$", "");
//
//        System.out.println();
//        System.out.println();
//        System.out.println(s2.replaceAll(",$", ""));
//        System.out.println(s3.replaceAll(", $", ""));
//        System.out.println(s4.replaceAll(" , $", ""));
//        System.out.println("//  Всё вышеперпчисленное");
//        System.out.println(s4.replaceAll("\\s*,\\s*$", ""));

    }


//    //  Убираем запятую и пробел в конце
//    //  https://java-lessons.ru/strings/remove-trailing-comma
//    private static void extracted() {
//        String str = "kushal, mayurv, narendra, dhrumil, mark, ";
//        String splitted[] = str.split(", ");
//        StringBuffer sb = new StringBuffer();
//        String retrieveData = " ";
//        int x = splitted.length;
//        System.out.println(x);
//        for(int i =0; i<splitted.length; i++){
//            retrieveData = splitted[i];
//            if((retrieveData.trim()).length()>0){
//
//                if(i!=0){
//                    sb.append(", ");
//                }
//                sb.append(retrieveData);
//
//            }
//        }
//
//        str = sb.toString();
//        System.out.println(str);
//    }
}