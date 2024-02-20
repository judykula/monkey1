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

import com.jwy.monkey1.dao.entity.SampleEntity;
import com.jwy.monkey1.pojo.bo.SampleBo;
import com.jwy.monkey1.pojo.dto.SampleDto;
import com.jwy.monkey1.pojo.response.SampleVo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *     "sample"的转换器
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/2/2
 */
public class SampleConvertor{

    public static SampleEntity toSampleEntity(SampleDto sampleDto) {
        if (sampleDto == null) {
            return null;
        }
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setFirstName (sampleDto.getFirstName());
        sampleEntity.setBirthday(sampleDto.getBirthday());
        sampleEntity.setAge(sampleDto.getAge());

        return sampleEntity;
    }

    public static SampleBo toSampleBo(SampleEntity sampleEntity) {
        if (sampleEntity == null) {
            return null;
        }
        SampleBo sampleBo = new SampleBo();
        sampleBo.setId(sampleEntity.getId());
        sampleBo.setFirstName(sampleEntity.getFirstName());
        sampleBo.setBirthday(sampleEntity.getBirthday());
        sampleBo.setAge(sampleEntity.getAge());
        sampleBo.setCreateTime(sampleEntity.getCreateTime());

        return sampleBo;
    }

    public static List<SampleBo> toSampleBos(List<SampleEntity> sampleEntitys) {
        return sampleEntitys.stream().map(SampleConvertor::toSampleBo).filter(Objects::nonNull).collect(Collectors.toList());
    }


    public static SampleVo toSampleRes(SampleBo sampleBo) {
        if (sampleBo == null) {
            return null;
        }
        SampleVo sampleRes = new SampleVo();
        sampleRes.setFirstName(sampleBo.getFirstName());
        sampleRes.setBirthday(sampleBo.getBirthday());
        sampleRes.setAge(sampleBo.getAge());
        sampleRes.setCreateTime(sampleBo.getCreateTime());

        return sampleRes;
    }

    public static List<SampleVo> toSampleResList(List<SampleBo> sampleBos) {
        return sampleBos.stream().map(SampleConvertor::toSampleRes).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
