package com.ytapi.playlistdemo;

public final class Constants {

    private Constants(){}

    /**
     * URLS
     */
    public static final String PLAYLIST_ITEMS_ROOT_URL = "https://www.googleapis.com/youtube/v3/playlistItems";

    /**
     * MANDATORY PARAMETERS
     */
    public static final String SNIPPET = "snippet";
    public static final String PART = "part";
    public static final String CONTENT_DETAILS = "contentDetails";
    public static final String PLAYLIST_ID = "playlistId";
    public static final String KEY = "key";

    /**
     * OPTIONAL PARAMETERS
     */
    public static final String MAX_RESULTS = "maxResults";
    public static final String PAGE_TOKEN = "pageToken";

    /**
     * MISCELLANEOUS
     */
    public static final String API_KEY = "apiKey";
    public static final String API_KEY_PLACEHOLDER = "YOUR_API_KEY";



}
