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

        // 1. wrapperType ->
        //
        //
        //
        //
        //
        //
        //
        //
    static void/*String*/ /*parseResult*/printResult(String page) {
        int start = page.indexOf("wrapperType") + 14;  // было /*kind*/  kind + 7
        int end = page.indexOf("\",", start); //  ищем не с самого начала, а после start

        StringBuilder result = new StringBuilder(); /*result.append("Unknown result: ");  result.append(page);*/
        String wrapperType = page.substring(start, end);  // System.out.println(page.substring(start, end));

        if (wrapperType.equals("audiobook")) {  /*audiobook*/  /*collection*/
            result = buildBookResult(page);
        } else if (wrapperType.equals("track")) {
            start = page.indexOf("kind") + "kind".length() + 3;  // было /*kind*/  kind + 7
            end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
            String kind = page.substring(start, end);
            if(kind.equals("song")) {

            } else if (kind.equals("feature-movie")) {

            }
        }

        if (result.length() == 0) {
             result.append("Unknown result: ");
             result.append(page);
        }

        System.out.println(result.toString());
    }

    private static StringBuilder buildBookResult(String page) {
        StringBuilder builder = new StringBuilder();
        int start;
        int end;
        start = page.indexOf("artistName") + 13;  // было /*kind*/  kind + 7
        end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
        String author = page.substring(start, end);

        start = page.indexOf("collectionName") + "collectionName".length() + 3;  // было /*kind*/  kind + 7
        end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
        String bookName = page.substring(start, end);

        start = page.indexOf("description") + "description".length() + 3;  // было /*kind*/  kind + 7
        end = page.indexOf("\"", start); //  ищем не с самого начала, а после start
        String bookDescription = page.substring(start, end)
                .replaceAll("<br /><br />", "\n");

        builder.append("This is a book. Author is ");
        builder.append(author);
        builder.append(".\nThe name is: ");
        builder.append(bookName);
        builder.append("\nDescription:\n");
        builder.append(bookDescription);
        return builder;
    }

    static String/*void*/ buildUrl (String partOfRequest) {
        String termWithoutSpaces = /*term*/partOfRequest.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term="; //  32 41
        String limitParam = "&limit=1";
        StringBuilder url = new StringBuilder();
        url.append(itunesApi);
        url.append(termWithoutSpaces);
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


//  Прервался на мин 40 49 строка 39 урок 1_3_5 https://lms.synergy.ru/student/updiscipline/4474947/1045153/1/1
//  Используемые материалы:
//  JSON Beautifier здесь:
//        JSON Beautifier_Best JSON Viewer and JSON Beautifier Online
//        https://codebeautify.org/jsonviewer
//
//        iTunes API здесь:
//        iTunes API_iTunes Search API: Overview
//        https://developer.apple.com/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/index.html
