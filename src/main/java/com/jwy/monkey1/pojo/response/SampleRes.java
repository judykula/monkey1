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
package com.jwy.monkey1.pojo.response;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 *     sample 的response
 * </p>
 * <p>
 *     关于各个层之间的数据传输对象定义：
 *     <pre>
 *          [View] -> xxxRequest -> [Controller] ->  xxxDto -> [Service] -> xxxEntity -> [Repository]
 *
 *          [View] <- xxxResponse <- [Controller] <-  xxxBo <- [Service] <- xxxEntity <- [Repository]
 *     </pre>
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/2/1
 */
@Data
public class SampleRes {

    private String firstName;
    private Date birthday;
    private Integer age;
    private long createTime;
}
