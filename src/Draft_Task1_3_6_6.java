import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


//        Пример _ ППППППППППППППППППППППППППППППППППП
public class Draft_Task1_3_6_6 {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Задание: \n6. Выведите все даты невисокосного года. В январе 31 день, феврале - 28, " +
                "\nдалее чередуется - в марте 31, в апреле 30...\n\nРешение: ");

        String dateBegin_NO_Format = "2022/12/31";

        for (int i = 0; i < 365; i++) {
            for (int a = 0; a < 10; a++) {
//                System.out.print((i+1) + " ");
                final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                final Date date = format.parse(dateBegin_NO_Format);
                final Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                String dateNext_NO_Format = format.format(calendar.getTime());
//            /*String dateNext_YES_Format */= dateBegin_NO_Format = dateNext_NO_Format; //  ОБРАТИТЬ ВНИМАНИЕ: КАК МОЖНО ЗАПИСЫВАТЬ
                String dateNext_YES_Format = dateBegin_NO_Format = dateNext_NO_Format;
                System.out.print(dateNext_YES_Format + " ");
                i++;
                if (i == 365) {
                    break;
                }
            }
            System.out.println();
            i = i - 1;
        }


//        for (int i = 0; i < 365; i++) {
//            for (int a = 0; a < 10; a++) {
////                System.out.print((i+1) + " ");
//                final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//                final Date date = format.parse(dateBegin_NO_Format);
//                final Calendar calendar = Calendar.getInstance();
//                calendar.setTime(date);
//                calendar.add(Calendar.DAY_OF_YEAR, 1);
//                String dateNext_NO_Format = format.format(calendar.getTime());
////            /*String dateNext_YES_Format */= dateBegin_NO_Format = dateNext_NO_Format; //  ОБРАТИТЬ ВНИМАНИЕ: КАК МОЖНО ЗАПИСЫВАТЬ
//                String dateNext_YES_Format = dateBegin_NO_Format = dateNext_NO_Format;
//                System.out.print(dateNext_YES_Format + " ");
//                i = i+1;
//                if (i == 365) {
//                    break;
//                }
//            }
//            if (i == 365) {
//                break;
//            }
//            i = i-1;
//            System.out.println();
//        }
    }

//    private static String dateFormat_Next(String dateNext_NO_Format) {
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
//        String dateNext_YES_Format = null;
//        try {
//            Date date2 = dt.parse(dateNext_NO_Format);
//            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//            dateNext_YES_Format = dt1.format(date2);
//            System.out.print(/*"Стала следующ. дата в цикле В ФОРМАТЕ: " + */dateNext_YES_Format + ", ");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return dateNext_YES_Format;
//    }
}
//        Конец Примера _ КККККККККККККККК










////        Пример 13 ППППППППППППППППППППППППППППППППППП  ВЫВОД В НЕСКОЛЬКО СТРОК. ПЕРЕНОС СТРОКИ ЧЕРЕЗ N ЭЛЕМЕНТОВ
//public class Draft_Task1_3_6_6 {
//    public static void main(String[] args) throws IOException, ParseException {
//        for(int i=1001;i< 1046;i++){
//        for(int a=0;a< 10;a++){
//        System.out.print(/*a*/i+" ");
//        i++;
//
//        if(i==1046){
//        break;
//        }
//
//        }
//        System.out.println();
//        i=i-1;
//        }
//    }
//}
////        Конец Примера 13 КККККККККККККККК










