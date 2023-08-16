public class Draft_Task1_3_8_0_Whole_Video_2_Peregruzka_metodov {
    public static void main(String[] args) {
        //  Module1_Tema3_Urok8 Перегрузка методов.
        //  видео мин 06 40 - внутри круглых скобок нажмите Ctrl + P
        //  ПРО ПАКЕТЫ ЗДЕСЬ: https://www.youtube.com/watch?v=-iEG-0g6CQ0
        //  закончил видео мин 08 55 но список аргументов должен быть разным, хотя бы в чём то должен отличаться
        //  закончил видео мин 09 21

//        Printer printer = new Printer();
        PrinterMfu printer = new PrinterMfu();
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
//        static void setPrinterPrice(PrinterMfu balalaika, int price) {
    static void setPrinterPrice(PrinterMfu balalaika, double price) {
        price = price + 50;
        balalaika.price = price;
    }

//    static void setPrinterPriceInt(PrinterMfu printer, int price) {
    static void setPrinterPrice(PrinterMfu printer, int price) {
        price = price + 50;
        printer.price = price;
    }

//    static void setPrinterPriceString (PrinterMfu printer, String price) {
    static void setPrinterPrice (PrinterMfu printer, String price) {
        double priceDouble = Double.parseDouble(price);
        priceDouble += 50;
        printer.price = 50;
    }
}

class PrinterMfu {
    String maker;
    double price;
}



//        PrinterMfu printer = new PrinterMfu();
//        System.out.println(printer.price);
//        setPrinterPrice(printer, "349.O");
//        setPrinterPrice(printer, 299);
//        setPrinterPrice(printer, 299.99);
//    }
//    static void setPrinterPrice(PrinterMfu balalaika, double price) {
//    price += 50;
//    balalaika.price = price;
//}
//    static PrinterMfu setPrinterPrice(PrinterMfu printer, int price) {
//        price += 50;
//        printer.price = price;
//        return printer;
//}
//    static int setPrinterPrice (PrinterMfu printer, String price) {
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
//class PrinterMfu {
//
//}
