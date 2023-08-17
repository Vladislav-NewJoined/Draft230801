//        Пример _ ППППППППППППППППППППППППППППППППППП  //  С балалайкой. РАБОТАЕТ, МОЖНО ОТПРАВЛЯТЬ
public class Draft_Task1_3_8_1_Peregruzka_metodov {
    public static void main(String[] args) {
        System.out.println("""
            Задание:\s
            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
               случае строк - возвращает самую длинную)

            Решение:\s""");

        MaxValue maxValue = new MaxValue();

        //  Вводим исходные значения
        max(maxValue,299, 10, 20);  //  для метода max с c переменными Integer
        max(maxValue,299.99, 100, 50);  //  для метода max с c переменными Double
        max(maxValue,"349", "Один", "Два");  //  для метода max с c переменными String

//        int x = 3;
//        boolean flag = true;
//        double pi = 3.14;
//        String hello = "world";
//
//        System.out.println(x);
//        System.out.println(flag);
//        System.out.println(pi);
//        System.out.println(hello);










//        System.out.println("Ищем максимальное значения в динамических массивах arrIntegers, arrDoubles, arrStrings.");
//
//        ArrayList<Integer> arrIntegers = new ArrayList<>();
//        arrIntegers.add(10);
//        arrIntegers.add(20);
//        arrIntegers.add(-8);
//
//        ArrayList<Double> arrDoubles = new ArrayList<>();
//        arrDoubles.add(5.5);
//        arrDoubles.add(12.33);
//        arrDoubles.add(-4.44);

    }

    //  Реализуем перегруженные методы
    static void max(MaxValue maxValue, int price, int x, int y) {
        System.out.println("С методом max c переменными Integer: ");
        if (x>y) {
            int max = x;
            System.out.println("Наибольшее значение имеет x = " + max);
        } else if (y>x) {
            int max = y;
            System.out.println("Наибольшее значение имеет y = " + max);
        } else {
            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
        }
        System.out.println();  //  перенос строки

//        price = price + 50;
//        maxValue.price = price;
//        System.out.println("С методом max c переменной Integer, price = " + maxValue.price);
    }

    static void max(MaxValue balalaika, double price, double x, double y) {
        System.out.println("С методом max c переменными Double: ");
        if (x>y) {
            double max = x;
            System.out.println("Наибольшее значение имеет x = " + max);
        } else if (y>x) {
            double max = y;
            System.out.println("Наибольшее значение имеет y = " + max);
        } else {
            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
        }
        System.out.println();  //  перенос строки

//        price = price + 50;
//        balalaika.price = price;
//        System.out.println("С методом max c переменной Double, price = " + balalaika.price);
    }

    static void max(MaxValue printer, String price, String firstStr, String secondStr) {
        System.out.println("С методом max c переменными String: ");
        int x = firstStr.length();
        int y = secondStr.length();
        if (x>y) {
            int max = x;
            System.out.println("Наибольшую длину имеет строка firstStr, \"" + firstStr + "\", кол-во символов = " + max);
        } else if (y>x) {
            int max = y;
            System.out.println("Наибольшую длину имеет строка secondStr, \"" + secondStr + "\", кол-во символов = " + max);
        } else {
            System.out.println("Некорректный ввод строк firstStr и secondStr. Попробуйте еще раз.");
        }
//        System.out.println();  //  перенос строки

//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        printer.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + printer.price);
    }
}

class MaxValue {
    double price;
}
//        Конец Примера _ КККККККККККККККК