////        Пример 12 ППППППППППППППППППППППППППППППППППП Строки убрал, break добавить
////  Пример взят отсюда: https://www.youtube.com/watch?v=5V2lZpEeRlA  девушка на английском говорит
////  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
////  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00, НО ЗДЕСЬ БЕЗ ДАТЫ
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("Задание: \n7. Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
//                "нет слова “Earth”\n\nРешение: ");
//
//        String dateBegin_NO_Format = "2022/12/31";
//        for (int i = 0; i < 3; i++) {
//            System.out.println("ИТЕРАЦИЯ " + (i+1));
//
////            System.out.println("Было dateBegin_NO_Format: " + dateBegin_NO_Format);
//            dateFormat_Begin(dateBegin_NO_Format);  //  Форматируем дату
//
//            final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//            final Date date = format.parse(dateBegin_NO_Format);
//            final Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date);
//            calendar.add(Calendar.DAY_OF_YEAR, 1);
//            String dateNext_NO_Format = format.format(calendar.getTime());
////            System.out.println("Была следующ. дата в цикле НЕ В ФОРМАТЕ: " + dateNext_NO_Format);
//
//            String dateNext_YES_Format = dateFormat_Next(dateNext_NO_Format);
//
//            String pageNasaAsText = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14";
//            int urlBeginAsText = pageNasaAsText.lastIndexOf("date=");
//            String substringUrlAsText = pageNasaAsText.substring(urlBeginAsText + 5);
////            System.out.println(substringUrlAsText);
//            String pageNasaAsText_NEW = pageNasaAsText.replace(substringUrlAsText, dateNext_YES_Format);
////            System.out.println("Стала строка с подставленной датой: " + pageNasaAsText_NEW);
//
//            dateBegin_NO_Format = dateNext_NO_Format;
//
////            System.out.println(); //  перенос строки
//
//        String pageNasa = downloadWeBPage(pageNasaAsText_NEW); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream from = new URL(urlPhoto).openStream()) {
//            Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА ! Я подставил to И СТАЛА НУЖНА
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ, СЕЙЧАС ЭТА СТРОКА НЕ НУЖНА !
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        }
//
//        System.out.println("Сохранена картинка за дату: " + dateNext_YES_Format);
//
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
//        System.out.println("Пояснение к фотографии: \n" + explanation);
//
//        System.out.println();  //  перенос строки
//        }
//    }
//
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
//    private static void dateFormat_Begin(String dateBegin_NO_Format) {
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
//        try {
//            Date date = dt.parse(dateBegin_NO_Format);
//            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//            String dateBegin_YES_Format = dt1.format(date);
////            System.out.println("Стало dateBegin_YES_Format: " + dateBegin_YES_Format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
////        System.out.println(); //  перенос строки
//    }
//    private static String dateFormat_Next(String dateNext_NO_Format) {
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
//        String dateNext_YES_Format = null;
//        try {
//            Date date2 = dt.parse(dateNext_NO_Format);
//            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//            dateNext_YES_Format = dt1.format(date2);
////            System.out.println("Стала следующ. дата в цикле В ФОРМАТЕ: " + dateNext_YES_Format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    return dateNext_YES_Format;
//    }
//}
////        Конец Примера 12 КККККККККККККККК


