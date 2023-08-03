import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MyClass19 {   //  itunes ДжейСон JSON_2
    public static void main(String[] args) throws IOException {
        System.out.println("What you looking for in itunes?");
//        String url = "https://itunes.apple.com/search?term=never+let+you+go&limit=1"; //  32 41
        // JSON BEAUTYFY  https://codebeautify.org/jsonviewer
//        String url = "https://itunes.apple.com/search?term=war+of+worlds&limit=1"; //  32 41
        String url = "https://itunes.apple.com/search?term=never+let+you+go&limit=1"; //  32 41
//        String url = "https://itunes.apple.com/search?term=Brad+Pitt&limit=1"; //  32 41
        String page = downloadWebPage(url);
        System.out.println(page);
        int start = page.indexOf("kind");
        int end = page.indexOf("\",", start);  //  ищем не с самого начала, а после start
        String sub =  page.substring(start + 7, end);
        System.out.println(page.substring(start + 7, end));
    }
    // Закончил: видео мин 42 46 https://lms.synergy.ru/student/updiscipline/4474947/1045153/1/1














    // ПОДПРОГРАММА, КОТОРАЯ ИЩЕТ ПО ОПРЕДЕЛЕННОМУ URL ИНФОРМАЦИЮ
    static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString(); // goto 13 line
    }
}