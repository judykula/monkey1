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

import com.jwy.medusa.common.exception.MyServiceException;
import com.jwy.medusa.mvc.MyResponse;
import com.jwy.monkey1.convertor.SampleConvertor;
import com.jwy.monkey1.pojo.bo.SampleBo;
import com.jwy.monkey1.pojo.dto.SampleDto;
import com.jwy.monkey1.pojo.request.SampleReq;
import com.jwy.monkey1.pojo.response.SampleVo;
import com.jwy.monkey1.service.SampleService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *     这是一个Rest API接口提供controller的例子
 * </p>
 * <p>
 *     框架的返回数据结构统一为{@link MyResponse}:
 *     <pre>
 *         {
 *             "data": xxx, //jsonObject 响应数据对象
 *             "mystatus": { //服务状态描述对象
 *                 "code": 200, //服务状态码，正常状态用200表示，其他为错误状态，参考{@link com.jwy.medusa.mvc.MyStatusz}
 *                 "desc": "xxx"  //服务状态信息描述
 *             },
 *             "ts": 19763223456, //服务响应时的时间戳，millisecond
 *             "status": 200    //系统自带http code，框架没用进行干涉，适当使用
 *         }
 *     </pre>
 *     请求方需要优先判断"mystatus"对象，再根据code进行逻辑 "正常/异常"处理，以及是否需要解析"data"对象。
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2023/11/21
 */
@RestController
@RequestMapping("/sample")
@Tag(name = "SAMPLE", description = "样例接口")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    /**
     * 例子：一个正常的请求
     *
     * @param userId
     * @return
     */
    @Operation(
            summary = "一个正常的请求接口例子",
            description = "可以用来测试正常的请求以及响应的数据结构",
            parameters = {
                    @Parameter(name = "userId", description = "用户ID", required = true, example = "1")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "响应成功, 返回的是你输入的参数"),
                    @ApiResponse(responseCode = "500", description = "响应失败",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    )
            }
    )
    @GetMapping("/s0")
    public MyResponse<Long> s0(Long userId) {
        return MyResponse.ofSuccess(userId);
    }

    /**
     * 例子：使用path value的参数方式请求
     *
     * 比如这样{@code http:127.0.0.1:8080/sample/s1/123456}
     *
     * @param userId
     * @return
     */
    @Operation(
            summary = "一个正常的请求接口例子，使用的是PathVariable的参数请求方式",
            description = "可以用来测试PathVariable样式的请求以及响应的数据结构",
            parameters = {
                    @Parameter(name = "userId", description = "用户ID", required = true, example = "1")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "响应成功, 返回的是你输入的参数"),
                    @ApiResponse(responseCode = "500", description = "响应失败",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    )
            }
    )
    @GetMapping("/s1/{userId}")
    public MyResponse<Long> s1(@PathVariable Long userId) {
        return MyResponse.ofSuccess(userId);
    }

    /**
     * 例子：验证关于框架如何处理业务异常{@link MyServiceException}的情形
     *
     * @return
     */
    @Hidden
    @GetMapping("/s2")
    public MyResponse<?> s2() {
        throw new MyServiceException();
    }

    /**
     * 例子：这是一个正常业务流程的例子，添加数据
     *
     * 支持通过spring validation验证请求参数，如果不需要的话去掉{@code @Valid}以及对应"Request"内的数据验证注解即可
     *
     * @param sampleReq
     * @return
     */
    @Operation(
            summary = "一个正常的业务流程接口样例, 输入一条数据至数据库",
            description = "",
            parameters = {
                    @Parameter(schema = @Schema(implementation = SampleReq.class), content = @Content(mediaType="application/json"))
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "响应成功"),
                    @ApiResponse(responseCode = "500", description = "响应失败",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    )
            }
    )
    @PostMapping("/add")
    public MyResponse<Long> s3(@Valid @RequestBody SampleReq sampleReq) {

        SampleDto dto = new SampleDto();
        dto.setAge(sampleReq.getAge());
        dto.setBirthday(new Date(sampleReq.getBirthday()));
        dto.setFirstName(sampleReq.getFirstName());

        long id = this.sampleService.add(dto);

        return MyResponse.ofSuccess(id);
    }

    @Operation(
            summary = "一个正常的业务流程接口样例, 查询所有数据",
            description = "",
            parameters = {},
            responses = {
                    @ApiResponse(responseCode = "200", description = "响应成功, 返回的是你输入的参数"),
                    @ApiResponse(responseCode = "500", description = "响应失败",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    )
            }
    )
    @GetMapping("/all")
    public MyResponse<List<SampleVo>> s4() {

        List<SampleBo> all = this.sampleService.getAll();
        List<SampleVo> sampleRes = SampleConvertor.toSampleResList(all);
        return MyResponse.ofSuccess(sampleRes);
    }

}
