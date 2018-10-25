package com.yangli.springbootWeb.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 区域信息解析器
 * 可以通过点击按钮或者链接切换国际化语言
 *
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");
        //若没有参数传过来，则获取系统默认的语言
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //获取我们传参过来的语言
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
