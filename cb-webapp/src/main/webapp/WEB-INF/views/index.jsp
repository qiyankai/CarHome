<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>CarB汽车</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!--slider-->
    <script type="text/javascript" src="js/modernizr.custom.53451.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.gallery.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#dg-container').gallery({
                autoplay: true
            });
        });
    </script>
</head>
<body>
<div class="wrap">

    <div class="header">
        <div class="clear"></div>
        <div class="h_main">
            <ul class="header">
                <li><a href="/index">主页</a></li>
                <li><a href="/data">数据分析</a></li>
                <li><a href="#">联系</a></li>
                <li><a href="#">关于</a></li>
            </ul>
            <div class="clear"></div>
        </div>
    </div>

    <div class="container">
        <section id="dg-container" class="dg-container">
            <div class="dg-wrapper">
                <a href="#"><img src="images/1.jpg" width="720" height="400" alt="image1"/></a>
                <a href="#"><img src="images/2.jpg" width="720" height="400" alt="image2"/></a>
                <a href="#"><img src="images/3.jpg" width="720" height="400" alt="image3"/></a>
                <a href="#"><img src="images/4.jpg" width="720" height="400" alt="image4"/></a>
                <a href="#"><img src="images/5.jpg" width="720" height="400" alt="image5"/></a>
                <a href="#"><img src="images/6.jpg" width="720" height="400" alt="image1"/></a>
                <a href="#"><img src="images/7.jpg" width="720" height="400" alt="image2"/></a>
                <a href="#"><img src="images/8.jpg" width="720" height="400" alt="image3"/></a>
            </div>
        </section>
    </div>
    <div class="tab-div">

        <div class="tab-title">
            <div class="t-left">汽车品牌</div>
            <div class="t-right">车系列表</div>
        </div>
        <div class="tab-list">
            <c:forEach items="${Brands}" var="b">
                <c:if test="${b.series.size()!=0}">
                    <div class="tab-item">
                        <div class="item-l">${b.name}</div>
                        <div class="item-r">
                            <c:forEach items="${b.series}" var="s">
                                <a href="/${s.seriesId}" class="series">${s.seriesName}</a>
                            </c:forEach>
                            <div style="width:100%;overflow:hidden"></div>
                        </div>
                        <div style="width:100%;overflow:hidden"></div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

    </div>

</div>
</body>
</html>