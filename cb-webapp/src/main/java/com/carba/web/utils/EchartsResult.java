package com.carba.web.utils;

import java.util.List;

public class EchartsResult {


    /*
    ECharts 入门示例
    ['销量']
    ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
    [5, 20, 36, 10, 10, 20]
     */

    private String title;
    private String legend;
    private String xAxis;
    private String yAxis;
    private String series;
    private List<String> seriesList;


    @Override
    public String toString() {
        return "EchartsResult{" +
                "title='" + title + '\'' +
                ", legend='" + legend + '\'' +
                ", xAxis='" + xAxis + '\'' +
                ", yAxis='" + yAxis + '\'' +
                ", series='" + series + '\'' +
                ", seriesList=" + seriesList +
                '}';
    }

    public EchartsResult() {
    }

    public EchartsResult(String title, String legend, String xAxis, String yAxis, String series) {
        this.title = title;
        this.legend = legend;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.series = series;
    }

//    public EchartsResult(String title, String legend, String xAxis, String series) {
//        this.title = title;
//        this.legend = legend;
//        this.xAxis = xAxis;
//        this.series = series;
//
//
//        List<String> list = new ArrayList<String>();
//        String[] name = xAxis.split(",");
//        String[] value = series.split(",");
//        String str = null;
//        for (int i = 0; i < name.length; i++) {
//            str = "{'name':"+name[i]+",'value':"+value[i]+"}";
//            list.add(str);
//        }
//        this.seriesList=list;
//    }

    public List<String> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<String> seriesList) {
        this.seriesList = seriesList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getxAxis() {
        return xAxis;
    }

    public void setxAxis(String xAxis) {
        this.xAxis = xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public void setyAxis(String yAxis) {
        this.yAxis = yAxis;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
