import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.nio.file.Files.createFile;

//        Пример _ ППППППППППППППППППППППППППППППППППП  //  ПРОБУЮ СДЕЛАТЬ БЕЗ ПЕРЕЗАПИСИ
public class Draft_Task1_3_7_8 {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("""
            Задание:\s
            7. Реализуйте метод, который принимает два LocalDate, и сохраняет все
               снимки дня NASA в указанный промежуток

            Решение:\s""");

        Scanner scanner1 = new Scanner (System.in);
        System.out.print("Введите дату localDate1, в формате \"yyyy-MM-dd\", например 2019-10-14: ");
        String localDate1 = scanner1.nextLine();

        Scanner scanner2 = new Scanner (System.in);
        System.out.print("Введите более позднюю дату localDate2, в формате \"yyyy-MM-dd\", например 2019-10-18: ");
        String localDate2 = scanner2.nextLine();
        String localDateCount = localDate1;
        System.out.println(); //  перенос строки

//        String dateBegin_NO_Format = "2022/12/31";

        getExplanationsInPeriod(localDate1, localDate2, localDateCount);
    }

    private static void getExplanationsInPeriod(String localDate1, String localDate2, String localDateCount) throws ParseException, IOException {
        int i = 0;
        while (!localDateCount.equals(localDate2)) {
//            for (int i = 0; i < 4; i++) {
                System.out.println("ИТЕРАЦИЯ " + (i + 1));
                localDateCount = localDate1;

//            dateFormat_Begin(dateBegin_NO_Format);  //  Форматируем дату
//
                final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                final Date date = format.parse(localDate1);
                final Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_YEAR, 1);

//            localDate2 = localDate2;

                String pageNasaAsText = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14";
                int urlBeginAsText = pageNasaAsText.lastIndexOf("date=");
                String substringUrlAsText = pageNasaAsText.substring(urlBeginAsText + 5);
                String pageNasaAsText_NEW = pageNasaAsText.replace(substringUrlAsText, localDate1);

//            dateBegin_NO_Format = dateNext_NO_Format;

                String pageNasa = downloadWeBPage(pageNasaAsText_NEW); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
                int urlBegin = pageNasa.lastIndexOf("url");
                int urlEnd = pageNasa.lastIndexOf("}");
                String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
                try (InputStream from = new URL(urlPhoto).openStream()) {
//                    Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА ! Я подставил to И СТАЛА НУЖНА
//            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ, СЕЙЧАС ЭТА СТРОКА НЕ НУЖНА !
//                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(from, Paths.get("photo" + (i + 1) + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
                }

                System.out.println("Сохранена картинка за дату: " + localDate1);

                int explanationBegin = pageNasa.lastIndexOf("explanation");
                int explanationEnd = pageNasa.lastIndexOf("hdurl");
                String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3);
                System.out.println("Пояснение к фотографии: \n" + explanation);
                System.out.println("Переменная localDateCount = " + localDateCount);

                localDate1 = format.format(calendar.getTime());
//            if (explanation.contains("Earth")) {
//                System.out.println("Найдена первая фотография, у которой в поле Explanation есть слово “Earth”. " +
//                        "\nФотография сохранена. На этом программа закончена.");
//                break;
//            } else {
//                System.out.println("Фотографий с заданными условиями не найдено.");
//            }
                System.out.println();  //  перенос строки
//            }
            i++;
        }
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







