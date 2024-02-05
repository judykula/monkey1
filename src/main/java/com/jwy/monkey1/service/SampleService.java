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

import com.jwy.arcwarden.IdGeneratorClient;
import com.jwy.medusa.common.utils.spring.MyContextUtils;
import com.jwy.medusa.mvc.MyStatus;
import com.jwy.monkey1.common.convertor.SampleConvertor;
import com.jwy.monkey1.common.exception.Monkey1Exception;
import com.jwy.monkey1.dao.entity.SampleEntity;
import com.jwy.monkey1.dao.repository.SampleRepository;
import com.jwy.monkey1.pojo.bo.SampleBo;
import com.jwy.monkey1.pojo.dto.SampleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 *     手动指定id生成
 *
 *     这个例子结合{@link SampleRepository} 和 {@link SampleEntity}使用
 *
 *     请优先使用本例子模版编写代码
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/2/2
 */
@Slf4j
@Service
public class SampleService {

    @Autowired
    private MyContextUtils myContextUtils;
    @Autowired
    private IdGeneratorClient idGeneratorClient;
    @Autowired
    private SampleRepository sampleRepository;

    public long add(SampleDto dto){

        SampleEntity entity = SampleConvertor.toSampleEntity(dto);
        Assert.notNull(dto, "SampleDto is null!");

        long id = this.idGeneratorClient.nextId();
        entity.setId(id);

        try {
            SampleEntity s = sampleRepository.save(entity);
            return s.getId();
        } catch (Exception e) {
            log.error("【SS070】add sampleDto fail", e);//log中的"【】"规则：取类名的大写字母("SS")+对应行数("070")，方便在查询log是进行grep key抓取
            throw new Monkey1Exception(MyStatus.of(10000, "Monkey1Exception"), e);//TODO 这块要改成使用 公共jar内定义的 statusz
        }
    }

    public List<SampleBo> getAll(){
        List<SampleEntity> all;
        try {
            all = this.sampleRepository.findAll();
        } catch (Exception e) {
            log.error("【SS080】get all sampleDto fail", e);
            throw new Monkey1Exception(MyStatus.of(10000, "Monkey1Exception"), e);//TODO 这块要改成使用 公共jar内定义的 statusz
        }

        // .... do next

        return SampleConvertor.toSampleBos(all);
    }

}
