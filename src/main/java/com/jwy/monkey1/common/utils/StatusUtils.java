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
package com.jwy.monkey1.common.utils;

import com.jwy.medusa.mvc.MyStatus;
import com.jwy.medusa.mvc.MyStatusz;

/**
 * <p>
 *     定义自己的业务状态描述，用于web api 返回
 * </p>
 * <p>
 *     业务系统返回的状态码是5位数，请阅读{@link MyStatusz}的注解
 *
 *     其中前两位以标记业务，后面三位为状态码区间，步长为10(0～10之间用于后序补偿使用)
 * </p>
 * <p>
 *     sample:
 *     本业务的状态码前两位以10开头，后面三位为状态码区间，比如：10010,10020 ...
 *     后序如果发现10010的状态码需要拆分，可以添加10011, 10012...
 *
 *     TODO 请定义自己的状态码开头业务(如不确定，请联系上级确认)
 *     TODO 项目开始后请, 请保留本类，删除样例代码
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/18
 */
public class StatusUtils extends MyStatusz {

    /**
     * 样例
     */
    public static MyStatus xxxError =  MyStatus.of(10010, "xxxError");


}
