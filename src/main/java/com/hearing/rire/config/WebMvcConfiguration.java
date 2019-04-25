package com.hearing.rire.config;

import com.hearing.rire.util.Utils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Create by hearing on 19-4-13
 */

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 图片和文件资源路由映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/image/**")
                .addResourceLocations("file:///" + Utils.getResPath());
        super.addResourceHandlers(registry);
    }
}
