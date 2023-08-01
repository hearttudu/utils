package com.tudu.utils;

import com.tudu.utils.text.TextUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass
public class UtilsAutoConfiguration {
    static {
        System.out.println("MyAutoConfiguration init......");
    }

    @Bean
    public TextUtils textUtils() {
        return new TextUtils();
    }
}
