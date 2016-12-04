package com.sainsburys.productconsumer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ProductConfiguration {

    @Value("${executor.service.corePoolSize}")
    private int corePoolSize;
    @Value("${executor.service.maximumPoolSize}")
    private int maximumPoolSize;
    @Value("${executor.service.keepAliveTime}")
    private int keepAliveTime;

    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(maximumPoolSize));
    }
}
