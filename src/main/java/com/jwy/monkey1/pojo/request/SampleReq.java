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
package com.jwy.monkey1.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * <p>
 *     Sample Request例子
 * </p>
 * <p>
 *     关于各个层之间的数据传输对象定义：
 *     <pre>
 *          [View] -> xxxRequest -> [Controller] ->  xxxDto -> [Service] -> xxxEntity -> [Repository]
 *
 *          [View] <- xxxResponse <- [Controller] <-  xxxBo <- [Service] <- xxxEntity <- [Repository]
 *     </pre>
 *     <ul>
 *         <li>对于[Controller]来说：接收的数据是"XxxReq"，返回的数据是"XxxRes"。要求"XxxReq"对应的数据是可以"可视化"的，"XxxRes"对应的数据是"脱敏的"</li>
 *         <li>对于[Service]来说：接收的数据"XxxDto"，返回的数据是"XxxBo"</li>
 *         <li>对于[Repository]来说：接收的数据是"XxxEntity"，返回的数据是"XxxEntity"]</li>
 *     </ul>
 *     [Controller] [Service] [Repository]之间输入输出对象的转换使用"convertor"工具进行转换。<br/>
 *
 *     为了避免这些"pojo"在一些简单场景有产生过度设计问题，造成工作量浪费造成效率降低问题，在[service]层中可以输入输出都是"dto"，
 *     适用于对数据处理时输入输出无太大差别的情况，这通常是普遍场景。
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/2/18
 */
@Data
public class SampleReq {

    @NotEmpty(message = "firstName 不能为空！")
    private String firstName;
    @NotEmpty(message = "birthday 不能为空！")
    private Long birthday;
    @Positive
    @NotEmpty(message = "age 不能为空！")
    private Integer age;

}
