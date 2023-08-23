package com.draft_task1_3_8;

public class Draft_Task1_3_8_0_Whole_Video_2_Peregruzka_metodov {
    public static void main(String[] args) {
        //  Module1_Tema3_Urok8 Перегрузка методов.
        //  видео мин 06 40 - внутри круглых скобок нажмите Ctrl + P
        //  ПРО ПАКЕТЫ ЗДЕСЬ: https://www.youtube.com/watch?v=-iEG-0g6CQ0
        //  закончил видео мин 08 55 но список аргументов должен быть разным, хотя бы в чём то должен отличаться
        //  закончил видео мин 10 38 вернемся к программе iTunes м напишем программу скачать песню
        //  закончил видео мин 14 51 создадим наш музыкальный плеер
        //  закончил видео мин 16 27 previewUrl - предпрослушивание
        //  закончил видео мин 18 33 выделим в отдельный метод, правой кнопкой мыши Refactor выбираете сверху -> Extract Method
        //  закончил видео мин 21 00 сделано Files.copy
        //  закончил видео мин 22 51 файл открыть в проводнике - на файле правой кнопкой мыши
        //  закончил видео мин 23 08 прямо в джаве откроем песню , как это сделать?
        //  закончил видео мин 23 55 как в этом убедиться (какая версия JDK: File -> Project Structure, Ctrl + Alt + Shift + S , Ctrl + точка, запятая ,
        //  закончил видео мин 27 44 Метод, который улучшит наш предыдущий метод и увеличит лимит Limit
        //  закончил видео мин 09 21

//        Printer printer = new Printer();
        MaxValue_previous printer = new MaxValue_previous();
//        setPrinterPrice(printer, 300);
//        setPrinterPrice(printer, 349.99);
//        setPrinterPriceInt(printer, 349);
//        setPrinterPriceString(printer, 349.0);
//        setPrinterPriceString(printer, String.valueOf(349.0));
//        setPrinterPrice(printer, "349.0");
//        System.out.println(printer.price);
        setPrinterPrice(printer,299);
        setPrinterPrice(printer,299.99);
        setPrinterPrice(printer,"349.0");

//        int x = 3;
//        boolean flag = true;
//        double pi = 3.14;
//        String hello = "world";
//
//        System.out.println(x);
//        System.out.println(flag);
//        System.out.println(pi);
//        System.out.println(hello);
        }
//        static void setPrinterPrice(com.draft_task1_3_8.MaxValue_previous balalaika, int price) {
    static void setPrinterPrice(MaxValue_previous balalaika, double price) {
        price = price + 50;
        balalaika.price = price;
    }

//    static void setPrinterPriceInt(com.draft_task1_3_8.MaxValue_previous printer, int price) {
    static void setPrinterPrice(MaxValue_previous printer, int price) {
        price = price + 50;
        printer.price = price;
    }

//    static void setPrinterPriceString (com.draft_task1_3_8.MaxValue_previous printer, String price) {
    static void setPrinterPrice (MaxValue_previous printer, String price) {
        double priceDouble = Double.parseDouble(price);
        priceDouble += 50;
        printer.price = 50;
    }
}

class PrinterMfu {
    String maker;
    double price;
}

class MaxValue_previous {
    double price;
    double b;
}


//        com.draft_task1_3_8.MaxValue_previous printer = new com.draft_task1_3_8.MaxValue_previous();
//        System.out.println(printer.price);
//        setPrinterPrice(printer, "349.O");
//        setPrinterPrice(printer, 299);
//        setPrinterPrice(printer, 299.99);
//    }
//    static void setPrinterPrice(com.draft_task1_3_8.MaxValue_previous balalaika, double price) {
//    price += 50;
//    balalaika.price = price;
//}
//    static com.draft_task1_3_8.MaxValue_previous setPrinterPrice(com.draft_task1_3_8.MaxValue_previous printer, int price) {
//        price += 50;
//        printer.price = price;
//        return printer;
//}
//    static int setPrinterPrice (com.draft_task1_3_8.MaxValue_previous printer, String price) {
//        double priceDouble = Double.parseDouble(price);
//        priceDouble += 50;
//        printer.price = 50;
//        return 1;
//    }
//}
//
//
//
//
//class com.draft_task1_3_8.MaxValue_previous {
//
//}
