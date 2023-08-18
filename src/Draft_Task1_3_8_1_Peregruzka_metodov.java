
//        Пример _ ППППППППППППППППППППППППППППППППППП  //  ОТПРАВЛЕН В ЭТОМ ВИДЕ с балалайкой, (а точнее, с переменной) !!!!!
public class Draft_Task1_3_8_1_Peregruzka_metodov {
    public static void main(String[] args) {
        System.out.println("""
            Задание:\s
            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
               случае строк - возвращает самую длинную)

            Решение:\s""");

        MaxValue maxValue = new MaxValue();

        System.out.println("Реализуем перегружаемые методы max:  \n");

        max(maxValue,10, 20);  //  для метода max с переменными Integer
        max(maxValue,100., 50.);  //  для метода max с переменными Double
        max(maxValue,"Строка Один", "Строка Два");  //  для метода max с переменными String
    }

    //  Реализуем перегруженные методы
    static void max(MaxValue peremennaya, int x, int y) {
        peremennaya.maxInt = 0;
        System.out.println("С методом max c переменными Integer: ");
        System.out.println("Исходные переменные: x = " + x + ", y = " + y);
        if (x>y) {
            peremennaya.maxInt = x;
            System.out.println("Наибольшее значение имеет x = " + peremennaya.maxInt);
        } else if (y>x) {
            peremennaya.maxInt = y;
            System.out.println("Наибольшее значение имеет y = " + peremennaya.maxInt);
        } else {
            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
        }
        System.out.println();  //  перенос строки
    }

    static void max(MaxValue peremennaya, double x, double y) {
        peremennaya.maxDouble = 0;
        System.out.println("С методом max c переменными Double: ");
        System.out.println("Исходные переменные: x = " + x + ", y = " + y);
        if (x>y) {
            peremennaya.maxDouble = x;
            System.out.println("Наибольшее значение имеет x = " + peremennaya.maxDouble);
        } else if (y>x) {
            peremennaya.maxDouble = y;
            System.out.println("Наибольшее значение имеет y = " + peremennaya.maxDouble);
        } else {
            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
        }
        System.out.println();  //  перенос строки
    }

    static void max(MaxValue peremennaya, String firstStr, String secondStr) {
        peremennaya.maxString = 0;
        System.out.println("С методом max c переменными Srting: ");
        int x = firstStr.length();
        int y = secondStr.length();

        System.out.println("Исходные строки: firstStr = \"" + firstStr + "\", secondStr = \"" + secondStr + "\"");
        if (x>y) {
            peremennaya.maxString = x;
            System.out.println("Наибольшую длину имеет строка firstStr, \"" + firstStr + "\", кол-во символов = " + peremennaya.maxString);
        } else if (y>x) {
            peremennaya.maxString = y;
            System.out.println("Наибольшую длину имеет строка secondStr, \"" + secondStr + "\", кол-во символов = " + peremennaya.maxString);
        } else {
            System.out.println("Некорректный ввод строк firstStr и secondStr. Попробуйте еще раз.");
        }
    }
}

class MaxValue {
    int maxInt;
    double maxDouble;
    int maxString;
}
//        Конец Примера _ КККККККККККККККК