////        Пример 11 ППППППППППППППППППППППППППППППППППП Работает, некоторые строки убрать и break добавить
////  Пример взят отсюда: https://www.youtube.com/watch?v=5V2lZpEeRlA  девушка на английском говорит
////  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
////  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00, НО ЗДЕСЬ БЕЗ ДАТЫ
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("Задание: \n7. Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
//                "нет слова “Earth”\n\nРешение: ");
//
//        String dateBegin_NO_Format = "2022/12/31";
//        for (int i = 0; i < 3; i++) {
//            System.out.println("ИТЕРАЦИЯ " + (i+1));
//
//            System.out.println("Было dateBegin_NO_Format: " + dateBegin_NO_Format);
//            dateFormat_Begin(dateBegin_NO_Format);  //  Форматируем дату
////            System.out.println("Стало dateBegin_YES_Format: " + dateBegin_YES_Format);
//
//            final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//            final Date date = format.parse(dateBegin_NO_Format);
//            final Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date);
//            calendar.add(Calendar.DAY_OF_YEAR, 1);
//            String dateNext_NO_Format = format.format(calendar.getTime());
//            System.out.println("Была следующ. дата в цикле НЕ В ФОРМАТЕ: " + dateNext_NO_Format);
//
//            String dateNext_YES_Format = dateFormat_Next(dateNext_NO_Format);
//
//            String pageNasaAsText = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14";
//            int urlBeginAsText = pageNasaAsText.lastIndexOf("date=");
//            String substringUrlAsText = pageNasaAsText.substring(urlBeginAsText + 5);
//            System.out.println(substringUrlAsText);
//            String pageNasaAsText_NEW = pageNasaAsText.replace(substringUrlAsText, dateNext_YES_Format);
//            System.out.println("Стала строка с подставленной датой: " + pageNasaAsText_NEW);
//
//            dateBegin_NO_Format = dateNext_NO_Format;
//
//            System.out.println(); //  перенос строки
//
//        String pageNasa = downloadWeBPage(pageNasaAsText_NEW); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream from = new URL(urlPhoto).openStream()) {
//            Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА ! Я подставил to И СТАЛА НУЖНА
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ, СЕЙЧАС ЭТА СТРОКА НЕ НУЖНА !
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        }
//
//        System.out.println("\n" + "Картинка сохранена!");
//
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
//        System.out.println("Пояснение к фотографии: \n" + explanation);
//
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
//    private static void dateFormat_Begin(String dateBegin_NO_Format) {
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
//        try {
//            Date date = dt.parse(dateBegin_NO_Format);
//            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//            String dateBegin_YES_Format = dt1.format(date);
//            System.out.println("Стало dateBegin_YES_Format: " + dateBegin_YES_Format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
////        System.out.println(); //  перенос строки
//    }
//    private static String dateFormat_Next(String dateNext_NO_Format) {
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
//        String dateNext_YES_Format = null;
//        try {
//            Date date2 = dt.parse(dateNext_NO_Format);
//            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//            dateNext_YES_Format = dt1.format(date2);
//            System.out.println("Стала следующ. дата в цикле В ФОРМАТЕ: " + dateNext_YES_Format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    return dateNext_YES_Format;
//    }
//}
////        Конец Примера 11 КККККККККККККККК


////        Пример 10 ППППППППППППППППППППППППППППППППППП ТЕСТ МЕТОДОВ И КЛАССОВ ГЛАВНОЕ!!!!!!!! ИЗ МЕТОДА НЕ main
////        В МЕТОД ТОЖЕ НЕ main.
////        ВСЕ ВРЕМЯ ССЫЛАЕТСЯ НА ПРЕДЫДУЩИЙ УРОК, Т.Е. НА 2-й - ЭТО УТОЧНИТЬ
////        Каким макаром взять переменную term,
////        которая появилась вообще в третьем методе. Доступность переменных из разных методов.
////        Module1_Tema3_Urok3 Области видимости переменной 0 50 21 - Важный момент, я понимаю, что Вы могли устать
////        а про про то как из метода в метод передавать переменнкю - видео мин 0 53 21
////        Разбивка НА ОТДЕЛЬНЫЕ МЕТОДЫ в т.ч. и sout:
////        Видео мин 33 51 Module1_Tema3_Urok2
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//
////        getUserInput();                                         //  5. Нажали Ctrl + Alt + M
////        String х = getUserInput();                              //  10. Назвали случайным x
//        String term = getUserInput();                           //  11. Переименовали с x на term
//        String urlNeSviazannaia = buildUrl(term);                                         //  17. 20. 20 - это добавили начало
//        System.out.println(urlNeSviazannaia);                 //  21.
//
//    }
//
//    static String buildUrl(String partOfRequest) {                                    //  13. Создали другой метод
////        String termWithoutSpaces = term.replaceAll(" ", "+");   //  1. Пошагово пишем  //  Перемещаем из методв main в метод buildUrl
//        String termWithoutSpaces = partOfRequest.replaceAll(" ", "+");   //  16. Переименовываем term в partOfRequest
//        System.out.println(termWithoutSpaces);                  //  12.    //  Перемещаем из методв main в метод buildUrl
//        String itunesApi = "http://itunes.apple.com/search?term="; // 14.  //  Перемещаем из методв main в метод buildUrl
//        String Limitparam = "&limit=1";                         //  15.  Перемещаем из методв main в метод buildUrl
//        String url = itunesApi + termWithoutSpaces + Limitparam;  //  18.
//        return url;                                             //  19.
//
//    }
//
////    private static void getUserInput() {                        //  5. Нажали Ctrl + Alt + M
//    /*private */static String getUserInput() {                          //  7.
//        System.out.print("What are you looking in iTunes? ");  //  2.  war of worlds
//        Scanner scanner = new Scanner (System.in);              //  3.
////        String term = scanner.nextLine(); //  war of worlds     //  6.
//        String info = scanner.nextLine(); //  war of worlds     //  8.  Переименовали. Сделали info, а не term
//        return info;                                            //  9.  Этим вытаскиваем из метода
//    }
//}
////        Конец Примера 10 КККККККККККККККК
////  закончил на мин 0 53 15  Module1_Tema3_Urok3 Области видимости переменной _Строка 29


