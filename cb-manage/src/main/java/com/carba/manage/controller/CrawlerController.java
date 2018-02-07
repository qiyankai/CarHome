package com.carba.manage.controller;

import com.carba.manage.service.AllService;
import com.carba.manage.service.EchartsService;
import com.carba.manage.service.XlService;

import com.carba.manage.utils.EchartsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CrawlerController {

    @Autowired
    private AllService allService;

    @Autowired
    private XlService xlService;

    @Autowired
    private EchartsService echartsService;

    @RequestMapping("/test")
    public String test(){

        return "test02";
    }
    @RequestMapping("/test01")
    public String test01(){
        return "test01";
    }


    @RequestMapping("/crawler")
    public void crawler(){
        allService.getMessage();
    }


    //1 2 3 7 10 12  13
    @RequestMapping("getJson")
    @ResponseBody
    public EchartsResult getJson(){

        List<String> nameLists = echartsService.selectCarName();
        List<Integer> numLists = echartsService.selectCarNum();
        String names = nameLists.toString();
        names = names.substring(1,names.length()-1);
        String nums = numLists.toString();
        nums = nums.substring(1,nums.length()-1);
        return new EchartsResult("2017年汽车销量","销量",names,
                "",nums);
    }



    @RequestMapping("getCar2016")
    @ResponseBody
    public EchartsResult getCar2016(){

        List<String> nameLists = echartsService.selectCarName2016();
        List<String> numLists = echartsService.selectCarNum2016();
        String names = nameLists.toString();
        names = names.substring(1,names.length()-1);
        String nums = numLists.toString();
        nums = nums.substring(1,nums.length()-1);
        return new EchartsResult("2016年汽车销量","销量",names,
                "",nums);
    }


    @RequestMapping("getSuv2017")
    @ResponseBody
    public EchartsResult getSuv2017(){

        List<String> nameLists = echartsService.selectSuvName2017();
        List<String> numLists = echartsService.selectSuvNum2017();
        String names = nameLists.toString();
        names = names.substring(1,names.length()-1);
        String nums = numLists.toString();
        nums = nums.substring(1,nums.length()-1);
        return new EchartsResult("2017年SUV销量","销量",names,
                "",nums);
    }

    @RequestMapping("getSuv2016")
    @ResponseBody
    public EchartsResult getSuv2016(){

        List<String> nameLists = echartsService.selectSuvName2016();
        List<String> numLists = echartsService.selectSuvNum2016();
        String names = nameLists.toString();
        names = names.substring(1,names.length()-1);
        String nums = numLists.toString();
        nums = nums.substring(1,nums.length()-1);
        return new EchartsResult("2016年SUV销量","销量",names,
                "",nums);
    }

}
