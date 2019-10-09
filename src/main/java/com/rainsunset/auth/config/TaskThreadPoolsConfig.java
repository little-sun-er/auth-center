package com.rainsunset.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName TaskThreadPoolsConfig
 * @Description: 定时任务线程池配置
 * @Author: 李刚伟
 * @Company rainsunset
 * @CreateDate: 2019/3/22 18:06
 */
@Slf4j
@Configuration
@EnableAsync
public class TaskThreadPoolsConfig {

    @Value("${async-executor-hread.core-pool-size}")
    private int corePoolSize;
    @Value("${async-executor-hread.max-pool-size}")
    private int maxPoolSize;
    @Value("${async-executor-hread.queue-capacity}")
    private int queueCapacity;
    @Value("${async-executor-hread.name-prefix}")
    private String namePrefix;

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(namePrefix);

        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
