package com.videos;

import java.util.List;

public class Video
{

    protected List<String> videoTags;

    protected Integer videoId;
    protected String url;
    protected String videoTitle;
    protected String videoUser;

    public Video(Integer videoId,
                 String url,
                 String videoTitle,
                 String videoUser,
                 List<String> videoTags)
    {
        this.videoId = videoId;
        this.url = url;
        this.videoTitle = videoTitle;
        this.videoUser = videoUser;
        this.videoTags = videoTags;
    }

    // Check title of Video

    public String getVideoUrl()
    {
        return videoTitle.replace(" ", "-");
    }

    // Create a method for write like us we want the personalize URL

    public String urlToString()
    {
        return "Information of video ID = " + videoId + ", video title = " + videoTitle + ", video url = " + url + this.getVideoUrl() + ", tags for this video: " + videoTags;
    }
}