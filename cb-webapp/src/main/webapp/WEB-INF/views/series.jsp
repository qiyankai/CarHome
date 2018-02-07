<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>CarB汽车</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/details.css" rel="stylesheet" type="text/css" media="all"/>
    <!--image slider-->
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script src="js/jquery-slider.js" type="text/javascript"></script>
    <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
    <script src="js/echarts.common.min.js"></script>
    <script src="js/echarts.js"></script>
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <link href="css/easy-responsive-tabs.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="css/global.css">
    <script src="js/slides.min.jquery.js"></script>
    <script>
        $(function () {
            $('#products').slides({
                preload: true,
                preloadImage: 'img/loading.gif',
                effect: 'slide, fade',
                crossfade: true,
                slideSpeed: 350,
                fadeSpeed: 500,
                generateNextPrev: true,
                generatePagination: false
            });
        });
    </script>
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

    <div class="car-info">
        <div class="info-l">
            <!-- 车辆图片 -->
            <div class="car-img"><img src="${imgs.get(0)}" alt=""></div>
        </div>
        <div class="info-r">
            <!-- 车辆信息 -->
            <ul>
                <li class="info-1">
                    车名：
                    <span class="info-span">${series.seriesName}</span>
                </li>
                <li class="info-2">
                    售价：
                    <span class="info-span">${series.seriesPriceRange}</span>
                </li>
            </ul>
        </div>
    </div>

    <div class="show-car">
        <span>在售车辆：</span>
        <c:if test="${cars.size()>0}">
            <c:forEach items="${cars}" var="car">
                <div class="car-name">${car.carName}</div>
            </c:forEach>
        </c:if>
        <c:if test="${cars.size()==0}">
            <div class="car-name">暂无</div>
        </c:if>
    </div>
    <div id="fenxi"></div>
    <div class="main">
        <div class="main1">
            <div class="details">
                <script type="text/javascript">
                    $(document).ready(function () {
                        $('#horizontalTab').easyResponsiveTabs({
                            type: 'default', //Types: default, vertical, accordion
                            width: 'auto', //auto or any width like 600px
                            fit: true   // 100% fit in a container
                        });
                    });
                </script>
                <div class="content_bottom">
                    <div class="div2">
                        <div id="mcts1">
                            <c:forEach items="${imgs}" var="im">
                                <img src="${im}" alt=""/>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<script type="text/javascript">

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('fenxi'));
    var str = '3';
    for (var i = 0;i < 4 ;i++){
        str+=','+(Math.random()*4+3);
    }
    var arr = str.split(',');

    // 指定图表的配置项和数据
    var option = {
        angleAxis: {
            type: 'category',
            data: ['加速', '刹车', '油耗', '价格', '销售数量'],
            z: 10
        },
        radiusAxis: {},
        polar: {},
        series: [{
            type: 'bar',
            data: arr,
            coordinateSystem: 'polar',
            name: 'A',
            stack: 'a'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>