package com.youtubeDownload.youtubeDownload.Models;

public class Response {
    private Integer totalRecord;

    private Object resulSet;

    public Object getResulSet() {
        return resulSet;
    }

    public void setResulSet(Object resulSet) {
        this.resulSet = resulSet;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }
}
