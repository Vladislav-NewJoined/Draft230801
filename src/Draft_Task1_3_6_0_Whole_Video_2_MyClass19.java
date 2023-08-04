import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Draft_Task1_3_6_0_Whole_Video_2_MyClass19 {   //  itunes ДжейСон JSON_2
    public static void main(String[] args) throws IOException {

        // userInput
        String term = getUserInput();

        // buildUrl
        String url = buildUrl(term);

        // downloadWebPage
        String page = downloadWebPage(url);

        // parseResult
        printResult(page);
        System.out.println(page); // целиком всю страницу не будем выводить

    }
    // Закончил: видео мин 42 46  (1-3_2) https://lms.synergy.ru/student/updiscipline/4474947/1045153/1/1

        static void/*String*/ /*parseResult*/printResult(String page) {
            // parseResult
//            int start = page.indexOf("kind") + 7;  // было /*kind*/
            int start = page.indexOf("wrapperType") + 14;  // было /*kind*/
            int end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
//        String sub =  page.substring(start + 7, end);  // это я дописал
            System.out.println(page.substring(start, end));
        }

        static String/*void*/ buildUrl (String partOfRequest) {
            // buildUrl
            String termWithoutSpaces = /*term*/partOfRequest.replaceAll(" ", "+");
            String itunesApi = "https://itunes.apple.com/search?term="; //  32 41
            String limitParametr = "&limit=1";
            String url = itunesApi + termWithoutSpaces + limitParametr; //  32 41
            return url;
        }

        static String/*void*/ getUserInput() {
            // userInput
            System.out.println("What you looking for in itunes?");
            Scanner scanner = new Scanner(System.in);
            String info /*term*/ = scanner.nextLine(); //  war of worlds
            return info;
        }













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