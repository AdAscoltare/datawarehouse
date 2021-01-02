package tongji.datawarehouse.neo4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author Wang Wenzheng
 * @Description:
 * @Date: Created in 22:39 2021/1/2
 * @Modified By:
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)//设置是否启动Swagger
                .select()
                //RequestHandlerSelectors，配置要扫描的接口方法
                //basePackage：指定要扫描的包
                //any()：扫描全部
                //none()：都不扫描
                //withClassAnnotation()：扫描类上的注解——参数是一个注解的反射对象
                //withMethodAnnotation()：扫描方法上的注解——get post
                .apis(RequestHandlerSelectors.basePackage("tongji.datawarehouse.neo4j.controller"))
                .paths(PathSelectors.any())//过滤地址
                .build();//工厂模式
    }
    //配置Swagger 信息apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("wwz", "http://www.baidu.com/", "ss@qq.com");
        return new ApiInfo("牛佛杰API文档",
                "不会还有人不会写后端吧，不会吧不会吧！",
                "1.0",
                "http://www.baidu.com/",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
