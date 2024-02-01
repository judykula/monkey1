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
package com.jwy.monkey1.pojo.bo;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 *     Sample Bo
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/31
 */
@Data
public class SampleBo {
    private long id;
    private String firstName;
    private Date birthday;
    private Integer age;
    private long createTime;
}
