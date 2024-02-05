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
package com.jwy.monkey1.web;

import com.jwy.medusa.mvc.MyResponse;
import com.jwy.monkey1.common.convertor.Sample1Convertor;
import com.jwy.monkey1.pojo.bo.SampleBo;
import com.jwy.monkey1.pojo.dto.SampleDto;
import com.jwy.monkey1.pojo.response.SampleResponse;
import com.jwy.monkey1.service.SampleService1;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *     测试用的Controller
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/31
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SampleService1 sampleService1;

    @GetMapping("/t1")
    public MyResponse t1() {

        for (int i = 0; i < 10; i++) {
            SampleDto sampleDto = SampleDto.builder()
                    .age(RandomUtils.nextInt(0, 100))
                    .firstName(RandomStringUtils.randomAlphanumeric(10))
                    .birthday(new Date())
                    .build();
            this.sampleService1.add(sampleDto);
        }

        return MyResponse.ofSuccess();
    }

    @GetMapping("/t2")
    public MyResponse<List<SampleResponse>> t2() {
        List<SampleBo> all = this.sampleService1.getAll();
        List<SampleResponse> sampleResponses = Sample1Convertor.toSampleResponses(all);
        return MyResponse.ofSuccess(sampleResponses);
    }

}
