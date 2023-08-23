package com.draft_task1_3_8;

//        Пример _ ППППППППППППППППППППППППППППППППППП  //  ОТПРАВЛЕН В ЭТОМ ВИДЕ с var
public class Draft_Task1_3_8_2_Logicheskoe_I {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                2. Реализуйте методы and(boolean a, boolean y), and(boolean a, int y), and(int a,
                       boolean y), который будет возвращать логическое И. Целые числа равные 0
                       трактовать как false, остальные true

                Решение:\s""");

        BooleanValue booleanValue = new BooleanValue();

        System.out.println("Реализуем перегружаемые методы and:  \n");

        and(booleanValue, true, true);  //  для метода and с: boolean a, boolean y
        and(booleanValue, true, 0);  //  для метода and с: boolean a, int y
        and(booleanValue, 10, true);  //  для метода and с: int a, boolean y
    }

    //  Реализуем перегружаемые методы
    static void and(BooleanValue var, boolean a, boolean y) {
        var.BooleanValue_true = "верно";
        var.BooleanValue_false = "ложно";
        System.out.println("Вариант 1: ");
        a = y == true;
        if (a == true) {
            System.out.println("Утверждение \"логическое И\": " + var.BooleanValue_true);
        } else {
            System.out.println("Утверждение \"логическое И\": " + var.BooleanValue_false);
        }
        System.out.println();  //  перенос строки
    }

    static void and(BooleanValue var, boolean a, int y) {
        var.BooleanValue_true = "верно";
        var.BooleanValue_false = "ложно";
        System.out.println("Вариант 2: ");
        a = y != 0;
        if (a == true) {
            System.out.println("Утверждение \"логическое И\": " + var.BooleanValue_true);
        } else {
            System.out.println("Утверждение \"логическое И\": " + var.BooleanValue_false);
        }
        System.out.println();  //  перенос строки
    }

    static void and(BooleanValue var, int a, boolean y) {
        var.BooleanValue_true = "верно";
        var.BooleanValue_false = "ложно";
        System.out.println("Вариант 3: ");
        y = a != 0;
        if (y == true) {
            System.out.println("Утверждение \"логическое И\": " + var.BooleanValue_true);
        } else {
            System.out.println("Утверждение \"логическое И\": " + var.BooleanValue_false);
        }
    }
}

class BooleanValue {
    String BooleanValue_true;
    String BooleanValue_false;
}
//        Конец Примера _ КККККККККККККККК