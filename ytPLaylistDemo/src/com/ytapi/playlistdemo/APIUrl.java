package com.ytapi.playlistdemo;

public class APIUrl {

    public static class URLBuilder{
        private String part;
        private String playlistId;
        private int maxResults;
        private String apiKey;
        private String rootUrl;

        /**
         * Mandatory parameters for Youtube Playlist API URL.
         *
         * @param part
         * @param rootUrl
         * @param apiKey
         * @param playlistId
         */
        URLBuilder(String part, String rootUrl, String apiKey, String playlistId){
            this.part = part;
            this.rootUrl = rootUrl;
            this.apiKey = apiKey;
            this.playlistId = playlistId;
        }

        /**
         * Set Max Results in request url.
         *
         * @param maxResults
         * @return
         */
        public URLBuilder withMaxResults(int maxResults) {
            this.maxResults = maxResults;
            return this;
        }

        /**
         * Return the API URL
         * @return
         */
        public String makeURL() {
            /**
             * GET https://www.googleapis.com/youtube/v3/playlistItems
             * ?part=snippet&maxResults=50&playlistId=PL26AWs0TLY3I9xCBnWR9Sv5QGI5hBZ1X1&key=[YOUR_API_KEY]
             *
             */

            StringBuilder apiURL = new StringBuilder();
            apiURL.append(rootUrl);
            apiURL.append("?"+Constants.PART+"=");
            apiURL.append(part);
            if(maxResults!=0){
                apiURL.append("&"+Constants.MAX_RESULTS+"="+maxResults);
            }
            apiURL.append("&"+Constants.PLAYLIST_ID+"="+playlistId);
            apiURL.append("&"+Constants.KEY+"="+apiKey);

            return apiURL.toString();
        }


    }
}
