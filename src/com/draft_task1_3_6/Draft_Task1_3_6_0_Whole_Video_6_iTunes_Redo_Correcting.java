package com.draft_task1_3_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Draft_Task1_3_6_0_Whole_Video_6_iTunes_Redo_Correcting {   //  itunes ДжейСон JSON_2  //  видео мин 14 14 Давайте же попробуем изменить программу взаимодействия с ITunes
    public static void main(String[] args) throws IOException {
        String term = getUserInput();
        String url = buildUrl(term);
        String page = downloadWebPage(url);
          printResult(page);
    }

    static void/*String*/ /*parseResult*/printResult(String page) {
        StringBuilder result = buildMovieInformation(page); /*result.append("Unknown result: ");  result.append(page);*/
        System.out.println(result.toString());
    }

    static StringBuilder buildMovieInformation(String page) {
        int start, end;
        StringBuilder result = new StringBuilder();

        int moviesCount = 0;
        int currentMovieIndex = 0;
        while (moviesCount < 5) {
            currentMovieIndex = page.indexOf("feature-movie", currentMovieIndex + 20);

            start = page.indexOf("trackName", currentMovieIndex) + "trackName".length() + 3;  // было /*kind*/  kind + 7
            end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
            String movieName = page.substring(start, end);

            start = page.indexOf("primaryGenreName", currentMovieIndex) + "primaryGenreName".length() + 3;  // было /*kind*/  kind + 7
            end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
            String primaryGenreName = page.substring(start, end);

            start = page.indexOf("longDescription", currentMovieIndex) + "longDescription".length() + 3;  // было /*kind*/  kind + 7
            end = page.indexOf("\"", start); //  ищем не с самого начала, а после start
            String movieDescription = page.substring(start, end).replaceAll("<br />", "\n");

            if (primaryGenreName.equals("Comedy")) {
                result.append("Finally found comedy.\n");
                result.append(movieName);
                result.append("\nDescription\n");
                result.append(movieDescription);
                break;
            } else {
                result.append("This is a movie.\n");
                result.append(movieName);
                result.append("\nDescription\n");
                result.append(movieDescription + "\n");
                moviesCount++;
            }
        }
        return result;
    }

    private static String getKind(String page) {
        int end;
        int start;
        start = page.indexOf("kind") + "kind".length() + 3;  // было /*kind*/  kind + 7
        end = page.indexOf("\",", start); //  ищем не с самого начала, а после start
        String kind = page.substring(start, end);
        return kind;
    }

    static String/*void*/ buildUrl (String partOfRequest) {
        String termWithoutSpaces = /*term*/partOfRequest.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term="; //  32 41
        String limitParam = "&limit=300";
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


//  Прервался на мин 30 10 строка __ урок 1_3_6 https://lms.synergy.ru/student/updiscipline/4474947/1045153/1/1
//  Используемые материалы:
//  JSON Beautifier здесь:
//        JSON Beautifier_Best JSON Viewer and JSON Beautifier Online
//        https://codebeautify.org/jsonviewer
//
//        iTunes API здесь:
//        iTunes API_iTunes Search API: Overview
//        https://developer.apple.com/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/index.html




