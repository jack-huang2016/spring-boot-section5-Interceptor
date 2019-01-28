package org.springboot.sample;

import org.springboot.sample.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 现在可以直接运行 SpringBootSampleApplication的main方法，和执行普通java程序一样
 * 然后可以看到spring-boot 内置server容器（默认为Tomcat），这一切spring-boot 都帮我们做好了。
 * Started SpringBootSampleApplication in 4.895 seconds (JVM running for 5.532)
 * 
 * @author huang.yj
 * @date 2018.12.08
 *
 */
@SpringBootApplication
public class SpringBootSampleApplication {
	
	 /**
     * 使用代码注册Servlet（不需要@ServletComponentScan注解）
     *
     * @return
     * @author huang.yj
     * @create  2018年12月8日
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet(), "/xs/*");// ServletName默认值为首字母小写，即myServlet
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
    
}


