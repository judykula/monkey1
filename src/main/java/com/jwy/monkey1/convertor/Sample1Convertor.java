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
package com.jwy.monkey1.convertor;

import com.jwy.monkey1.dao.entity.SampleEntity1;
import com.jwy.monkey1.pojo.bo.SampleBo;
import com.jwy.monkey1.pojo.dto.SampleDto;
import com.jwy.monkey1.pojo.response.SampleRes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *     "sample1"的转换器
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/31
 */
public class Sample1Convertor {

    /**
     * SampleDto -> SampleEntity1
     *
     * @param sampleDto
     * @return
     */
    public static SampleEntity1 toSampleEntity1(SampleDto sampleDto) {

        if (sampleDto == null) {
            return null;
        }

        SampleEntity1 sampleEntity1 = new SampleEntity1();
        sampleEntity1.setFirstName(sampleDto.getFirstName());
        sampleEntity1.setBirthday(sampleDto.getBirthday());
        sampleEntity1.setAge(sampleDto.getAge());

        return sampleEntity1;
    }

    public static SampleBo toSampleBo(SampleEntity1 sampleEntity1) {
        if (sampleEntity1 == null) {
            return null;
        }
        SampleBo sampleBo = new SampleBo();
        sampleBo.setId(sampleEntity1.getId());
        sampleBo.setFirstName(sampleEntity1.getFirstName());
        sampleBo.setBirthday(sampleEntity1.getBirthday());
        sampleBo.setAge(sampleEntity1.getAge());
        sampleBo.setCreateTime(sampleEntity1.getCreateTime());

        return sampleBo;
    }

    public static List<SampleBo> toSampleBos(List<SampleEntity1> sampleEntity1s) {

        //需要注意sampleEntity1s.size()
        List<SampleBo> collect = sampleEntity1s.stream().map(Sample1Convertor::toSampleBo).filter(Objects::nonNull).collect(Collectors.toList());
        return collect;
    }


    public static SampleRes toSampleResponse(SampleBo sampleBo) {
        if (sampleBo == null) {
            return null;
        }
        SampleRes sampleResponse = new SampleRes();
        sampleResponse.setFirstName(sampleBo.getFirstName());
        sampleResponse.setBirthday(sampleBo.getBirthday());
        sampleResponse.setAge(sampleBo.getAge());
        sampleResponse.setCreateTime(sampleBo.getCreateTime());

        return sampleResponse;
    }

    public static List<SampleRes> toSampleResponses(List<SampleBo> sampleBos) {
        return sampleBos.stream().map(Sample1Convertor::toSampleResponse).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
