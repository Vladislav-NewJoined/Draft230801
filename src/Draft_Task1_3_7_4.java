import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//        Пример _ ППППППППППППППППППППППППППППППППППП  СДЕЛАН ОКОНЧАТЕЛЬНО, ОТПРАВЛЕН В ЭТОМ ВИДЕ !!!!!
//  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
public class Draft_Task1_3_7_4 {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                Задание:\s
                4. Отрефакторите (улучшите читабельность) кода вашей реализации анализа
                   курса валют.\s

                Решение:\s""");
        String page = downloadWebPage("https://cbr.ru/scripts/XML_dynamic.asp?date_req1=01/11/2021&date_req2=13/11/2021&VAL_NM_RQ=R01235");

        getExchangeRates(page);
    }

    private static void getExchangeRates(String page) {
        int startIndex = page.lastIndexOf("<Value>");
        int endIndex = page.lastIndexOf("</Value>");
//        System.out.println(startIndex);
//        System.out.println(endIndex);
        String exchangeRate = page.substring(startIndex + 7, endIndex);
        System.out.println("При реализации метода getExchangeRates получен курс рубля к доллару на 13/11/2021: " + exchangeRate);
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
//        Конец Примера _ КККККККККККККККК








