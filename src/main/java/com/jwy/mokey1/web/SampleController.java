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
package com.jwy.mokey1.web;

import com.jwy.medusa.exception.MyServiceException;
import com.jwy.medusa.mvc.MyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p>
 *     例子
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2023/11/21
 */
@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/s1/{userId}")
    public Mono<MyResponse> s1(@PathVariable Long userId) {
        return Mono.just(MyResponse.ofSuccess(userId));
    }

    @GetMapping("/s2")
    public Mono<MyResponse> s2() {
        throw new MyServiceException();
    }


}