////        Пример 8 ППППППППППППППППППППППППППППППППППП  //  Все работает с балалайкой применительно к нашему методу, удалить лишние строки
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
//        int b = 0;
//        String price = null;
////        int max = 0;
////        int x = 0;
////        int y = 0;
//
//        System.out.println("Реализуем перегружаемые методы:  ");
//
//        max(maxValue, price, b, 10, 20);  //  для метода max с переменными Integer
//        max(maxValue, price, b, 100., 50.);  //  для метода max с переменными Double
//        max(maxValue, price, b, "Строка Один", "Строка Два");  //  для метода max с переменными Double
//    }
//
//    //  Реализуем перегруженные методы
//    static void max(MaxValue balalaika, String price, int b, int x, int y) {
//
////        String price = "199";  // если не закомментить, тогда не нужно входного параметра метода String price,
//        price = "199";
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        balalaika.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + balalaika.price);
//
////        double bDouble = b;
//        balalaika.b = 1000;
//        System.out.println("Переменная b = " + balalaika.b);
//        System.out.println();  //  перенос строки
//
////        int max = 0;
//        balalaika.maxInt = 0;
//        System.out.println("С методом max c переменными Integer: ");
//        System.out.println("Исходные переменные: x = " + x + ", y = " + y);
//        if (x>y) {
//            balalaika.maxInt = x;
//            System.out.println("Наибольшее значение имеет x = " + balalaika.maxInt);
//        } else if (y>x) {
//            balalaika.maxInt = y;
//            System.out.println("Наибольшее значение имеет y = " + balalaika.maxInt);
//        } else {
//            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
//        }
//        System.out.println();  //  перенос строки
//    }
//
//    static void max(MaxValue balalaika, String price, int b, double x, double y) {
//
////        String price = "199";  // если не закомментить, тогда не нужно входного параметра метода String price,
//        price = "199";
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        balalaika.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + balalaika.price);
//
////        double bDouble = b;
//        balalaika.b = 1000;
//        System.out.println("Переменная b = " + balalaika.b);
//        System.out.println();  //  перенос строки
//
////        int max = 0;
//        balalaika.maxDouble = 0;
//        System.out.println("С методом max c переменными Double: ");
//        System.out.println("Исходные переменные: x = " + x + ", y = " + y);
//        if (x>y) {
//            balalaika.maxDouble = x;
//            System.out.println("Наибольшее значение имеет x = " + balalaika.maxDouble);
//        } else if (y>x) {
//            balalaika.maxDouble = y;
//            System.out.println("Наибольшее значение имеет y = " + balalaika.maxDouble);
//        } else {
//            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
//        }
//        System.out.println();  //  перенос строки
//    }
//
//    static void max(MaxValue balalaika, String price, int b, String firstStr, String secondStr) {
//
////        String price = "199";  // если не закомментить, тогда не нужно входного параметра метода String price,
//        price = "199";
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        balalaika.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + balalaika.price);
//
////        double bDouble = b;
//        balalaika.b = 1000;
//        System.out.println("Переменная b = " + balalaika.b);
//        System.out.println();  //  перенос строки
//
////        int max = 0;
//
//        balalaika.maxString = 0;
//        System.out.println("С методом max c переменными Srting: ");
//        int x = firstStr.length();
//        int y = secondStr.length();
//
//        System.out.println("Исходные строки: firstStr = \"" + firstStr + "\", secondStr = \"" + secondStr + "\"");
//        if (x>y) {
//            balalaika.maxString = x;
//            System.out.println("Наибольшую длину имеет строка firstStr, \"" + firstStr + "\", кол-во символов = " + balalaika.maxString);
//        } else if (y>x) {
//            balalaika.maxString = y;
//            System.out.println("Наибольшую длину имеет строка secondStr, \"" + secondStr + "\", кол-во символов = " + balalaika.maxString);
//        } else {
//            System.out.println("Некорректный ввод строк firstStr и secondStr. Попробуйте еще раз.");
//        }
//    }
//
//
//
//}
//
//class MaxValue {
//    double price;
//    double b;
//    int maxInt;
//    double maxDouble;
//    int maxString;
//}
////        Конец Примера 8 КККККККККККККККК







////        Пример 7 ППППППППППППППППППППППППППППППППППП  //  ПРОДОЛЖЕНИЕ7. Экспериментирование с балалайкой.
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
//        int b = 0;
//        String price = null;
//
//        max(maxValue, price, b);  //  для метода max с c переменными String
//    }
//
//    //  Реализуем перегруженные методы
//    static void max(MaxValue balalaika, String price, int b) {
//
////        String price = "199";  // если не закомментить, тогда не нужно входного параметра метода String price,
//        price = "199";
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        balalaika.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + balalaika.price);
//
////        double bDouble = b;
//        balalaika.b = 1000;
//        System.out.println("Переменная b = " + balalaika.b);
//    }
//}
//
//class MaxValue {
//    double price;
//    double b;
//}
////        Конец Примера 7 КККККККККККККККК







////        Пример 6 ППППППППППППППППППППППППППППППППППП  //  ПРОДОЛЖЕНИЕ2. Экспериментирование с балалайкой.
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//            Задание:\s
//            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//               случае строк - возвращает самую длинную)
//
//            Решение:\s""");
//
//        MaxValue_previous maxValue = new MaxValue_previous();
//
//        //  Вводим исходные значения
//        int b = 0;
//        String price = null;
//
//        max(maxValue, price, b/*, "Один", "Два"*/);  //  для метода max с c переменными String
//    }
//
//    //  Реализуем перегруженные методы
//    static void max(MaxValue_previous balalaika, String price, int b/*, String firstStr, String secondStr*/) {
//
//        price = "199";
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        balalaika.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + balalaika.price);
//
//        double bDouble = b;
//        balalaika.b = 1000;
//        System.out.println("Переменная b = " + balalaika.b);
//    }
//}
//
//class MaxValue_previous {
//    double price;
//    double b;
//}
////        Конец Примера 6 КККККККККККККККК







