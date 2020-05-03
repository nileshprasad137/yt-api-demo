package com.ytapi.playlistdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import static com.ytapi.playlistdemo.DisplayVideoList.displayList;

public class PlayListVideoListDemo {
    public static void main(String[] args) throws Exception {
        if(args.length==0){
            System.out.println("Please provide YouTube Playlist ID as parameter1, and optionally" +
                    " maxResult as parameter2.");
        }
        else{
            String playListId = args[0];
            int maxResults = args[0]!=null?Integer.parseInt(args[0]):10;
            displayList(playListId);
        }


        call_me();


    }

    public static void call_me() throws Exception {
        String url = "https://www.googleapis.com/youtube/v3/playlistItems" +
                "?part=snippet" +
                "&playlistId=PL26AWs0TLY3I9xCBnWR9Sv5QGI5hBZ1X1" +
                "&key=AIzaSyCL8LjSuVqW5WdurVEZVXhImo6LOauXwN0";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response.toString());

        JSONObject obj2 = (JSONObject) new JSONParser().parse(response.toString());
        JSONArray items = (JSONArray) obj2.get("items");
        System.out.println((JSONObject)items.get(0));

    }

}
