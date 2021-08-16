package com.youtubeDownload.youtubeDownload.Service;

import java.io.IOException;

public class YoutubeDownload {

    public static String download(String url) throws IOException {
        YoutubeDlExec dl = new YoutubeDlExec();
        return (String) dl.exec(url);
    }

    public static String videoSearch(String search, Integer limit) throws IOException {
        return YoutubeDlExec.search(search, limit);
    }
}
