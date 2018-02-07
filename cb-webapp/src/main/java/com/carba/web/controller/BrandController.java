package com.carba.web.controller;

import java.util.Arrays;
import java.util.List;

import com.carba.web.pojo.Series;
import com.carba.web.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carba.web.pojo.Brand;
import com.carba.web.pojo.Car;
import com.carba.web.service.BrandService;
import com.carba.web.service.CarService;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CarService carService;

    @Autowired
    private SeriesService seriesService;

    @RequestMapping("/index")
    public String list(Model model) {
        List<Brand> brands = brandService.queryAll();
        model.addAttribute("Brands", brands);
        return "index";
    }

    @RequestMapping("/details")
    public String getCar(Model model, int carId) {
        List<Car> carInFos = carService.findcarsByCId(carId);
        String testStr = carService.findString(carId);
        model.addAttribute("query", testStr);
        model.addAttribute("carInfos", carInFos);
        return "details";
    }

    @RequestMapping("data")
    public String toRepair() {
        return "data";
    }

    @RequestMapping("/{seriesId}")
    public String getseries(Model model, @PathVariable int seriesId) {
        Series series = seriesService.findseriesById(seriesId);
        String[] imgs = series.getSeriesImage().split(",");
        List<String> list = Arrays.asList(imgs);
        List<Car> cars = carService.findcarsBySId(seriesId);
        String testStr = carService.findString(cars.get(0).getCarId());
        model.addAttribute("query", testStr);
        model.addAttribute("imgs", list);
        model.addAttribute("cars", cars);
        model.addAttribute("series", series);
        return "series";
    }

}
