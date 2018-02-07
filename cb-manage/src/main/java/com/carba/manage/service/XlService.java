package com.carba.manage.service;

import com.carba.manage.mapper.SelCar2017Mapper;
import com.carba.manage.pojo.SelCar2017;
import com.carba.manage.pojo.UsCar2016;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class XlService {

    /*
    http://www.qichexl.com/jiaoche/20180118_5538.html                    2017年轿车销量排行榜（全年）
    http://www.qichexl.com/a/xiaoliangpaixing/2018/0118/5539.html       2017年（全年）MPV销量排行榜
    http://www.qichexl.com/a/xiaoliangpaixing/2018/0118/5537.html       2017年SUV销量排行榜[全年]

    http://www.qichexl.com/a/xiaoliangpaixing/2017/0204/2075.html            美国2016全年汽车销量排行（含车型与品牌）
    http://www.qichexl.com/a/xiaoliangpaixing/2017/0125/2064.html           SUV销量排行榜2016年全部数据——前三均为国产


     */

    @Autowired
    private SelCar2017Mapper selCar2017Mapper;

    @Test
    public void saveSelCar2017() throws IOException {
        String url = "http://www.qichexl.com/a/xiaoliangpaixing/2017/0204/2075.html";
        Document document = Jsoup.connect(url).get();

        Element element = document.select("tbody").get(0);

        for (int i = 337; i < element.childNodeSize(); i++) {
            try {
                String flag = element.child(i).child(1).text().replace(" -品牌","").replace("/","");
                UsCar2016 usCar2016 = new UsCar2016();
                usCar2016.setCarType(flag.replace(" ",""));
                usCar2016.setSel2016(new Integer(element.child(i).child(2).text()));
                usCar2016.setSel2015(new Integer(element.child(i).child(3).text()));
                usCar2016.setZhangfu(element.child(i).child(4).text());
                selCar2017Mapper.saveSelCar2017(usCar2016);
            } catch (Exception e) {
                break;
            }
        }
    }

//    public void saveSelCar2017() throws IOException {
//
//        String url = "http://www.qichexl.com/jiaoche/20180118_5538.html";
//        Document document = Jsoup.connect(url).get();
//
//        Elements elements = document.select("tbody");
//
//        for (Element element : elements) {
//            for (int i = 1; i < element.childNodeSize(); i++) {
//                String text = null;
//                try {
//                    text = element.child(i).text();
//                    String[] msg = text.split(" ");
//                    SelCar2017 selCar2017 = new SelCar2017();
//                    selCar2017.setCarType(msg[1]);
//                    selCar2017.setSelNum(new Integer(msg[2]));
//                    selCar2017Mapper.saveSelCar2017(selCar2017);
//                } catch (Exception e) {
//                    break;
//                }
//            }
//        }
//
//    }

}
