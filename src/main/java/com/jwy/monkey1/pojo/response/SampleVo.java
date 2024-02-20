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

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Sample响应返回数据对象")
public class SampleVo {

    @Schema(name = "firstName", description = "姓名", example = "jiasdg")
    private String firstName;

    @Schema(name = "birthday", description = "生日信息", example = "2024-02-03")
    private Date birthday;

    @Schema(name = "age", description = "你的年龄", example = "1")
    private Integer age;

    @Schema(name = "createTime", description = "这条数据的创建时间", example = "12342353456354")
    private long createTime;
}