////        Пример 4 ППППППППППППППППППППППППППППППППППП  //
//public class Draft_Task1_3_7_8 {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("""
//            Задание:\s
//            7. Реализуйте метод, который принимает два LocalDate, и сохраняет все
//               снимки дня NASA в указанный промежуток
//
//            Решение:\s""");
//
//        Scanner scanner1 = new Scanner (System.in);
//        System.out.print("Введите дату localDate1, в формате \"yyyy-MM-dd\", например 2019-10-14: ");
//        String localDate1 = scanner1.nextLine();
//
//        Scanner scanner2 = new Scanner (System.in);
//        System.out.print("Введите более позднюю дату localDate2, в формате \"yyyy-MM-dd\", например 2019-10-18: ");
//        String localDate2 = scanner2.nextLine();
//        String localDateCount = localDate1;
//        System.out.println(); //  перенос строки
//
////        String dateBegin_NO_Format = "2022/12/31";
//
//        getExplanationsInPeriod(localDate1, localDate2, localDateCount);
//    }
//
//    private static void getExplanationsInPeriod(String localDate1, String localDate2, String localDateCount) throws ParseException, IOException {
//        int i = 0;
//        while (!localDateCount.equals(localDate2)) {
////            for (int i = 0; i < 4; i++) {
//                System.out.println("ИТЕРАЦИЯ " + (i + 1));
//                localDateCount = localDate1;
//
////            dateFormat_Begin(dateBegin_NO_Format);  //  Форматируем дату
////
//                final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                final Date date = format.parse(localDate1);
//                final Calendar calendar = Calendar.getInstance();
//                calendar.setTime(date);
//                calendar.add(Calendar.DAY_OF_YEAR, 1);
//
////            localDate2 = localDate2;
//
//                String pageNasaAsText = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14";
//                int urlBeginAsText = pageNasaAsText.lastIndexOf("date=");
//                String substringUrlAsText = pageNasaAsText.substring(urlBeginAsText + 5);
//                String pageNasaAsText_NEW = pageNasaAsText.replace(substringUrlAsText, localDate1);
//
////            dateBegin_NO_Format = dateNext_NO_Format;
//
//                String pageNasa = downloadWeBPage(pageNasaAsText_NEW); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//                int urlBegin = pageNasa.lastIndexOf("url");
//                int urlEnd = pageNasa.lastIndexOf("}");
//                String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//                try (InputStream from = new URL(urlPhoto).openStream()) {
////                    Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА ! Я подставил to И СТАЛА НУЖНА
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ, СЕЙЧАС ЭТА СТРОКА НЕ НУЖНА !
////                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//                    Files.copy(from, Paths.get("photo_" + (i+1) + ".jpg"), StandardCopyOption.COPY_ATTRIBUTES);
//                }
//
//                System.out.println("Сохранена картинка за дату: " + localDate1);
//
//                int explanationBegin = pageNasa.lastIndexOf("explanation");
//                int explanationEnd = pageNasa.lastIndexOf("hdurl");
//                String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3);
//                System.out.println("Пояснение к фотографии: \n" + explanation);
//                System.out.println("Переменная localDateCount = " + localDateCount);
//
//                localDate1 = format.format(calendar.getTime());
////            if (explanation.contains("Earth")) {
////                System.out.println("Найдена первая фотография, у которой в поле Explanation есть слово “Earth”. " +
////                        "\nФотография сохранена. На этом программа закончена.");
////                break;
////            } else {
////                System.out.println("Фотографий с заданными условиями не найдено.");
////            }
//                System.out.println();  //  перенос строки
////            }
//            i++;
//        }
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
//    }
//}
////        Конец Примера 4 КККККККККККККККК







