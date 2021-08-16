package com.youtubeDownload.youtubeDownload.Models;

public class VideoSearchModel {
    private String search;
    private Integer limit;

    public VideoSearchModel(String search, Integer limit) {
        this.search = search;
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
