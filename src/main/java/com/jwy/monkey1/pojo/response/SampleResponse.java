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
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/2/1
 */
@Data
public class SampleResponse {

    private String firstName;
    private Date birthday;
    private Integer age;
    private long createTime;
}