////        Пример 9 ППППППППППППППППППППППППППППППППППП ТЕСТ МЕТОДОВ И КЛАССОВ Из метода не main в метод main.
////        Каким макаром взять переменную term,
////        которая появилась вообще в третьем методе. Доступность переменных из разных методов.
////        Module1_Tema3_Urok3 Области видимости переменной 0 50 21 - Важный момент, я понимаю, что Вы могли устать
////        а про про то как из метода в метод передавать переменнкю - видео мин 0 53 21
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//
////        getUserInput();                                         //  5. Нажали Ctrl + Alt + M
////        String х = getUserInput();                              //  10. Назвали случайным x
//        String term = getUserInput();                           //  11. Переименовали с x на term
//
//        String termWithoutSpaces = term.replaceAll(" ", "+");   //  1. Пошагово пишем
//        System.out.println(termWithoutSpaces);
//    }
//
////    private static void getUserInput() {                        //  5. Нажали Ctrl + Alt + M
//    private static String getUserInput() {                          //  7.
//        System.out.println("What are you looking in iTunes?");  //  2.
//        Scanner scanner = new Scanner (System.in);              //  3.
////        String term = scanner.nextLine(); //  war of worlds     //  4.  Переименовали. Сделали info, а не term
//        String info = scanner.nextLine(); //  war of worlds     //  8.
//        return info;                                            //  9.  Этим вытаскиваем из метода
//    }
//}
////        Конец Примера 9 КККККККККККККККК


////        Пример 8 ППППППППППППППППППППППППППППППППППП ТЕСТ МЕТОДОВ И КЛАССОВ с изменениями Виктора Сильнова
////  Тест как sout в отдельный класс вывести
////  Здесь видео мин 02 28 , предположительно , ВАЖНО! Как sout в качестве объекта класса в main класс вывести
////  Гоша Дударь https://www.youtuBe.com/watch?v=_GLnOwDEE_A&list=PL0lO_mIqDDFW2xXiWSfjT7hEdOUZHVNBK&index=14
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//
//        //  Далее про метод и имя ГОША ДУДАРЬ
//        //  package вот ТАК УКАЗЫВАТЬ: package com.company
//        System.out.println("От ГОШИ ДУДАРЯ: ");
//        Person vitia = new Person();
//        vitia.height = 120;  //  Если изменим ( не 180, а 120 ), то выведется 120
//        System.out.println(vitia.height);
//        Person vlad = new Person();
//        System.out.println(vlad.height);
//
////  Про метод и имя здесь: видео мин 08 00 Гоша Дударь https://www.youtuBe.com/watch?v=_GLnOwDEE_A&list=PL0lO_mIqDDFW2xXiWSfjT7hEdOUZHVNBK&index=14
////  Метод от класса отличается те, что в круглых скобках перраметр (его значение) указывать нужно.
//        vitia.say("George");
//        System.out.println(); //  перенос строки
//        //  Конец ГОША ДУДАРЬ
//
//        //  Далее про методы и доступность переменных внутри методов ВИКТОР СИЛЬНОВ
//        //  MoModule1_Tema3_Urok5 видео мин 36 31
////        StringBuilder result = new StringBuilder(); //  мы его создали внутри метода, а не как аргумент
//        System.out.println("От ВИКТОРА СИЛЬНОВА: ");
//        String page = "тестирование";
////        StringBuilder result = null;
//        extracted (page/*, result*/);
//    }
//
//    // Это метод, а не класс от ВИКТОРА СИЛЬНОВА
//    static StringBuilder extracted (String page/*, StringBuilder result*/) { // Это только метод, а не класс от ВИКТОРА СИЛЬНОВА
//        System.out.println(page.toUpperCase());
//
//        StringBuilder result = new StringBuilder();
//        result.append("This is a book.");
//        result.append(" Author is Hemingway.");
//        System.out.println(result);
//
//        return result;
//    }
//
//}
//class Person {  //  Если в отдельном файле, то надо писать public class
//    public int height = 180;
//    public void say (String name) {
//        System.out.println("Hello, " + name);
//    }
//}
////        Конец Примера 8 КККККККККККККККК


