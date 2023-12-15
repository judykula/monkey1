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
package com.jwy.mokey1.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 *     用于验证Valid
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2023/12/14
 */
@Data
public class ValidSampleDto {

    @NotEmpty(message = "arg1 不能为空！")
    private String arg1;

}
