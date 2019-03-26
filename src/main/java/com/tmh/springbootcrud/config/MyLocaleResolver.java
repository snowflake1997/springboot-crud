package com.tmh.springbootcrud.config;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author TMH
 * @date 2018/9/24 - 12:13
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale=Locale.getDefault();
        String lau=httpServletRequest.getParameter("lau");
        if(!StringUtils.isEmpty(lau)){
            String splits[] = lau.split("_");
            locale = new Locale(splits[0],splits[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {

    }
}
