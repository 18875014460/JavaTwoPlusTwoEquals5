All extensions **of the platform** are included into the build process by default. For **other extensions** it's necessary to tell hybris that they should be included.

* spring-security（整体的用户权限之类验证，webservice,登录之类的）
* spring-integration(omsats, datahub)
* jmx(监控)
* zk(各个cockpit backoffice底层)
* velocity 邮件内容产生使用的技术(VelocityTemplateRenderer), oauth2 手机 外部调用，webservice验证
* solr 商品搜索

[解读Hybris自带的拦截器框架的使用方法和配置文件](http://www.ku2n.com/ku2n/index.php?c=read&id=1364&page=2)

addon 是hybris插件的概念。 其实就是普通的java工程,不过需要执行下列语句将addon导入你的商城网站项目下。
> ant addoninstall -Daddonnames="weixinpay" -DaddonStorefront.yacceleratorstorefront="xxxstorefront"

@Resource   //如果将该注释应用于一个字段或方法，那么初始化应用程序组件时容器（Spring）将把所请求资源的一个实例注入其中。
private StadiumDAO stadiumDAO
