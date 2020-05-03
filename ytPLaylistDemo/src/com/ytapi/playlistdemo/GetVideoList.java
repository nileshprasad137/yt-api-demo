package com.ytapi.playlistdemo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

public class GetVideoList {

    private static String getAPIUrl(final String playListID, final int maxResults) throws IOException, IllegalArgumentException {

        FileReader fileReader = new FileReader("project.properties");
        Properties properties = new Properties();
        properties.load(fileReader);

        String apiKey = properties.getProperty(Constants.API_KEY).trim();

        if(apiKey==null || apiKey.equals("") || apiKey.equals(Constants.API_KEY_PLACEHOLDER)){
            throw new IllegalArgumentException("PLEASE PUT YOUR API KEY IN project.properties FILE.");
        }

        String url = new APIUrl.URLBuilder(Constants.SNIPPET,Constants.PLAYLIST_ITEMS_ROOT_URL,apiKey,playListID)
                .withMaxResults(maxResults)
                .makeURL();

        return url;
    }

    public static ArrayList<YouTubeVideo> getPLayListVideos(final String playListID, final int maxResults){

        ArrayList<YouTubeVideo> youTubeVideos = new ArrayList<>();
        try {
            String apiURL = getAPIUrl(playListID,maxResults);
            JSONObject jsonResponse = getAPIResponse(apiURL);
            System.out.println(jsonResponse.toString());
            JSONArray yTVideoList = (JSONArray) jsonResponse.get(Constants.ITEMS);
            for(Object obj : yTVideoList){
                JSONObject ytVideoObject = (JSONObject)obj;
                JSONObject videoSnippet = (JSONObject)ytVideoObject.get(Constants.SNIPPET);
                String title = videoSnippet.get(Constants.TITLE).toString();
                String description = videoSnippet.get(Constants.DESCRIPTION).toString();
                YouTubeVideo youTubeVideo = new YouTubeVideo(title,description);
                youTubeVideos.add(youTubeVideo);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return youTubeVideos;
    }

    private static JSONObject getAPIResponse(String apiURL) throws IOException, ParseException {

        URL obj = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + apiURL);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject responseJSON = (JSONObject) new JSONParser().parse(response.toString());
        return responseJSON;

    }

    public static void main(String[] args) {
        ArrayList<YouTubeVideo> list = getPLayListVideos("PL26AWs0TLY3I9xCBnWR9Sv5QGI5hBZ1X1",0);
        for(YouTubeVideo video : list){
            System.out.println(video.getTitle());
        }

    }

}
