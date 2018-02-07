<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>CarB汽车</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/data.css" rel="stylesheet" type="text/css" media="all"/>
    <!--image slider-->
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script src="js/echarts.common.min.js"></script>
    <script src="js/echarts.js"></script>
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery.min.js"></script>
</head>
<body>
<div class="wrap">
    <div class="header">
        <div class="clear"></div>
        <div class="h_main">
            <ul class=".header">
                <li><a href="/index">主页</a></li>
                <li><a href="/data">数据分析</a></li>
                <li><a href="#contact">联系</a></li>
                <li><a href="#about">关于</a></li>
            </ul>
            <div class="clear"></div>
        </div>
    </div>

    <div style="width: 1200px;margin: 0 auto;">
        <div id="main" class="main1" style="width: 900px;height:800px;margin: 0 auto"></div>
        <div id="main2" class="main2" style="width: 900px;height:800px;margin: 0 auto"></div>
        <div id="main3" class="main3" style="width: 900px;height:800px;margin: 0 auto"></div>
        <div id="main4" class="main4" style="width: 900px;height:800px;margin: 0 auto"></div>
        <div id="main5" class="main5" style="width: 900px;height:800px;margin: 0 auto"></div>
    </div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));


        // 指定图表的配置项和数据
        // 使用刚指定的配置项和数据显示图表。
        var title = "";
        var legend = [];
        var xAxis = [];
        var series = [];
        var option;

        myChart.setOption({
            title: {
                text: title,
                subtext: '',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                type: 'scroll',
                orient: 'vertical',
                right: 10,
                top: 20,
                bottom: 20,
                data: [],

                selected: []
            },
            series: [
                {
                    name: '车名',
                    type: 'pie',
                    radius: '55%',
                    center: ['40%', '50%'],
                    data: [],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        });
        myChart.showLoading();
        $.ajax({
            type: "post",
            async: true,
            url: "http://localhost:8081/car2017",
            data: {},
            dataType: "json",
            success: function (resule) {
                title = getArr(resule.title);
                legend = getArr(resule.legend);
                series = resule.series;
                xAxis = resule.xAxis;
                myChart.hideLoading();
                myChart.setOption({
                    title: {
                        text: title,
                        subtext: '',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        right: 10,
                        top: 20,
                        bottom: 20,
                        data: strToObjArray(resule.xAxis, resule.series),

                        selected: strToObjArrayAndTrue(resule.xAxis)
                    },
                    series: [
                        {
                            name: '车名',
                            type: 'pie',
                            radius: '55%',
                            center: ['40%', '50%'],
                            data: strToObjArray(resule.xAxis, resule.series),
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                });
            },
            error: function (errorMsg) {
                alert("请求数据失效");
                myChart.hideLoading();
            }
        });

        var myChart2 = echarts.init(document.getElementById('main2'));


        $.ajax({
            type: "post",
            async: true,
            url: "http://localhost:8081/car2016",
            data: {},
            dataType: "json",
            success: function (resule) {
                title = getArr(resule.title);
                legend = getArr(resule.legend);
                series = resule.series;
                xAxis = resule.xAxis;
                myChart2.setOption({
                    title: {
                        text: title,
                        subtext: '',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        right: 10,
                        top: 20,
                        bottom: 20,
                        data: strToObjArray(resule.xAxis, resule.series),

                        selected: strToObjArrayAndTrue(resule.xAxis)
                    },
                    series: [
                        {
                            name: '车名',
                            type: 'pie',
                            radius: '55%',
                            center: ['40%', '50%'],
                            data: strToObjArray(resule.xAxis, resule.series),
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                });
            },
            error: function (errorMsg) {
                alert("请求数据失效");
                myChart.hideLoading();
            }
        });


        var myChart3 = echarts.init(document.getElementById('main3'));


        $.ajax({
            type: "post",
            async: true,
            url: "http://localhost:8081/suv2017",
            data: {},
            dataType: "json",
            success: function (resule) {
                title = getArr(resule.title);
                legend = getArr(resule.legend);
                series = resule.series;
                xAxis = resule.xAxis;
                myChart3.setOption({
                    title: {
                        text: title,
                        subtext: '',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        right: 10,
                        top: 20,
                        bottom: 20,
                        data: strToObjArray(resule.xAxis, resule.series),

                        selected: strToObjArrayAndTrue(resule.xAxis)
                    },
                    series: [
                        {
                            name: '车名',
                            type: 'pie',
                            radius: '55%',
                            center: ['40%', '50%'],
                            data: strToObjArray(resule.xAxis, resule.series),
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                });
            },
            error: function (errorMsg) {
                alert("请求数据失效");
                myChart.hideLoading();
            }
        });


        var myChart4 = echarts.init(document.getElementById('main4'));


        $.ajax({
            type: "post",
            async: true,
            url: "http://localhost:8081/suv2016",
            data: {},
            dataType: "json",
            success: function (resule) {
                title = getArr(resule.title);
                legend = getArr(resule.legend);
                series = resule.series;
                xAxis = resule.xAxis;
                myChart4.setOption({
                    title: {
                        text: title,
                        subtext: '',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        right: 10,
                        top: 20,
                        bottom: 20,
                        data: strToObjArray(resule.xAxis, resule.series),

                        selected: strToObjArrayAndTrue(resule.xAxis)
                    },
                    series: [
                        {
                            name: '车名',
                            type: 'pie',
                            radius: '55%',
                            center: ['40%', '50%'],
                            data: strToObjArray(resule.xAxis, resule.series),
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                });
            },
            error: function (errorMsg) {
                alert("请求数据失效");
                myChart.hideLoading();
            }
        });


        var myChart5 = echarts.init(document.getElementById('main5'));


        // 指定图表的配置项和数据
        // 使用刚指定的配置项和数据显示图表。
        var title = "";
        var legend = [];
        var xAxis = [];
        var series = [];
        var option;

        myChart5.setOption({
            title: {
                text: '异步数据加载实例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: []
            }]
        });


        $.ajax({
            type:"post",
            async:true,
            url:"http://localhost:8081/car2017",
            data:{},
            dataType:"json",
            success:function (resule) {
                title=getArr(resule.title);
                legend=getArr(resule.legend);
                series=getArr(resule.series);
                xAxis=getArr(resule.xAxis);
                myChart5.setOption({
                    title: {
                        text: title
                    },
                    legend: {
                        data:legend
                    },
                    xAxis:{
                        data:xAxis
                    },
                    series:[{
                        name:"销量",
                        data:series
                    }]
                });
            },
            error:function (errorMsg) {
                alert("请求数据失效");
                myChart.hideLoading();
            }
        });


        function getArr(temp) {
            return temp.split(",");
        }

        /**
         * 将两个字符串中对应的数据封装为对象，以对象数组格式返回
         * @param  String names [description]
         * @param  String vals  [description]
         * @return Array{obj...}[description]
         */
        function strToObjArray(names, vals) {
            var arr = new Array();
            for (var i = 0; i < names.split(", ").length; i++) {
                arr[i] = {"name": names.split(", ")[i].toString(), "value": parseInt(vals.split(", ")[i])};
            }
            return arr;
        }

        function strToObjArrayAndTrue(names) {
            var obj = {};
            for (var i = 0; i < names.split(", ").length; i++) {
                if (i <= 30) {
                    obj[names.split(", ")[i].toString()] = true;
                } else {
                    obj[names.split(", ")[i].toString()] = false;
                }
            }
            return obj;
        }

    </script>

</div>
<script type="text/javascript">

</script>
</body>
</html>