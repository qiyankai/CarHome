package com.carba.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sel_car_2017")
public class SelCar2017 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String carType;
    private Integer selNum;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getSelNum() {
        return selNum;
    }

    public void setSelNum(Integer selNum) {
        this.selNum = selNum;
    }

    @Override
    public String toString() {
        return "SelCar2017{" +
                "carType='" + carType + '\'' +
                ", selNum=" + selNum +
                '}';
    }
}
