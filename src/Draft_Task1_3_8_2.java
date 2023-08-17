public class Draft_Task1_3_8_2 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                2. Реализуйте методы and(boolean a, boolean y), and(boolean a, int y), and(int a,
                       boolean y), который будет возвращать логическое И. Целые числа равные 0
                       трактовать как false, остальные true

                Решение:\s""");

        int a = 5;
        boolean x = true;
        getLogicalOperator(5, x);
        System.out.println(x);
    }
    static boolean getLogicalOperator (int a, boolean x) {
        if (a == 0) {
            x = true;
            return x;
        }
        x = false;
        return x;
    }




//        CalculateOps calculateOps=new CalculateOps();
//        calculateOps.add(5);  // это вызовет метод первого целочисленного параметра
//        calculateOps.add(5.5f);  // это вызовет первый метод параметра с плавающей запятой
//        calculateOps.add(6,6.6f);  // это вызовет первый метод параметра с плавающей запятой


//    }
}
//class CalculateOps{
//    public void add(int x) {
//        // реализация метода для int
//        System.out.println(x);
//        System.out.println();  //  перенос строки
//    }
//
//    public void add(float x) {
//        // реализация метода для float
//        System.out.println(x);
//        System.out.println();  //  перенос строки
//    }
//    public void add(int x,float y) {
//        // реализация метода для int и float
//        System.out.println(x + " и " + y);
//        System.out.println();  //  перенос строки
//    }
//}
