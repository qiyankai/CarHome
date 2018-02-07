package com.carba.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 车系实体类
 */
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seriesId;
    private String seriesName;
    private int seriesBrandId;
    private String seriesPriceRange;
    private String seriesImage;


    @Override
    public String toString() {
        return "Series{" +
                "seriesId=" + seriesId +
                ", seriesName='" + seriesName + '\'' +
                ", seriesBrandId=" + seriesBrandId +
                ", seriesPriceRange='" + seriesPriceRange + '\'' +
                ", seriesImage='" + seriesImage + '\'' +
                '}';
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesBrandId() {
        return seriesBrandId;
    }

    public void setSeriesBrandId(int seriesBrandId) {
        this.seriesBrandId = seriesBrandId;
    }

    public String getSeriesPriceRange() {
        return seriesPriceRange;
    }

    public void setSeriesPriceRange(String seriesPriceRange) {
        this.seriesPriceRange = seriesPriceRange;
    }

    public String getSeriesImage() {
        return seriesImage;
    }

    public void setSeriesImage(String seriesImage) {
        this.seriesImage = seriesImage;
    }
}
