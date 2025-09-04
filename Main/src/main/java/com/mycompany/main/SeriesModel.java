/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.main;

public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private String seriesAge;
    private String seriesNumberOfEpisodes;

    public SeriesModel(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getSeriesAge() {
        return seriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setSeriesAge(String seriesAge) {
        this.seriesAge = seriesAge;
    }

    public void setSeriesNumberOfEpisodes(String seriesNumberOfEpisodes) {
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    @Override
    public String toString() {
        return "ID: " + seriesId +
               ", Name: " + seriesName +
               ", Age Restriction: " + seriesAge +
               ", Episodes: " + seriesNumberOfEpisodes;
    }
}
