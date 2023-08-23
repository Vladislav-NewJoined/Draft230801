//        Пример _ ППППППППППППППППППППППППППППППППППП
//  пример взят отсюда: javarush : https://javarush.com/groups/posts/mnogomernye-massivy#%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5,-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-%D0%B4%D0%B2%D1%83%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D1%85-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%B2
//  и отсюда: видео https://yandex.ru/video/preview/13700980576848701175
//  пример взят отсюда: видеоурок мин 04 13

public class Draft_Task1_3_9_3 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                3. Создайте двумерный массив, задайте для него значения, выведите его элементы

                Решение:\s""");

        System.out.println();  //перенос строки
        System.out.println("Создаём двумерный массив 7х7 элементов, имя массива testArray:");
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("[ ]" + " ");
            }
            System.out.println();
        }
        System.out.println();  //перенос строки

        int[][] testArray = new int[7][7];
        int n = 0;

        System.out.println("Заполняем массив элементами:");
        for (int i = 0; i < 7; i++) {  //идём по строкам
                for (int j = 0; j < 7; j++) {  //идём по столбцам
                    testArray[i][j] = n;
                        if (n <10) {
                    System.out.print(testArray[i][j] + "   "); //вывод элемента
                } else {
                            System.out.print(testArray[i][j] + "  "); //вывод элемента
                    }
                    n+=2;
            }
            System.out.println();  //перенос строки ради визуального сохранения табличной формы
        }
    }
}
//        Конец Примера _ КККККККККККККККК