////        Пример 3 ППППППППППППППППППППППППППППППППППП  //  С балалайкой. РАБОТАЕТ , УДАЛИТЬ ЛИШНИЕ СТРОКИ
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//            Задание:\s
//            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//               случае строк - возвращает самую длинную)
//
//            Решение:\s""");
//
//        MaxValue maxValue = new MaxValue();
//
//        //  Вводим исходные значения
//        max(maxValue,299, 10, 20);  //  для метода max с c переменными Integer
//        max(maxValue,299.99, 100, 50);  //  для метода max с c переменными Double
//        max(maxValue,"349", "Один", "Два");  //  для метода max с c переменными String
//
////        int x = 3;
////        boolean flag = true;
////        double pi = 3.14;
////        String hello = "world";
////
////        System.out.println(x);
////        System.out.println(flag);
////        System.out.println(pi);
////        System.out.println(hello);
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
////        System.out.println("Ищем максимальное значения в динамических массивах arrIntegers, arrDoubles, arrStrings.");
////
////        ArrayList<Integer> arrIntegers = new ArrayList<>();
////        arrIntegers.add(10);
////        arrIntegers.add(20);
////        arrIntegers.add(-8);
////
////        ArrayList<Double> arrDoubles = new ArrayList<>();
////        arrDoubles.add(5.5);
////        arrDoubles.add(12.33);
////        arrDoubles.add(-4.44);
//
//    }
//
//    //  Реализуем перегруженные методы
//    static void max(MaxValue maxValue, int price, int x, int y) {
//        System.out.println("С методом max c переменными Integer: ");
//        if (x>y) {
//            int max = x;
//            System.out.println("Наибольшее значение имеет x = " + max);
//        } else if (y>x) {
//            int max = y;
//            System.out.println("Наибольшее значение имеет y = " + max);
//        } else {
//            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
//        }
//        System.out.println();  //  перенос строки
//
////        price = price + 50;
////        maxValue.price = price;
////        System.out.println("С методом max c переменной Integer, price = " + maxValue.price);
//    }
//
//    static void max(MaxValue balalaika, double price, double x, double y) {
//        System.out.println("С методом max c переменными Double: ");
//        if (x>y) {
//            double max = x;
//            System.out.println("Наибольшее значение имеет x = " + max);
//        } else if (y>x) {
//            double max = y;
//            System.out.println("Наибольшее значение имеет y = " + max);
//        } else {
//            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
//        }
//        System.out.println();  //  перенос строки
//
////        price = price + 50;
////        balalaika.price = price;
////        System.out.println("С методом max c переменной Double, price = " + balalaika.price);
//    }
//
//    static void max(MaxValue printer, String price, String firstStr, String secondStr) {
//        System.out.println("С методом max c переменными String: ");
//        int x = firstStr.length();
//        int y = secondStr.length();
//        if (x>y) {
//            int max = x;
//            System.out.println("Наибольшую длину имеет строка firstStr, \"" + firstStr + "\", кол-во символов = " + max);
//        } else if (y>x) {
//            int max = y;
//            System.out.println("Наибольшую длину имеет строка secondStr, \"" + secondStr + "\", кол-во символов = " + max);
//        } else {
//            System.out.println("Некорректный ввод строк firstStr и secondStr. Попробуйте еще раз.");
//        }
////        System.out.println();  //  перенос строки
//
////        double priceDouble = Double.parseDouble(price);
////        priceDouble += 50;
////        printer.price = priceDouble;
////        System.out.println("С методом max c переменной String, price = " + printer.price);
//    }
//}
//
//class MaxValue {
//    double price;
//}
////        Конец Примера 3 КККККККККККККККК







////        Пример 2 ППППППППППППППППППППППППППППППППППП  //  РАБОТАЕТ , С балалайкой ,
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//            Задание:\s
//            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//               случае строк - возвращает самую длинную)
//
//            Решение:\s""");
//
//        MaxValue maxValue = new MaxValue();
//
//        max(maxValue,299);
//        max(maxValue,299.99);
//        max(maxValue,"349.0");
//
////        int x = 3;
////        boolean flag = true;
////        double pi = 3.14;
////        String hello = "world";
////
////        System.out.println(x);
////        System.out.println(flag);
////        System.out.println(pi);
////        System.out.println(hello);
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
////        System.out.println("Ищем максимальное значения в динамических массивах arrIntegers, arrDoubles, arrStrings.");
////
////        ArrayList<Integer> arrIntegers = new ArrayList<>();
////        arrIntegers.add(10);
////        arrIntegers.add(20);
////        arrIntegers.add(-8);
////
////        ArrayList<Double> arrDoubles = new ArrayList<>();
////        arrDoubles.add(5.5);
////        arrDoubles.add(12.33);
////        arrDoubles.add(-4.44);
//
//    }
//    //    static void setPrinterPriceInt(MaxValue printer, int price) {
//    static void max(MaxValue maxValue, int price) {
//        price = price + 50;
//        maxValue.price = price;
//    }
//
//    //        static void setPrinterPriceDouble(MaxValue balalaika, int price) {
//    static void max(MaxValue balalaika, double price) {
//        price = price + 50;
//        balalaika.price = price;
//    }
//
//    //    static void setPrinterPriceString (MaxValue printer, String price) {
//    static void max(MaxValue printer, String price) {
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        printer.price = 50;
//        System.out.println(priceDouble);
//        System.out.println(printer.price);
//    }
//}
//
//class MaxValue {
//    double price;
//}
////        Конец Примера 3 КККККККККККККККК