////        Пример 7 ППППППППППППППППППППППППППППППППППП ТЕСТ МЕТОДОВ И КЛАССОВ первая версия, до изменений Виктора Сильнова
////  Тест как sout в отдельный класс вывести
////  Здесь видео мин 02 28 , предположительно , ВАЖНО! Как sout в качестве объекта класса в main класс вывести
////  Гоша Дударь https://www.youtuBe.com/watch?v=_GLnOwDEE_A&list=PL0lO_mIqDDFW2xXiWSfjT7hEdOUZHVNBK&index=14
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//
//        //  Далее про метод и имя ГОША ДУДАРЬ
//        //  package вот ТАК УКАЗЫВАТЬ: package com.company
//        System.out.println("От ГОШИ ДУДАРЯ: ");
//        Person vitia = new Person();
//        vitia.height = 120;  //  Если изменим ( не 180, а 120 ), то выведется 120
//        System.out.println(vitia.height);
//        Person vlad = new Person();
//        System.out.println(vlad.height);
//
////  Про метод и имя здесь: видео мин 08 00 Гоша Дударь https://www.youtuBe.com/watch?v=_GLnOwDEE_A&list=PL0lO_mIqDDFW2xXiWSfjT7hEdOUZHVNBK&index=14
////  Метод от класса отличается те, что в круглых скобках перраметр (его значение) указывать нужно.
//        vitia.say("George");
//        System.out.println(); //  перенос строки
//        //  Конец ГОША ДУДАРЬ
//
//        //  Далее про методы и доступность переменных внутри методов ВИКТОР СИЛЬНОВ
//        //  MoModule1_Tema3_Urok5 видео мин 36 31
//        StringBuilder result = new StringBuilder();
//        System.out.println("От ВИКТОРА СИЛЬНОВА: ");
//        String page = "тестирование";
////        StringBuilder result = null;
//        extracted (page, result);
//    }
//
//    static void extracted (String page, StringBuilder result) { // Это только метод, а не класс
//        System.out.println(page.toUpperCase());
//
//        result.append("This is a book.");
//        result.append(" Author is Hemingway.");
//        System.out.println(result);
//    }
//
//}
//class Person {  //  Если в отдельном файле, то надо писать public class
//    public int height = 180;
//    public void say (String name) {
//        System.out.println("Hello, " + name);
//    }
//}
////        Конец Примера 7 КККККККККККККККК


////        Пример 5 ППППППППППППППППППППППППППППППППППП УДАЛОСЬ ПЕРЕФОРМАТИРОВАТЬ ДАТУ
////  Пример взят отсюда: https://www.youtube.com/watch?v=5V2lZpEeRlA  девушка на английском говорит
////  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
////  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00, НО ЗДЕСЬ БЕЗ ДАТЫ
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("Задание: \n.Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
//                "\nнет слова “Earth”\n\nРешение: ");
//
//        String date_s = "2022/03/15";
//        System.out.println("Было: " + date_s);
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
//        try {
//            Date date = dt.parse(date_s);
//            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//            String result = dt1.format(date);
//            System.out.println("Стало: " + result);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(); //  перенос строки
//
//        String dateBegin = "2022/12/31";
//        System.out.println("Была dateBegin: " + dateBegin);
//        final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//        final Date date = format.parse(dateBegin);
//        final Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_YEAR, 1);
//        String nextDateWrongFormat = format.format(calendar.getTime());
//        dateBegin = nextDateWrongFormat;
//        System.out.println(nextDateWrongFormat);
//        System.out.println("Стала dateBegin: " + dateBegin);
//
//        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14"); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream from = new URL(urlPhoto).openStream()) {
//            Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА !
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ !
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        }
//
//        System.out.println("\n" + "Картинка сохранена!");
//
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
//        System.out.println("Пояснение к фртографии: \n" + explanation);
//
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
////        Конец Примера 5 КККККККККККККККК


