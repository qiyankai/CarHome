package com.carba.web.controller;

import com.carba.common.service.HttpClientService;
import com.carba.web.utils.EchartsResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class IndexController {

    @Autowired
    private  HttpClientService client;

    private static final ObjectMapper MAPPER=new ObjectMapper();

	@RequestMapping("/car2017")
    @ResponseBody
	public EchartsResult getCar2017() throws Exception {

        EchartsResult echartsResult = null;
        String carData = client.doGet("http://localhost:8082/getJson","utf-8");

        echartsResult = MAPPER.readValue(carData,EchartsResult.class);
        System.out.println(echartsResult);
        return echartsResult;
    }

    @RequestMapping("/car2016")
    @ResponseBody
    public EchartsResult getCar2016() throws Exception {

        EchartsResult echartsResult = null;
        String carData = client.doGet("http://localhost:8082/getCar2016","utf-8");

        echartsResult = MAPPER.readValue(carData,EchartsResult.class);
        return echartsResult;
    }

    @RequestMapping("/suv2017")
    @ResponseBody
    public EchartsResult getSuv2017() throws Exception {

        EchartsResult echartsResult = null;
        String carData = client.doGet("http://localhost:8082/getSuv2017","utf-8");

        echartsResult = MAPPER.readValue(carData,EchartsResult.class);
        System.out.println(echartsResult);
        return echartsResult;
    }

    @RequestMapping("/suv2016")
    @ResponseBody
    public EchartsResult getSuv2016() throws Exception {

        EchartsResult echartsResult = null;
        String carData = client.doGet("http://localhost:8082/getSuv2016","utf-8");

        echartsResult = MAPPER.readValue(carData,EchartsResult.class);
        System.out.println(echartsResult);
        return echartsResult;
    }

}