////        Пример 3 ППППППППППППППППППППППППППППППППППП  //  РАБОТАЕТ В ОТДЕЛЬНОМ МЕТОДЕ, СДЕЛАТЬ БЕЗ ПЕРЕЗАПИСИ
//public class Draft_Task1_3_7_8 {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("""
//            Задание:\s
//            7. Реализуйте метод, который принимает два LocalDate, и сохраняет все
//               снимки дня NASA в указанный промежуток
//
//            Решение:\s""");
//
//        Scanner scanner1 = new Scanner (System.in);
//        System.out.print("Введите дату localDate1, в формате \"yyyy-MM-dd\", например 2019-10-14: ");
//        String localDate1 = scanner1.nextLine();
//
//        Scanner scanner2 = new Scanner (System.in);
//        System.out.print("Введите более позднюю дату localDate2, в формате \"yyyy-MM-dd\", например 2019-10-18: ");
//        String localDate2 = scanner2.nextLine();
//        String localDateCount = localDate1;
//        System.out.println(); //  перенос строки
//
////        String dateBegin_NO_Format = "2022/12/31";
//
//        getExplanationsInPeriod(localDate1, localDate2, localDateCount);
//    }
//
//    private static void getExplanationsInPeriod(String localDate1, String localDate2, String localDateCount) throws ParseException, IOException {
//        int i = 0;
//        while (!localDateCount.equals(localDate2)) {
////            for (int i = 0; i < 4; i++) {
//                System.out.println("ИТЕРАЦИЯ " + (i + 1));
//                localDateCount = localDate1;
//
////            dateFormat_Begin(dateBegin_NO_Format);  //  Форматируем дату
////
//                final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                final Date date = format.parse(localDate1);
//                final Calendar calendar = Calendar.getInstance();
//                calendar.setTime(date);
//                calendar.add(Calendar.DAY_OF_YEAR, 1);
//
////            localDate2 = localDate2;
//
//                String pageNasaAsText = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14";
//                int urlBeginAsText = pageNasaAsText.lastIndexOf("date=");
//                String substringUrlAsText = pageNasaAsText.substring(urlBeginAsText + 5);
//                String pageNasaAsText_NEW = pageNasaAsText.replace(substringUrlAsText, localDate1);
//
////            dateBegin_NO_Format = dateNext_NO_Format;
//
//                String pageNasa = downloadWeBPage(pageNasaAsText_NEW); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//                int urlBegin = pageNasa.lastIndexOf("url");
//                int urlEnd = pageNasa.lastIndexOf("}");
//                String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//                try (InputStream from = new URL(urlPhoto).openStream()) {
//                    Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА ! Я подставил to И СТАЛА НУЖНА
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ, СЕЙЧАС ЭТА СТРОКА НЕ НУЖНА !
//                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//                }
//
//                System.out.println("Сохранена картинка за дату: " + localDate1);
//
//                int explanationBegin = pageNasa.lastIndexOf("explanation");
//                int explanationEnd = pageNasa.lastIndexOf("hdurl");
//                String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3);
//                System.out.println("Пояснение к фотографии: \n" + explanation);
//                System.out.println("Переменная localDateCount = " + localDateCount);
//
//                localDate1 = format.format(calendar.getTime());
////            if (explanation.contains("Earth")) {
////                System.out.println("Найдена первая фотография, у которой в поле Explanation есть слово “Earth”. " +
////                        "\nФотография сохранена. На этом программа закончена.");
////                break;
////            } else {
////                System.out.println("Фотографий с заданными условиями не найдено.");
////            }
//                System.out.println();  //  перенос строки
////            }
//            i++;
//        }
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
//    }
//
////    private static void dateFormat_Begin(String dateBegin_NO_Format) {
////        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
////        try {
////            Date date = dt.parse(dateBegin_NO_Format);
////            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
////            String dateBegin_YES_Format = dt1.format(date);
//////            System.out.println("Стало dateBegin_YES_Format: " + dateBegin_YES_Format);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//////        System.out.println(); //  перенос строки
////    }
//
////    private static String dateFormat_Next(String dateNext_NO_Format) {
////        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
////        String dateNext_YES_Format = null;
////        try {
////            Date date2 = dt.parse(dateNext_NO_Format);
////            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
////            dateNext_YES_Format = localDate1;
//////            System.out.println("Стала следующ. дата в цикле В ФОРМАТЕ: " + dateNext_YES_Format);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////        return dateNext_YES_Format;
////    }
//
//}
////        Конец Примера 3 КККККККККККККККК







