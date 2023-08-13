import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//        Пример _ ППППППППППППППППППППППППППППППППППП  СДЕЛАН ОКОНЧАТЕЛЬНО, ОТПРАВЛЕН В ЭТОМ ВИДЕ !!!!!
public class Draft_Task1_3_7_6 {
    public static void main(String[] args) throws IOException {
        System.out.println("""
            Задание:\s
            6. Реализуйте метод, который выводит explanation сегодняшнего снимка дня NASA

            Решение:\s""");

        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

        System.out.print("Вариант 1. С методом getExplanation, Пояснение к фотографии: \n");
        getExplanation();
        System.out.println();  //  перенос строки

        System.out.print("Вариант 2. С методом getExplanation2, Пояснение к фотографии: \n");
        String explanation = getExplanation2(pageNasa);
        System.out.println(explanation);
        System.out.println();  //  перенос строки

        System.out.print("Вариант 3. С методом getExplanation3, Пояснение к фотографии:\n"); getExplanation3(explanation/*, 3*/);
//        displayInt(28);
//        System.out.println();  //  перенос строки

//        System.out.print("Вариант 4. С методом getExplanation3, Пояснение к фотографии:\n"); getExplanation3("Для эксперимента вначале берём Tom"/*, 3*/);
//        displayInt(36);
    }

    /*private */static void getExplanation() throws IOException {
        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        int explanationBegin = pageNasa.lastIndexOf("explanation");
        int explanationEnd = pageNasa.lastIndexOf("hdurl");
        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3);
        System.out.println(explanation);
    }

    /*private */static String getExplanation2(String pageNasa) {
        int explanationBegin = pageNasa.lastIndexOf("explanation");
        int explanationEnd = pageNasa.lastIndexOf("hdurl");
        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3);

        return explanation;
    }

    static void getExplanation3(String explanation/*, int age*/){
        System.out.println(explanation/* + ", его возраст: " + age + "!"*/);
    }

//    static Integer displayInt(int age){
//        System.out.println(age);
//        return age;
//    }

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







////        Пример 1 ППППППППППППППППППППППППППППППППППП  //  Всё работает. Осталось убрать лишние строки.
////  Пример взят отсюда: https://www.youtube.com/watch?v=5V2lZpEeRlA  девушка на английском говорит
////  5 способов выполнения HTTP-запросов  https://javascopes.com/5-ways-to-make-http-requests-in-java-2p3-fca27bc8/
////  УТИЛИТА, КАК СКАЧАТЬ ФОТО NASA_Module1_Tema1_Urok9 видео мин 22.00, НО ЗДЕСЬ БЕЗ ДАТЫ
//public class Draft_Task1_3_7_6 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//                Задание:\s
//                6. Реализуйте метод, который выводит explanation сегодняшнего снимка дня NASA
//
//                Решение:\s""");
//
//
//        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
//        int urlBegin = pageNasa.lastIndexOf("url");
//        int urlEnd = pageNasa.lastIndexOf("}");
//        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
//        try (InputStream from = new URL(urlPhoto).openStream()) {
//            Path to = Paths.get("photo.jpg");
////            Files.copy(from, Paths.get("photo.jpg"));  //  ЭТО БЫЛО РАНЕЕ, БЕЗ ПЕРЕЗАПИСИ !
//            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
//        }
//
//        System.out.println("Картинка сохранена!");
//        System.out.println();  //  перенос строки
//
//        System.out.print("Вариант 1. С методом getExplanation, Пояснение к фотографии: \n");
//        getExplanation();
//        System.out.println();  //  перенос строки
//
//        System.out.print("Вариант 2. С методом getExplanation2, Пояснение к фотографии: \n");
//        String explanation = getExplanation2(pageNasa);
//        System.out.println(explanation);
//        System.out.println();  //  перенос строки
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////        String explanation = getExplanation3(pageNasa);
//        System.out.print("Вариант 3. С методом getExplanation4, Пояснение к фотографии:\n"); getExplanation4(explanation, 3);
//        displayInt(28);
//        System.out.println();  //  перенос строки
//
//        System.out.print("Вариант 4. С методом getExplanation4, Пояснение к фотографии:\n"); getExplanation4("Для эксперимента вначале берём Tom", 3);
//        displayInt(36);
////        System.out.println();  //  перенос строки
//
//    }
//
//    /*private */static void getExplanation() throws IOException {
//        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3);
//        System.out.println(explanation);
//    }
//
//    /*private */static String getExplanation2(String pageNasa) {
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
////        System.out.println(explanation);
//
//        return explanation;
//    }
//
//    /*private */static String getExplanation3(String pageNasa) {
//        int explanationBegin = pageNasa.lastIndexOf("explanation");
//        int explanationEnd = pageNasa.lastIndexOf("hdurl");
//        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
////        System.out.println(explanation);
//
//        return explanation;
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
//
//
//
//
//
//
//
//
//
//    static /*String*/ void getExplanation4(String explanation, int age){
//        System.out.println(explanation + ", его возраст: " + age + "!");
////        return explanation;
//    }
//
//    static Integer displayInt(int age){
//        System.out.println(age);
//        return age;
//    }
//}
////        Конец Примера 1 КККККККККККККККК







