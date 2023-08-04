import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MyClass22 {   //  itunes ДжейСон JSON_2
    public static void main(String[] args) throws IOException {
        String term = getUserInput();
        String url = buildUrl(term);
        String page = downloadWebPage(url);
        printResult(page);
    }

    static void/*String*/ /*parseResult*/printResult(String page) {
        int start = page.indexOf("wrapperType") + 14;  // было /*kind*/  kind + 7
        int end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
        System.out.println(page.substring(start, end));
    }

    static String/*void*/ buildUrl (String partOfRequest) {
        String termWithoutSpaces = /*term*/partOfRequest.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term="; //  32 41
        String limitParam = "&limit=1";
        StringBuilder url = new StringBuilder();
        url.append(termWithoutSpaces);
        url.append(itunesApi);
        url.append(limitParam);
        return url.toString();
    }

    static String/*void*/ getUserInput() {
        System.out.println("What you looking for in itunes?");
        Scanner scanner = new Scanner(System.in);
        String info /*term*/ = scanner.nextLine(); //  war of worlds
        return info;
    }

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

//  Закончил на 17 34