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
package com.jwy.monkey1.feign.server;

import com.jwy.medusa.common.exception.MyServiceException;
import com.jwy.medusa.mvc.MyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *      这是一个"feign"请求的server端例子实现
 * </p>
 * <p>
 *     ！！所有的请求路径都必须以"/feign"开头
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2023/12/19
 */
@RestController
@RequestMapping("/feign/sample")
public class FeignSampleServer {

    @GetMapping("/f1")
    public MyResponse f1() {
        throw new MyServiceException();
    }

}
