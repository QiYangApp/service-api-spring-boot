package com.myadream.app.qiyang.service.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Component
public class I18nMessageUtil implements ApplicationContextAware {

    @Autowired
    public static MessageSource messageSource;

    private static Locale currentLocale = new Locale("en");

    public static String getMessage(String key) {
        return messageSource.getMessage(key, null, key, currentLocale);
    }

    public static String getMessage(String key, Locale locale) {
        return messageSource.getMessage(key, null, key, locale == null ? currentLocale : locale);
    }

    public static String getMessage(String key, String defaultMessage) {
        return messageSource.getMessage(key, null, defaultMessage == null ? key : defaultMessage, currentLocale);
    }

    public static String getMessage(String key, String defaultMessage, Locale locale) {
        return messageSource.getMessage(key, null, defaultMessage == null ? key : defaultMessage, locale == null ? currentLocale : locale);
    }

    public static String getMessage(String key, Object[] placeHolders) {
        return messageSource.getMessage(key, placeHolders, key, currentLocale);
    }

    public static String getMessage(String key, Object[] placeHolders, String defaultMessage) {
        return messageSource.getMessage(key, placeHolders, defaultMessage == null ? key : defaultMessage, currentLocale);
    }

    public static String getMessage(String key, Object[] placeHolders, Locale locale) {
        return messageSource.getMessage(key, placeHolders, key, locale == null ? currentLocale : locale);
    }

    public static String getMessage(String key, Object[] placeHolders, String defaultMessage, Locale locale) {
        return messageSource.getMessage(key, placeHolders, defaultMessage == null ? key : defaultMessage, locale == null ? currentLocale : locale);
    }

    public static void setCurrentLocale(Locale currentLocale) {
        I18nMessageUtil.currentLocale = currentLocale;
    }

    public static void setCurrentLocale(HttpServletRequest request) {
        I18nMessageUtil.currentLocale = RequestContextUtils.getLocale(request);
    }

    public static void setMessageSource(MessageSource messageSource) {
        I18nMessageUtil.messageSource = messageSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (null == messageSource) {
            messageSource = applicationContext.getBean(MessageSource.class);
        }
    }
}
