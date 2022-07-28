package WarehouseSystemManager.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RemoteInterceptorWebConfig implements WebMvcConfigurer {
    @Autowired
    private RemoteInterceptor remoteInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.remoteInterceptor).addPathPatterns("/api/add/*");
    }
}
