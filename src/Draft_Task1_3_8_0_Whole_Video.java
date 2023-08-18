public class Draft_Task1_3_8_0_Whole_Video {
    public static void main(String[] args) {
        //  Module1_Tema3_Urok8 Перегрузка методов.
        //  видео мин 06 40 - внутри круглых скобок нажмите Ctrl + P
        //  про пакеты здесь: https://www.youtube.com/watch?v=-iEG-0g6CQ0
        //  закончил видео мин 09 21

//        Printer printer = new Printer();
        MaxValue_previous printer = new MaxValue_previous();
//        setPrinterPrice(printer, 300);
        setPrinterPrice(printer, 349.99);
        System.out.println(printer.price);
        }
//        static void setPrinterPrice(MaxValue_previous balalaika, int price) {
        static void setPrinterPrice(MaxValue_previous balalaika, double price) {
            price = price + 50;
            balalaika.price = price;
        }
}


//        MaxValue_previous printer = new MaxValue_previous();
//        System.out.println(printer.price);
//        setPrinterPrice(printer, "349.O");
//        setPrinterPrice(printer, 299);
//        setPrinterPrice(printer, 299.99);
//    }
//    static void setPrinterPrice(MaxValue_previous balalaika, double price) {
//    price += 50;
//    balalaika.price = price;
//}
//    static MaxValue_previous setPrinterPrice(MaxValue_previous printer, int price) {
//        price += 50;
//        printer.price = price:
//        return printer;
//}
//    static int setPrinterPrice (MaxValue_previous printer, String price) {
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
//class MaxValue_previous {
//
//}
