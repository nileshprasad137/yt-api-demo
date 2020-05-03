package com.ytapi.playlistdemo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetVideoList {

    private static String getAPIUrl(String playListID) throws IOException, IllegalArgumentException {

        FileReader fileReader = new FileReader("project.properties");
        Properties properties = new Properties();
        properties.load(fileReader);

        String apiKey = properties.getProperty(Constants.API_KEY).trim();

        if(apiKey==null || apiKey.equals("") || apiKey.equals(Constants.API_KEY_PLACEHOLDER)){
            throw new IllegalArgumentException("PLEASE PUT YOUR API KEY IN project.properties FILE.");
        }

        String url = new APIUrl.URLBuilder(Constants.SNIPPET,Constants.PLAYLIST_ITEMS_ROOT_URL,apiKey,playListID)
                .makeURL();

        return url;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getAPIUrl("PL26AWs0TLY3I9xCBnWR9Sv5QGI5hBZ1X1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
