package com.yangli.springbootWeb.config;

import com.yangli.springbootWeb.component.LoginHandlerInterceptor;
import com.yangli.springbootWeb.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //当浏览器发送"/"请求时，将会访问到login.html页面，此种使用方式与@RequestMapping({"/","/index"})的效果是一样的
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver(){
        //@Bean交给springboot容器进行管理 使用我们自己实现的国际化语言管理
        return new MyLocaleResolver();
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
        /**
         * addInterceptor表示添加一个拦截器
         * addPathPatterns表示需要拦截的请求，/**表示拦截任意请求
         * excludePathPatterns表示忽略拦截的请求
         * 对于静态资源，springboot已经做好了映射，所以我们不需要做任何处理
         */
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/","/user/login","/asserts/**","/webjars/**");
    }
}