////        Пример 2 ППППППППППППППППППППППППППППППППППП  //  РАБОТАЕТ, ВЫВЕСТИ РЕЗУЛЬТАТ В ОТДЕЛЬНЫЙ МЕТОД, убрать лишние строки
//public class Draft_Task1_3_7_8 {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("""
//            Задание:\s
//            7. Реализуйте метод, который принимает два LocalDate, и сохраняет все
//               снимки дня NASA в указанный промежуток
//
//            Решение:\s""");
//
//        Scanner scanner1 = new Scanner (System.in);
//        System.out.print("Введите дату localDate1, в формате \"yyyy-MM-dd\", например 2019-10-14: ");
//        String localDate1 = scanner1.nextLine();
//
//        Scanner scanner2 = new Scanner (System.in);
//        System.out.print("Введите более позднюю дату localDate2, в формате \"yyyy-MM-dd\", например 2019-10-18: ");
//        String localDate2 = scanner2.nextLine();
//        String localDateCount = localDate1;
//        System.out.println(); //  перенос строки
//
////        String dateBegin_NO_Format = "2022/12/31";
//
//        int i = 0;
//        while (!localDateCount.equals(localDate2)) {
////            for (int i = 0; i < 4; i++) {
//                System.out.println("ИТЕРАЦИЯ " + (i + 1));
//                localDateCount = localDate1;
//
////            dateFormat_Begin(dateBegin_NO_Format);  //  Форматируем дату
////
//                final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                final Date date = format.parse(localDate1);
//                final Calendar calendar = Calendar.getInstance();
//                calendar.setTime(date);
//                calendar.add(Calendar.DAY_OF_YEAR, 1);
//
////            localDate2 = localDate2;
//
//                String pageNasaAsText = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14";
//                int urlBeginAsText = pageNasaAsText.lastIndexOf("date=");
//                String substringUrlAsText = pageNasaAsText.substring(urlBeginAsText + 5);
//                String pageNasaAsText_NEW = pageNasaAsText.replace(substringUrlAsText, localDate1);
//
////            dateBegin_NO_Format = dateNext_NO_Format;
//
//                String pageNasa = downloadWeBPage(pageNasaAsText_NEW); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//                int urlBegin = pageNasa.lastIndexOf("url");
//                int urlEnd = pageNasa.lastIndexOf("}");
//                String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//                try (InputStream from = new URL(urlPhoto).openStream()) {
//                    Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА ! Я подставил to И СТАЛА НУЖНА
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ, СЕЙЧАС ЭТА СТРОКА НЕ НУЖНА !
//                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//                }
//
//                System.out.println("Сохранена картинка за дату: " + localDate1);
//
//                int explanationBegin = pageNasa.lastIndexOf("explanation");
//                int explanationEnd = pageNasa.lastIndexOf("hdurl");
//                String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3);
//                System.out.println("Пояснение к фотографии: \n" + explanation);
//                System.out.println("Переменная localDateCount = " + localDateCount);
//
//                localDate1 = format.format(calendar.getTime());
////            if (explanation.contains("Earth")) {
////                System.out.println("Найдена первая фотография, у которой в поле Explanation есть слово “Earth”. " +
////                        "\nФотография сохранена. На этом программа закончена.");
////                break;
////            } else {
////                System.out.println("Фотографий с заданными условиями не найдено.");
////            }
//                System.out.println();  //  перенос строки
////            }
//            i++;
//        }
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
//    }
//
////    private static void dateFormat_Begin(String dateBegin_NO_Format) {
////        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
////        try {
////            Date date = dt.parse(dateBegin_NO_Format);
////            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
////            String dateBegin_YES_Format = dt1.format(date);
//////            System.out.println("Стало dateBegin_YES_Format: " + dateBegin_YES_Format);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//////        System.out.println(); //  перенос строки
////    }
//
////    private static String dateFormat_Next(String dateNext_NO_Format) {
////        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
////        String dateNext_YES_Format = null;
////        try {
////            Date date2 = dt.parse(dateNext_NO_Format);
////            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
////            dateNext_YES_Format = localDate1;
//////            System.out.println("Стала следующ. дата в цикле В ФОРМАТЕ: " + dateNext_YES_Format);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////        return dateNext_YES_Format;
////    }
//
//}
////        Конец Примера 1 КККККККККККККККК







