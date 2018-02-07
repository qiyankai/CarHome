package com.carba.manage.controller;

import com.carba.manage.pojo.UsCar2016;
import com.carba.manage.service.XlService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class XlController {

    @Autowired
    private XlService xlService;

    @RequestMapping("/xl")
    public void xl() throws IOException {
        xlService.saveSelCar2017();
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getJson(){
        UsCar2016 usCar2016 = new UsCar2016();
        usCar2016.setCarType("福特");
        usCar2016.setSel2016(666);
        JSONObject jsonObject = new JSONObject();
        return "";
    }

}
