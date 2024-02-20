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
import com.jwy.monkey1.convertor.Sample1Convertor;
import com.jwy.monkey1.pojo.bo.SampleBo;
import com.jwy.monkey1.pojo.dto.SampleDto;
import com.jwy.monkey1.pojo.response.SampleVo;
import com.jwy.monkey1.service.SampleService1;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "TEST", description = "测试接口")
public class TestController {

    @Autowired
    private SampleService1 sampleService1;

    @GetMapping("/t1")
    public MyResponse t1() {

        for (int i = 0; i < 10; i++) {
            SampleDto sampleDto = new SampleDto();
            sampleDto.setAge(RandomUtils.nextInt(0, 100));
            sampleDto.setFirstName(RandomStringUtils.randomAlphanumeric(10));
            sampleDto.setBirthday(new Date());
            this.sampleService1.add(sampleDto);
        }

        return MyResponse.ofSuccess();
    }

    @Operation(
            summary = "查询所有数据",
            description = "这是一个测试接口，用于查询所有测试生成的数据",
            parameters = {
                    @Parameter(name = "id", description = "这是一个测试参数", required = false, example = "1")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "响应成功"),
                    @ApiResponse(responseCode = "500", description = "响应失败",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    )
            }
    )
    @GetMapping("/t2")
    public MyResponse<List<SampleVo>> t2() {
        List<SampleBo> all = this.sampleService1.getAll();
        List<SampleVo> sampleResponses = Sample1Convertor.toSampleResponses(all);
        return MyResponse.ofSuccess(sampleResponses);
    }

}
