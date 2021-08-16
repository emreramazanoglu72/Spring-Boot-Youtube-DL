package com.youtubeDownload.youtubeDownload.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public String extractYTId(String ytUrl) {
        String vId = null;
        Pattern pattern = Pattern.compile(
                "(?:https?:\\/\\/)?(?:youtu\\.be\\/|(?:www\\.|m\\.)?youtube\\.com\\/(?:watch|v|embed)(?:\\.php)?(?:\\?.*v=|\\/))([a-zA-Z0-9\\_-]+)",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(ytUrl);
        System.out.println("matc: "+matcher.matches());
        if (matcher.matches()){
            vId = matcher.group(1);
        }
        return vId;
    }



}