////        Пример 5 ППППППППППППППППППППППППППППППППППП  //  ПРОДОЛЖЕНИЕ. Экспериментирование с балалайкой.
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//            Задание:\s
//            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//               случае строк - возвращает самую длинную)
//
//            Решение:\s""");
//
//        MaxValue_previous maxValue = new MaxValue_previous();
//
//        //  Вводим исходные значения
//        int a = 0;
//        int b = 0;
//
//        max(maxValue,299, a/*, 10, 20*/);  //  для метода max с c переменными Integer
//        max(maxValue,299.99/*, 100, 50*/);  //  для метода max с c переменными Double
//        max(maxValue,"349", b/*, "Один", "Два"*/);  //  для метода max с c переменными String
//
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
//
//    }
//
//    //  Реализуем перегруженные методы
//    static void max(MaxValue_previous maxValue, int price, int a/*, int x, int y*/) {
////        System.out.println("С методом max c переменными Integer: ");
////        if (x>y) {
////            int max = x;
////            System.out.println("Наибольшее значение имеет x = " + max);
////        } else if (y>x) {
////            int max = y;
////            System.out.println("Наибольшее значение имеет y = " + max);
////        } else {
////            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
////        }
//
//        price = price + 50;
//        maxValue.price = price;
//        System.out.println("С методом max c переменной Integer, price = " + maxValue.price);
//
//        a = 1000;
//        System.out.println("Переменная a = " + a);
//
//        System.out.println();  //  перенос строки
//    }
//
//    static void max(MaxValue_previous balalaika, double price/*, double x, double y*/) {
////        System.out.println("С методом max c переменными Double: ");
////        if (x>y) {
////            double max = x;
////            System.out.println("Наибольшее значение имеет x = " + max);
////        } else if (y>x) {
////            double max = y;
////            System.out.println("Наибольшее значение имеет y = " + max);
////        } else {
////            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
////        }
//
//        price = price + 50;
//        balalaika.price = price;
//        System.out.println("С методом max c переменной Double, price = " + balalaika.price);
//        System.out.println();  //  перенос строки
//    }
//
//    static void max(MaxValue_previous baraban, String price, int b/*, String firstStr, String secondStr*/) {
////        System.out.println("С методом max c переменными String: ");
////        int x = firstStr.length();
////        int y = secondStr.length();
////        if (x>y) {
////            int max = x;
////            System.out.println("Наибольшую длину имеет строка firstStr, \"" + firstStr + "\", кол-во символов = " + max);
////        } else if (y>x) {
////            int max = y;
////            System.out.println("Наибольшую длину имеет строка secondStr, \"" + secondStr + "\", кол-во символов = " + max);
////        } else {
////            System.out.println("Некорректный ввод строк firstStr и secondStr. Попробуйте еще раз.");
////        }
////        System.out.println();  //  перенос строки
//
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        baraban.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + baraban.price);
//
//        b = 1000;
//        System.out.println("Переменная b = " + b);
//    }
//}
//
//class MaxValue_previous {
//    double price;
//}
////        Конец Примера 5 КККККККККККККККК







////        Пример 4 ППППППППППППППППППППППППППППППППППП  //  Экспериментирование  с балалайкой.
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//            Задание:\s
//            1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//               случае строк - возвращает самую длинную)
//
//            Решение:\s""");
//
//        MaxValue_previous maxValue = new MaxValue_previous();
//
//        //  Вводим исходные значения
//        max(maxValue,299, 10, 20);  //  для метода max с c переменными Integer
//        max(maxValue,299.99, 100, 50);  //  для метода max с c переменными Double
//        max(maxValue,"349", "Один", "Два");  //  для метода max с c переменными String
//
//        double price;
//
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
//
//    }
//
//    //  Реализуем перегруженные методы
//    static void max(MaxValue_previous maxValue, int price, int x, int y) {
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
//        price = price + 50;
//        maxValue.price = price;
//        System.out.println("С методом max c переменной Integer, price = " + maxValue.price);
//    }
//
//    static void max(MaxValue_previous balalaika, double price, double x, double y) {
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
//        price = price + 50;
//        balalaika.price = price;
//        System.out.println("С методом max c переменной Double, price = " + balalaika.price);
//    }
//
//    static void max(MaxValue_previous printer, String price, String firstStr, String secondStr) {
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
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        printer.price = priceDouble;
//        System.out.println("С методом max c переменной String, price = " + printer.price);
//    }
//}
//
//class MaxValue_previous {
//    double price;
//}
////        Конец Примера 4 КККККККККККККККК







