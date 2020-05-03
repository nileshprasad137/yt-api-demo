package com.ytapi.playlistdemo;

import static com.ytapi.playlistdemo.DisplayVideoList.displayList;

public class PlayListVideoListDemo {
    public static void main(String[] args) throws Exception {
        if(args.length==0){
            System.out.println("Please provide YouTube Playlist ID as parameter1, and optionally" +
                    " maxResult as parameter2.");
        }
        else{
            String playListId = args[0];
            int maxResults = 0;
            if(args.length==2)
                maxResults = args[1]!=null?Integer.parseInt(args[0]):10;
            displayList(playListId,maxResults);
        }
    }
}
