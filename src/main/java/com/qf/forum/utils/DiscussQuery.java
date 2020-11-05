package com.qf.forum.utils;
/*
 *   Author = Liewona
 *   Date = 2020/11/4 20:24
 */

public class DiscussQuery {

    private int page;
    private int limit;
    private String type;
    private String word;
    private int start;

    @Override
    public String toString() {
        return "DiscussQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", type='" + type + '\'' +
                ", word='" + word + '\'' +
                ", start=" + start +
                '}';
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void update() {
        this.start = (this.page - 1) * limit;
    }
}
