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
package com.jwy.monkey1.common.exception;

import com.jwy.medusa.common.exception.MyServiceException;
import com.jwy.medusa.mvc.MyStatus;

/**
 * <p>
 *     monkey1业务的exception
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/31
 */
public class Monkey1Exception extends MyServiceException {

    public Monkey1Exception() {
        super(MyStatus.of(10000, "Monkey1Exception"));//TODO 这块要改成使用 公共jar内定义的 statusz
    }

    public Monkey1Exception(MyStatus status) {
        super(status);
    }

    public Monkey1Exception(MyStatus status, Throwable cause) {
        super(status, cause);
    }
}
