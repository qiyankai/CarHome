# CarHome
爬取[汽车之家](https://www.autohome.com.cn)与[汽车销量网](http://www.qichexl.com/)的汽车数据,并对数据进行持久化处理存入数据库<br>
爬取大概9万条汽车信息(包括图片、车辆信息、销售信息)<br>
使用maven构建一个基于SSM框架的webapp，在app中用echarts插件对数据进行展示。<br>
这是一个maven聚合项目，所有子项目依赖common工具项目

>cb-parent
>> cb-common
>>
>> cb-manage
>>
>> cb-webapp
