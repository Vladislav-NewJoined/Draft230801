import TestPrinterFor1_3_7_0.Printer;

public class MyClass23 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.maker = "HP";
        int x = 10;
        int y = 100;
        int abc = setPrinterPrice(printer);
        System.out.println(abc);

        setPrinterPrice(printer);
    }

    static int setPrinterPrice (Printer balalaika) {
        int abc = 3;
        balalaika.price = 300;
        return abc;
    }
}