////        Пример 4 ППППППППППППППППППППППППППППППППППП УДАЛОСЬ ПОЛУЧИТЬ СЛЕДУЮЩУЮ ДАТУ
////  Пример взят отсюда: https://www.youtube.com/watch?v=5V2lZpEeRlA  девушка на английском говорит
////  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
////  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00, НО ЗДЕСЬ БЕЗ ДАТЫ
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("Задание: \n.Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
//                "\nнет слова “Earth”\n\nРешение: ");
//
//        String dateBegin = "2023-01-01";
//        String curDate2 = "2023/01/01";
//        final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//        final Date date = format.parse(curDate2);
//        final Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_YEAR, 1);
//        System.out.println(format.format(calendar.getTime()));
//
//        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14"); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream from = new URL(urlPhoto).openStream()) {
//            Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА !
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ !
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        }
//
//        System.out.println("\n" + "Картинка сохранена!");
//
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
//        System.out.println("Пояснение к фртографии: \n" + explanation);
//
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


////        Пример 3 ППППППППППППППППППППППППППППППППППП С ПЕРЕЗАПИСЬЮ С ЗАДАННОЙ ДАТОЙ !!!
////  Пример взят отсюда: https://www.youtube.com/watch?v=5V2lZpEeRlA  девушка на английском говорит
////  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
////  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00, НО ЗДЕСЬ БЕЗ ДАТЫ
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException {
//        System.out.println("Задание: \n.Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
//                "\nнет слова “Earth”\n\nРешение: ");
//
//
//        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2019-10-14"); //  ВОТ ЗДЕСЬ ЗАДАЕТСЯ ДАТА
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream from = new URL(urlPhoto).openStream()) {
//            Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА !
////            Files.copy(in, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ !
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        }
//
//        System.out.println("\n" + "Картинка сохранена!");
//
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
//        System.out.println("Пояснение к фртографии: \n" + explanation);
//
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
////        Конец Примера 3 КККККККККККККККК


////        Пример 2 ППППППППППППППППППППППППППППППППППП С ПЕРЕЗАПИСЬЮ
////  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
////  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException {
//        System.out.println("Задание: \n.Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
//                "\nнет слова “Earth”\n\nРешение: ");
//
//
//        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream from = new URL(urlPhoto).openStream()) {
//            Path to = Paths.get("photo.jpg");  //  ЕСЛИ БЕЗ ПЕРЕЗАПИСИ, ТО ЭТА СТРОЧКА НЕ НУЖНА !
////            Files.copy(in, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ !
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        }
//
//        System.out.println("\n" + "Картинка сохранена!");
//
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
//        System.out.println("Пояснение к фртографии: \n" + explanation);
//
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
////        Конец Примера 2 КККККККККККККККК


////        Пример 1 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_7_Photo_and_itunes_apple_NASA_РАБОТАЕТ_С_ДАТОЙ {
//    public static void main(String[] args) throws IOException {
//        System.out.println("Задание: \n.Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
//                "\nнет слова “Earth”\n\nРешение: ");
//
//
//        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream in = new URL(urlPhoto).openStream()) {
//            Files.copy(in, Paths.get("photo.jpg"));
//        }
//
//        System.out.println("\n" + "Картинка сохранена!");
//
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
//        System.out.println("Пояснение к фртографии: \n" + explanation);
//
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
//}//        Конец Примера 1 КККККККККККККККК







