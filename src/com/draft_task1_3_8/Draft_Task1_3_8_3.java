package com.draft_task1_3_8;

//        Пример _ ППППППППППППППППППППППППППППППППППП  //
//        Method 2: Without using pre-defined function
//        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
public class Draft_Task1_3_8_3 {
    // Java-программа для демонстрации слияния двух массивов без использования предопределенного метода
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                3. Реализуйте методы join(String s1, String s2), join(String s1, String s2, String s3), ….
                   join(String s1, String s2, String s3, String s4) - которые склеивают строки

                Решение:\s""");

        JoinStrings joinStrings = new JoinStrings();

        // первая строка
        String s1 = "Hello";
        // вторая строка
        String s2 = "world";
        // третья строка
        String s3 = "of";
        // четвертая строка
        String s4 = "Java";

        System.out.println("Первая исходная строка: " + s1);
        System.out.println("Вторая исходная строка: " + s2);
        System.out.println("Третья исходная строка: " + s3);
        System.out.println("Четвертая исходная строка: " + s4);
        System.out.println();  //  перенос строки

        join(joinStrings, s1, s2);
        System.out.println("Результат 'склеивания' s1 и s2, строка joinedString1: \n" + join(joinStrings, s1, s2));

        join(joinStrings, s1, s2, s3);
        System.out.println("Результат 'склеивания' s1, s2 и s3, строка joinedString2: \n" + join(joinStrings, s1, s2, s3));

        join(joinStrings, s1, s2, s3, s4);
        System.out.println("Результат 'склеивания' s1, s2, s3 и s4, строка joinedString3: \n" + join(joinStrings, s1, s2, s3, s4));
    }

    static String join(JoinStrings var1, String s1, String s2) {
        var1.joinedString1 = s1 + " " + s2;

        return var1.joinedString1;
    }

    static String join(JoinStrings var2, String s1, String s2, String s3) {
        var2.joinedString2 = s1 + " " + s2 + " " + s3;

        return var2.joinedString2;
    }

    static String join(JoinStrings var2, String s1, String s2, String s3, String s4) {
        var2.joinedString3 = s1 + " " + s2 + " " + s3 + " " + s4;

        return var2.joinedString3;
    }
}

class JoinStrings {
    String joinedString1;
    String joinedString2;
    String joinedString3;
}

//        Конец Примера _ КККККККККККККККК






