/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author JoanMarc
 */
public class Video {

    private int id;
    private String title;
    private String author;
    private String creation_date;
    private String duration;
    private int views;
    private String description;
    private String format;
    private String url;
    private String uploader;

    public Video() {
    }

    public Video(int id, String title, String author, String creation_date, String duration, int views, String description, String format, String url, String uploader) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creation_date = creation_date;
        this.duration = duration;
        this.views = views;
        this.description = description;
        this.format = format;
        this.url = url;
        this.uploader = uploader;
    }

    @Override
    public String toString() {
        return id+",'"+title+"','"+author+"','"+creation_date+"','"+duration+"',"+views+",'"+description+"','"+format+"','"+url+"','"+uploader+"'";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
    
    
    
}
