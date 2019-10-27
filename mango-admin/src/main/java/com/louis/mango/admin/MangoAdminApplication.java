package com.louis.mango.admin;

import com.louis.mango.admin.config.CorsConfig;
import com.louis.mango.admin.config.DruidConfig;
import com.louis.mango.admin.config.MybatisConfig;
import com.louis.mango.admin.config.SwaggerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.louis.mango.admin"})
@ImportAutoConfiguration({DruidConfig.class,CorsConfig.class,SwaggerConfig.class})
public class MangoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoAdminApplication.class, args);
    }

}
