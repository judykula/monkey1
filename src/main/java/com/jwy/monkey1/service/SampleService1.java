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
package com.jwy.monkey1.service;

import com.jwy.medusa.mvc.MyStatus;
import com.jwy.monkey1.common.exception.Monkey1Exception;
import com.jwy.monkey1.convertor.SampleConvertor;
import com.jwy.monkey1.dao.entity.SampleEntity1;
import com.jwy.monkey1.dao.repository.SampleRepository1;
import com.jwy.monkey1.pojo.bo.SampleBo;
import com.jwy.monkey1.pojo.dto.SampleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 *     这个例子结合{@link SampleRepository1} 和 {@link SampleEntity1}使用
 *
 *     主要场景是主键的生成策略你要自己控制，比如在 {@link SampleEntity1}里配置了 "自增主键"
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/30
 */
@Slf4j
@Service
public class SampleService1 {

    @Autowired
    private SampleRepository1 sampleRepository1;

    public long add(SampleDto dto){

        SampleEntity1 entity1 = SampleConvertor.toSampleEntity1(dto);
        Assert.notNull(dto, "SampleDto is null!");

        try {
            SampleEntity1 s = sampleRepository1.save(entity1);
            return s.getId();
        } catch (Exception e) {
            log.error("【SS055】add sampleDto fail", e);
            throw new Monkey1Exception(MyStatus.of(10000, "Monkey1Exception"), e);//TODO 这块要改成使用 公共jar内定义的 statusz
        }
    }

    public List<SampleBo> getAll(){
        List<SampleEntity1> all;
        try {
            all = this.sampleRepository1.findAll();
        } catch (Exception e) {
            log.error("【SS065】get all sampleDto fail", e);
            throw new Monkey1Exception(MyStatus.of(10000, "Monkey1Exception"), e);//TODO 这块要改成使用 公共jar内定义的 statusz
        }

        // .... do next

        return SampleConvertor.toSampleBos(all);
    }

}
