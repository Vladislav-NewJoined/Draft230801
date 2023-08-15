import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//        Пример _ ППППППППППППППППППППППППППППППППППП  ПЕРЕДЕЛАЛ В МЕТОД, СОДЕРЖАЩИЙ RETURN
//  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
public class Draft_Task1_3_7_5 {
    public static void main(String[] args) throws IOException {
        System.out.println("""
            Задание:\s
            5. Реализуйте метод, который возвращает случайную цитату Уолтера Уайта

            Решение:\s""");

        String page = downloadWeBPage("https://text-Box.ru/quotes/source/Breaking-Bad");

        getReturnQuote(page);
    }

    private static String getReturnQuote(String page) {
        int quoteStart = page.indexOf("text__line__content__rus text__line--cell");
        int quoteEnd = page.indexOf("text__footer");
        String returnQuote = "Возвращаемая цитата: \n" + page.substring(quoteStart + 43, quoteEnd - 82);
        System.out.println(returnQuote);

        return returnQuote;
    }

    private static String downloadWeBPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader Br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = Br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();

    }
}
//        Конец Примера _ КККККККККККККККК







////        Пример 1 ППППППППППППППППППППППППППППППППППП  СДЕЛАН ОКОНЧАТЕЛЬНО, ОТПРАВЛЕН В ЭТОМ ВИДЕ !!!!!
////  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
//public class Draft_Task1_3_7_5 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//            Задание:\s
//            5. Реализуйте метод, который возвращает случайную цитату Уолтера Уайта
//
//            Решение:\s""");
//
//        String page = downloadWeBPage("https://text-Box.ru/quotes/source/Breaking-Bad");
//        getReturnQuote(page);
//    }
//
//    private static void getReturnQuote(String page) {
//        int quoteStart = page.indexOf("text__line__content__rus text__line--cell");
//        int quoteEnd = page.indexOf("text__footer");
//        String returnQuote = page.substring(quoteStart + 43, quoteEnd - 82);
//
//        System.out.println("Возвращаемая цитата: ");
//        System.out.println(returnQuote);
//    }
//
//    private static String downloadWeBPage(String url) throws IOException {
//        StringBuilder result = new StringBuilder();
//        String line;
//        URLConnection urlConnection = new URL(url).openConnection();
//        try (InputStream is = urlConnection.getInputStream();
//             BufferedReader Br = new BufferedReader(new InputStreamReader(is))) {
//            while ((line = Br.readLine()) != null) {
//                result.append(line);
//            }
//        }
//        return result.toString();
//
//    }
//}
////        Конец Примера 1 КККККККККККККККК







