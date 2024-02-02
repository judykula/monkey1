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

/**
 * <p>
 *     用于验证Valid的例子
 * </p>
 * <p>
 *     关于各个层之间的数据传输对象定义：
 *     <pre>
 *          [View] -> xxxRequest -> [Controller] ->  xxxDto -> [Service] -> xxxEntity -> [Repository]
 *
 *          [View] -> xxxResponse <- [Controller] <-  xxxBo <- [Service] <- xxxEntity <- [Repository]
 *     </pre>
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2023/12/14
 */
@Data
public class ValidSampleReq {

    @NotEmpty(message = "arg1 不能为空！")
    private String arg1;

}
