package com.draft_task1_3_7;

import com.myPackage230814.Printer;

//        Пример _ ППППППППППППППППППППППППППППППППППП
public class Draft_Task1_3_7_0_Whole_Video {
    public static void main(String[] args) {
  //  Module1_Tema3_Урок 7. Параметры методов
  //  видео мин 04 01 - есть x, и нет никакого лимита
  //  видео мин 07 10 - создадим новый класс
  //  видео мин 07 17 - создадим класс именно Printer
  //  видео мин 16 10 - переменные, которые НЕ ОБЪЕКТ , НЕ ОБЪЕКТЫ , их всего 8 таких типов данных , примитивы или примитивные
  //  видео мин 17 40 - при этом, если Вы работаете с классами,
  //  []  type/void  name  (args, это: <type>  <name>)   {
        int y = 100;
        MyClass23_test.printer();
        System.out.println("old y = " + y);
    }
}
class MyClass23_test {
    static void printer() {
        Printer printer = new Printer();
        printer.maker = "HP";
        int x = 10;
        int y = 100;
        int abc = setPrinterPrice(printer);
        System.out.println("printer.maker = " + printer.maker);
        System.out.println("x = " + x);
        System.out.println("new y = " + y);
        System.out.println("abc = " + abc);

        setPrinterPrice(printer);
    }

    static int setPrinterPrice (Printer balalaika) {
        int abc = 3;
        balalaika.price = 300;
        return abc;
    }
}

//        Конец Примера _ КККККККККККККККК
 //  закончил видео мин 04 13


