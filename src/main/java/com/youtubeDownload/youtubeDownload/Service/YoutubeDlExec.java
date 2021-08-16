package com.youtubeDownload.youtubeDownload.Service;

import com.youtubeDownload.youtubeDownload.Utils.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoutubeDlExec {

    public static String search(String key, Integer limit) throws IOException {
        if (limit == null) {
            limit = 5;
        }
        String cmd = "youtube-dl --dump-json ytsearch" + limit + ":" + key;
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        String res = "";
        while ((line = buf.readLine()) != null) {
            res += line + ",";
        }
        return "[" + res.substring(0, res.length() - 1) + "]";
    }

    public Object exec(String url) throws IOException {
        Util util = new Util();
        var id = util.extractYTId(url);
        if (id != null) {
            String cmd = "youtube-dl  --dump-json " + url;
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            String res = "";
            while ((line = buf.readLine()) != null) {
                res += line;
            }
            return res;
        } else {
            
            return "false";
        }

    }

}
