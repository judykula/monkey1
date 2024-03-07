/*
 * easy come, easy go.
 *
 * contact : syiae.jwy@gmail.com
 *
 * · · · · ||   ..     __       ___      ____  ®
 * · · · · ||  ||  || _ ||   ||    ||   ||      ||
 * · · · · ||  ||  \\_ ||_.||    ||   \\_  ||
 * · · _//                                       ||
 * · · · · · · · · · · · · · · · · · ·· ·    ___//
 */
package com.jwy.monkey1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 *     配置线程池，自定义线程池放到这里
 * </p>
 * <p>
 *     如果需要使用这个类，打开"@Configuration(proxyBeanMethods = false)"注释
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/7
 */
@EnableAsync
@EnableScheduling
//@Configuration(proxyBeanMethods = false)
public class ThreadPoolConfiguration {

    @Value("${sys.sample.threadpool.core.size:10}")
    private int Sample_Core_Size;
    @Value("${sys.sample.threadpool.max.size:20}")
    private int Sample_Max_Size;

    /**
     *  这是一个例子
     *
     *  你可以按照如下方式使用:
     *  <pre>
     *      {@code @autowired}
     *      private ThreadPoolTaskExecutor samplePoolExecutor;
     *      ...
     *      samplePoolExecutor.execute();
     *      ...
     *  </pre>
     *  <p>
     *      注意看这里{@code new ThreadPoolExecutor.CallerRunsPolicy()}
     *      以及下面这些策略，适当使用:
     *      {@link java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy}
     *      {@link java.util.concurrent.ThreadPoolExecutor.AbortPolicy}
     *      {@link java.util.concurrent.ThreadPoolExecutor.DiscardPolicy}
     *  </p>
     *
     *
     * @return
     */
    @Bean()
    public ThreadPoolTaskExecutor samplePoolExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        taskExecutor.setCorePoolSize(Sample_Core_Size);
        taskExecutor.setMaxPoolSize(Sample_Max_Size);
        taskExecutor.setQueueCapacity(0);
        taskExecutor.setKeepAliveSeconds(120);
        taskExecutor.setThreadNamePrefix("SampleExecutor--");
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }


}