////        Пример _ ППППППППППППППППППППППППППППППППППП  //  С балалайкой. РАБОТАЕТ, МОЖНО ОТПРАВЛЯТЬ
//public class Draft_Task1_3_8_1_Peregruzka_metodov {
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в
//                   случае строк - возвращает самую длинную)
//
//                Решение:\s""");
//
//        MaxValue_previous maxValue = new MaxValue_previous();
//
//        //  Вводим исходные значения
//        max(maxValue, 299, 10, 20);  //  для метода max с c переменными Integer
//        max(maxValue, 299.99, 100, 50);  //  для метода max с c переменными Double
//        max(maxValue, "349", "Один", "Два");  //  для метода max с c переменными String
//    }
//
//    //  Реализуем перегруженные методы
//    static void max(MaxValue_previous maxValue, int price, int x, int y) {
//        System.out.println("С методом max c переменными Integer: ");
//        if (x > y) {
//            int max = x;
//            System.out.println("Наибольшее значение имеет x = " + max);
//        } else if (y > x) {
//            int max = y;
//            System.out.println("Наибольшее значение имеет y = " + max);
//        } else {
//            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
//        }
//        System.out.println();  //  перенос строки
//    }
//
//    static void max(MaxValue_previous balalaika, double price, double x, double y) {
//        System.out.println("С методом max c переменными Double: ");
//        if (x > y) {
//            double max = x;
//            System.out.println("Наибольшее значение имеет x = " + max);
//        } else if (y > x) {
//            double max = y;
//            System.out.println("Наибольшее значение имеет y = " + max);
//        } else {
//            System.out.println("Некорректный ввод x и y. Попробуйте еще раз.");
//        }
//        System.out.println();  //  перенос строки
//    }
//
//    static void max(MaxValue_previous printer, String price, String firstStr, String secondStr) {
//        System.out.println("С методом max c переменными String: ");
//        int x = firstStr.length();
//        int y = secondStr.length();
//        if (x > y) {
//            int max = x;
//            System.out.println("Наибольшую длину имеет строка firstStr, \"" + firstStr + "\", кол-во символов = " + max);
//        } else if (y > x) {
//            int max = y;
//            System.out.println("Наибольшую длину имеет строка secondStr, \"" + secondStr + "\", кол-во символов = " + max);
//        } else {
//            System.out.println("Некорректный ввод строк firstStr и secondStr. Попробуйте еще раз.");
//        }
//    }
//}
//
//class MaxValue_previous {
//    double price;
//}
////        Конец Примера _ КККККККККККККККК







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
//        MaxValue_previous maxValue = new MaxValue_previous();
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
//    static void max(MaxValue_previous maxValue, int price, int x, int y) {
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
//    static void max(MaxValue_previous balalaika, double price, double x, double y) {
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
//    static void max(MaxValue_previous printer, String price, String firstStr, String secondStr) {
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
//class MaxValue_previous {
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
//        MaxValue_previous maxValue = new MaxValue_previous();
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
//    //    static void setPrinterPriceInt(MaxValue_previous printer, int price) {
//    static void max(MaxValue_previous maxValue, int price) {
//        price = price + 50;
//        maxValue.price = price;
//    }
//
//    //        static void setPrinterPriceDouble(MaxValue_previous balalaika, int price) {
//    static void max(MaxValue_previous balalaika, double price) {
//        price = price + 50;
//        balalaika.price = price;
//    }
//
//    //    static void setPrinterPriceString (MaxValue_previous printer, String price) {
//    static void max(MaxValue_previous printer, String price) {
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        printer.price = 50;
//        System.out.println(priceDouble);
//        System.out.println(printer.price);
//    }
//}
//
//class MaxValue_previous {
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
//        MaxValue_previous printer = new MaxValue_previous();
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
//    //        static void setPrinterPrice(MaxValue_previous balalaika, int price) {
//    static void setPrinterPrice(MaxValue_previous balalaika, double price) {
//        price = price + 50;
//        balalaika.price = price;
//    }
//
//    //    static void setPrinterPriceInt(MaxValue_previous printer, int price) {
//    static void setPrinterPrice(MaxValue_previous printer, int price) {
//        price = price + 50;
//        printer.price = price;
//    }
//
//    //    static void setPrinterPriceString (MaxValue_previous printer, String price) {
//    static void setPrinterPrice (MaxValue_previous printer, String price) {
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        printer.price = 50;
//    }
//}
//
//class MaxValue_previous {
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







