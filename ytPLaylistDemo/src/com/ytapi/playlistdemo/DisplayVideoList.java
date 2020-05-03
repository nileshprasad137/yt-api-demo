package com.ytapi.playlistdemo;

import java.util.ArrayList;

public class DisplayVideoList {

    public static void displayList(final String playListId, final int maxResults){
        ArrayList<YouTubeVideo> list = GetVideoList.getPLayListVideos(playListId,maxResults);
        if(list.size()==0){
            System.out.println("Could not retrieve the list of Youtube videos.");
        }
        System.out.println("********************List of Videos********************************************");
        for(YouTubeVideo video : list){
            System.out.println(video.getTitle());
            System.out.println("---------------------------------------------------");
        }
        System.out.println("******************************************************************************");
    }
}
