package com.capintani.customerregistration.docs;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    public SwaggerConfig() {
        super("com.capintani.customerregistration");
    }
}
