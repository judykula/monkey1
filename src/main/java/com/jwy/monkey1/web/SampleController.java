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
import com.jwy.monkey1.pojo.response.SampleRes;
import com.jwy.monkey1.service.SampleService;
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
public class SampleController {

    @Autowired
    private SampleService sampleService;

    /**
     * 例子：一个正常的请求
     *
     * @param userId
     * @return
     */
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
    @GetMapping("/s1/{userId}")
    public MyResponse<Long> s1(@PathVariable Long userId) {
        return MyResponse.ofSuccess(userId);
    }

    /**
     * 例子：验证关于框架如何处理业务异常{@link MyServiceException}的情形
     *
     * @return
     */
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
    @PostMapping("/add")
    public MyResponse<Long> s3(@Valid @RequestBody SampleReq sampleReq) {

        SampleDto dto = new SampleDto();
        dto.setAge(sampleReq.getAge());
        dto.setBirthday(new Date(sampleReq.getBirthday()));
        dto.setFirstName(sampleReq.getFirstName());

        long id = this.sampleService.add(dto);

        return MyResponse.ofSuccess(id);
    }

    @GetMapping("/all")
    public MyResponse<List<SampleRes>> s4() {

        List<SampleBo> all = this.sampleService.getAll();
        List<SampleRes> sampleRes = SampleConvertor.toSampleResList(all);
        return MyResponse.ofSuccess(sampleRes);
    }

}