////        Пример 2 ППППППППППППППППППППППППППППППППППП  //  Вариант Виктора Сильнова
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//            Задание:\s
//            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//               случае строк - возвращает самую длинную)
//
//            Решение:\s""");
//
//        MaxValue printer = new MaxValue();
//
//        setPrinterPrice(printer,299);
//        setPrinterPrice(printer,299.99);
//        setPrinterPrice(printer,"349.0");
//
////        int x = 3;
////        boolean flag = true;
////        double pi = 3.14;
////        String hello = "world";
////
////        System.out.println(x);
////        System.out.println(flag);
////        System.out.println(pi);
////        System.out.println(hello);
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
////        System.out.println("Ищем максимальное значения в динамических массивах arrIntegers, arrDoubles, arrStrings.");
////
////        ArrayList<Integer> arrIntegers = new ArrayList<>();
////        arrIntegers.add(10);
////        arrIntegers.add(20);
////        arrIntegers.add(-8);
////
////        ArrayList<Double> arrDoubles = new ArrayList<>();
////        arrDoubles.add(5.5);
////        arrDoubles.add(12.33);
////        arrDoubles.add(-4.44);
//
//    }
//    //        static void setPrinterPrice(MaxValue balalaika, int price) {
//    static void setPrinterPrice(MaxValue balalaika, double price) {
//        price = price + 50;
//        balalaika.price = price;
//    }
//
//    //    static void setPrinterPriceInt(MaxValue printer, int price) {
//    static void setPrinterPrice(MaxValue printer, int price) {
//        price = price + 50;
//        printer.price = price;
//    }
//
//    //    static void setPrinterPriceString (MaxValue printer, String price) {
//    static void setPrinterPrice (MaxValue printer, String price) {
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        printer.price = 50;
//    }
//}
//
//class MaxValue {
//    String maker;
//    double price;
//}
////        Конец Примера 2 КККККККККККККККК







////        Пример 1 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//            Задание:\s
//            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//               случае строк - возвращает самую длинную)
//
//            Решение:\s""");
//        System.out.println("Ищем максимальное значения в динамических массивах arrIntegers, arrDoubles, arrStrings.");
//
//        ArrayList<Integer> arrIntegers = new ArrayList<>();
//        arrIntegers.add(10);
//        arrIntegers.add(20);
//        arrIntegers.add(-8);
//
//        ArrayList<Double> arrDoubles = new ArrayList<>();
//        arrDoubles.add(5.5);
//        arrDoubles.add(12.33);
//        arrDoubles.add(-4.44);
//
//
//
//        int arrSize = 3;
//
//// loop to find maximum from ArrayList of Integers
//        int max = max(arrIntegers, arrSize);
////        double max = max(arrDoubles, arrSize);
//
//
//// The result will be printed
//        System.out.println("\nРеализуем метод max с Integers: \nМаксимальное значение Integer: " + max);
//    }
//
//    private static int max(ArrayList<Integer> arrIntegers, int arrSize) {
//        int max = arrIntegers.get(0);
//        for (int i = 1; i < arrSize; i++) {
//            if (arrIntegers.get(i) > max) {
//                max = arrIntegers.get(i);
//            }
//        }
//        return max;
//    }
//
////    private static double max(ArrayList<Double> arrDoubles, int arrSize) {
////        int max = arrDoubles.get(0);
////        for (int i = 1; i < arrSize; i++) {
////            if (arrDoubles.get(i) > max) {
////                max = arrDoubles.get(i);
////            }
////        }
////        return max;
////    }
//}
////        Конец Примера 1 КККККККККККККККК







