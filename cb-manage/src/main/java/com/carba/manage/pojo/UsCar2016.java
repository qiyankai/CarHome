package com.carba.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "us_brand_2016")
public class UsCar2016 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String carType;
    private Integer sel2016;
    private Integer sel2015;
    private String zhangfu;

    @Override
    public String toString() {
        return "UsCar2016{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", sel2016='" + sel2016 + '\'' +
                ", sel2015='" + sel2015 + '\'' +
                ", zhangfu='" + zhangfu + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getSel2016() {
        return sel2016;
    }

    public void setSel2016(Integer sel2016) {
        this.sel2016 = sel2016;
    }

    public Integer getSel2015() {
        return sel2015;
    }

    public void setSel2015(Integer sel2015) {
        this.sel2015 = sel2015;
    }

    public String getZhangfu() {
        return zhangfu;
    }

    public void setZhangfu(String zhangfu) {
        this.zhangfu = zhangfu;
    }
}
