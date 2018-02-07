package com.carba.manage.service;


import com.carba.manage.mapper.BrandMapper;
import com.carba.manage.mapper.CarMapper;
import com.carba.manage.mapper.SeriesMapper;
import com.carba.manage.pojo.Brand;
import com.carba.manage.pojo.Car;
import com.carba.manage.pojo.Series;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Service
public class AllService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SeriesMapper seriesMapper;

    @Autowired
    private CarMapper carMapper;



    public void getMessage() {


        //定义想要爬取数据的地址
        String url = "https://car.autohome.com.cn/zhaoche/pinpai/";
        //定义list存放要爬取的车系的url
        List<String > seriesList = new ArrayList<String>();
        //获取网页文本
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
        }
        //根据类名获取文本内容
        int brandId = 1000;
        Elements elementsByClass = doc.getElementsByClass("uibox-con");
        //遍历类的集合
        for (Element element : elementsByClass) {
            Brand brand = new Brand();
            //获取类的子标签数量
            int childNodeSize_1 = element.childNodeSize();
            //循环获取子标签内的内容
            for (int i = 0 ; i < childNodeSize_1 ; i++) {
                //获取品牌名称
                String pinpai = element.child(i).child(0).child(1).text();
                //输出获取内容看是否正确
                brand.setName(pinpai);
                brand.setId(brandId++);
                this.saveBrand(brand);
                //把车标图片保存到本地
                /**
                 * 因为每个品牌下有多个合资工厂
                 * 比如一汽大众和上海大众还有进口大众
                 * 所有需要循环获取合资工厂名称和旗下
                 * 车系
                 */

                //获取车系数量
                int childNodeSize_2 = element.child(i).child(1).child(0).childNodeSize();
                /**
                 * 获取标签下子标签数量
                 * 如果等于1则没有其他合资工厂
                 */
                int childNodeSize_3 = element.child(i).child(1).childNodeSize();
                if(childNodeSize_3==1){
                    Series series = new Series();
                    //循环获取车系信息
                    for (int j = 0; j < childNodeSize_2; j++) {
                        //获取车型
                        String chexi = element.child(i).child(1).child(0).child(j).child(0).child(0).text();
                        //获取车型的链接
                        String href = element.child(i).child(1).child(0).child(j).child(0).child(0).attr("href");
                        //拼接车型的链接
                        String carUrl = "https:"+href;
                        //拼接车辆的链接
                        String priceUrl = carUrl+"/price.html";
                        //获取车辆详细信息
                        getCar(priceUrl,series);
                        //获取车型图片
                        getImg(carUrl,series,brand,chexi);
                        seriesList.add(carUrl);
                    }
                }else{
                    /**
                     * 如果childNodeSize_3大于1
                     * 则有多个合资工厂
                     */
                    //分别获取各个合资工厂旗下车系
                    Series series = new Series();
                    for (int j = 0; j < childNodeSize_3; j++) {

                        int childNodeSize_4 = element.child(i).child(1).child(j).childNodeSize();
                        /**
                         * 如果j是单数则是合资工厂名称
                         * 否则是车系信息
                         */
                        int k = j%2;

                        if(k==0){
                            //获取合资工厂信息
                            String hezipinpai = element.child(i).child(1).child(j).child(0).text();
                            brand.setName(hezipinpai);
                            brand.setId(brandId++);
                            this.saveBrand(brand);
                        }else{
                            //int childNodeSize_5 = element.child(i).child(1).child(0).childNodeSize();
                            //循环获取合资工厂车系信息
                            for(int l = 0; l < childNodeSize_4; l++){
                                String chexi = element.child(i).child(1).child(j).child(l).child(0).child(0).text();
                                String href = element.child(i).child(1).child(j).child(l).child(0).child(0).attr("href");
                                String carUrl = "https:"+href;
                                String priceUrl = carUrl+"/price.html";
                                getCar(priceUrl,series);
                                getImg(carUrl,series,brand,chexi);
                                seriesList.add(carUrl);
                            }
                        }
                    }

                }
            }
        }
    }


    private  void saveBrand(Brand brand){
        brandMapper.saveBrand(brand);
    }

    private  void saveSeries(Series series){
        seriesMapper.saveSeries(series);
    }

    //保存车辆信息
    private  void saveCar(Car car) {
        carMapper.saveCar(car);
    }


    private  void saveImage(String urls,Series series,Brand brand) throws IOException {
        String saveImgPath = "D://imgs";
        saveImgPath = saveImgPath+"/"+brand.getName()+"/"+series.getSeriesName().replace(" ","");
        Document doc = Jsoup.connect(urls).get();
        //获取后缀为png和jpg的图片的元素集合
        Elements pngs = doc.select("img[src~=(?i)\\.(jpe?g)]");
        List<String> imageList = new ArrayList<String>();
        //遍历元素
        for(Element e : pngs){
            String src=e.attr("src");//获取img中的src路径
            //获取后缀名
            String imageName = src.substring(src.lastIndexOf("/") + 1,src.length());
            //连接url
            src= "https:"+src;
            URL url = new URL(src);
            URLConnection uri=url.openConnection();
            //获取数据流
            InputStream is=uri.getInputStream();
            //写入数据流
            File file = new File(saveImgPath);
            if(!file.exists()){
                file.mkdirs();
            }
            OutputStream os = new FileOutputStream(new File(file, imageName));
            byte[] buf = new byte[1024];
            int l=0;
            while((l=is.read(buf))!=-1){
                os.write(buf, 0, l);
            }
            imageList.add(saveImgPath+"/"+imageName);
        }
        String temp = imageList.toString();
        temp = temp.substring(1,temp.length()-1);
        series.setSeriesImage(temp);
    }



    private  void getImg(String  carUrl,Series series,Brand brand,String chexi){
        try {
            Document document = Jsoup.connect(carUrl).get();
            Element navTop = document.getElementById("navTop");
            // PriceTextByATag 代表爬取价格区间
            String priceTextByATag = null;
            try {
                priceTextByATag = document.select(".autoseries-info dl dt a").get(0).text();
            } catch (Exception e) {
            }
            if (priceTextByATag==null || "".equals(priceTextByATag)){
                priceTextByATag = "暂无报价";
            }
            series.setSeriesPriceRange(priceTextByATag);
            String imageUrl = null;

            try {
                series.setSeriesName(chexi);
                imageUrl ="https:"+ navTop.child(0).child(2).child(0).attr("href");
                saveImage(imageUrl,series,brand);
                series.setSeriesId(Integer.valueOf(carUrl.split("/")[3]));
                series.setSeriesBrandId(brand.getId());
                saveSeries(series);

            } catch (Exception e) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取汽车详细信息的element对象
    private  Elements gElements(String url){
        Elements elements = null;
        try {
            Document document = Jsoup.connect(url).get();
            elements = document.select(".interval01-list li");
        } catch (Exception e) {
        }
        return elements;
    }

    //获取车辆详细信息
    private  void getCar(String url,Series series){
        String name = null;
        String perf = null;
        String gPrice = null;
        try {
            Elements elements = gElements(url);
            Car car = new Car();
            int key = 0;
            for (Element element : elements) {
                name = element.select(".interval01-list-cars div p a").text();
                perf = element.select(".interval01-list-cars div p span").text();
                gPrice = element.select(".interval01-list-guidance div").text();
                car.setCarName(name);
                car.setCarInfo(perf);
                car.setCarPrice(gPrice);
                car.setCarSeriesId(series.getSeriesId());
                car.setCarId(new Integer(series.getSeriesId()+""+(key++)));
                this.saveCar(car);
            }
        } catch (Exception e) {
        }
    }


}
