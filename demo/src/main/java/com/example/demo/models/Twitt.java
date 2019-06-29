package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@NoArgsConstructor
@Document(indexName = "tweets", type = "tweets",shards = 2)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Twitt {

    @Id
    private Long id;
    private String text;
    private String lang;
    private User user;
    private String country;
    private String countryCode;
    private String state;
    private Double geoLatitude;
    private Double geoLongitude;

    @SerializedName("retweet_count")
    private int retweetCount;

    @SerializedName("favorite_count")
    private int favoriteCount;

    public Twitt(Long id, String text, String lang, User user, int retweetCount, int favoriteCount, String country, String countryCode, String state, Double geoLatitude, Double geoLongitude) {
        this.id = id;
        this.text = text;
        this.lang = lang;
        this.user = user;
        this.retweetCount = retweetCount;
        this.favoriteCount = favoriteCount;
        this.country = country;
        this.countryCode = countryCode;
        this.state = state;
        this.geoLatitude = geoLatitude;
        this.geoLongitude = geoLongitude;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getCountry() { return country; }

    public String getCountryCode() { return countryCode; }

    public String getState() { return state; }

    public Double getGeoLatitude() { return geoLatitude; }

    public Double getGeoLongitude() { return geoLongitude; }

    public void setCountry(String country) { this.country = country; }

    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public void setState(String state) { this.state = state; }

    public void setGeoLatitude(Double geoLatitude) { this.geoLatitude = geoLatitude; }

    public void setGeoLongitude(Double geoLongitude) { this.geoLongitude = geoLongitude; }

}