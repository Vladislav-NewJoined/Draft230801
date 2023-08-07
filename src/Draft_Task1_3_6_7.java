import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

//        Пример _ ППППППППППППППППППППППППППППППППППП
public class Draft_Task1_3_6_7 {
    public static void main(String[] args) throws IOException {
        System.out.println("Задание: \n.Сохраняйте снимки NASA с 1 января до того момента, пока в поле Explanation " +
                "\nнет слова “Earth”\n\nРешение: ");


        String pageNasa = downloadWeBPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        int urlBegin = pageNasa.lastIndexOf("url");
        int urlEnd = pageNasa.lastIndexOf("}");
        String urlPhoto = pageNasa.substring(urlBegin + 6, urlEnd - 1);
        try (InputStream in = new URL(urlPhoto).openStream()) {
            Files.copy(in, Paths.get("photo.jpg"));
        }

        System.out.println("\n" + "Картинка сохранена!");

        int explanationBegin = pageNasa.lastIndexOf("explanation");
        int explanationEnd = pageNasa.lastIndexOf("hdurl");
        String explanation = pageNasa.substring(explanationBegin + 14, explanationEnd - 3/* или 8, три - правильно */);
        System.out.println("Пояснение к фртографии: \n" + explanation);

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
}//        Конец Примера _ КККККККККККККККК







