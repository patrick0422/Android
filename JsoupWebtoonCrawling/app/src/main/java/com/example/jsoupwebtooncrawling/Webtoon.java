package com.example.jsoupwebtooncrawling;

import android.widget.ImageView;

import java.io.Serializable;

public class Webtoon implements Serializable {
    private String title;
    private String writer;
    private String star;
    private String thumbnailSrc;
    private String webtoonURL;

    public Webtoon() {}
    public Webtoon(String title, String writer, String star, String thumbnailSrc, String webtoonURL) {
        this.title = title;
        this.writer = writer;
        this.star = star;
        this.thumbnailSrc = thumbnailSrc;
        this.webtoonURL = webtoonURL;
    }

    public String Title() { return title; }
    public String Writer() { return writer; }
    public String Star() { return star; }
    public String ThumbnailSrc() { return thumbnailSrc; }
    public String WebtoonURL() { return webtoonURL; }

    @Override
    public String toString() {
        return "제목: " + title + ", 작가: " + writer + ", 별점: " + star;
    }
}
