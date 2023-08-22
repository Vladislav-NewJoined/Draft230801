//        Пример _ ППППППППППППППППППППППППППППППППППП
//  пример взят отсюда: javarush : https://javarush.com/groups/posts/mnogomernye-massivy#%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5,-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-%D0%B4%D0%B2%D1%83%D0%BC%D0%B5%D1%80%D0%BD%D1%8B%D1%85-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%B2
//  и отсюда: видео https://yandex.ru/video/preview/13700980576848701175

public class Draft_Task1_3_9_4 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                4. Создайте двумерный массив. Выведите его предпоследнюю строчку

                Решение:\s""");

        int[][] array = new int[7][7];
        int n = 0;

        System.out.println("Исходный массив целиком:");
        for (int i = 0; i < 7; i++) {  //идём по строкам
                for (int j = 0; j < 7; j++) {  //идём по столбцам
                    array[i][j] = n;
                        if (n <10) {
                    System.out.print(array[i][j] + "   "); //вывод элемента
                } else {
                            System.out.print(array[i][j] + "  "); //вывод элемента
                    }
                    n++;
            }
            System.out.println();  //перенос строки ради визуального сохранения табличной формы
        }

        System.out.println();  //перенос строки
        System.out.println("Предпоследняя строчка исходного массива:");
        int m = 35;
        for (int i = 5; i == 5; i++) {  //идём по строкам
                for (int j = 0; j < 7; j++) {  //идём по столбцам
                    array[i][j] = m;
//                        if (m <10) {
//                    System.out.print(array[i][j] + "   "); //вывод элемента
//                } else {
                            System.out.print(array[i][j] + "  "); //вывод элемента
//                    }
                    m++;
            }
            System.out.println();  //перенос строки ради визуального сохранения табличной формы
        }

    }
}
//        Конец Примера _ КККККККККККККККК






