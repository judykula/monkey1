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
package com.jwy.monkey1.dao.entity;

import com.jwy.warlock.strategy.AbstractAutoIncIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * <p>
 *     例子entity1 :  继承{@link AbstractAutoIncIdEntity} 建表时使用「自增主键」策略
 * </p>
 * <p>
 *     建议在一些具有"自限性"的场景下建立的表使用此种策略。比如临时性质的数据、不需要分表的数据、统计数据等。
 * </p>
 * <p>
 *     我在配置里添加了这条"{@code spring.jpa.hibernate.ddl-auto=update}"，代表系统启动时自动根据{@code Entity}生成表，
 *     嗯...这个叫"模型驱动开发"^-^，所以在开发阶段你只需要注意维护entity即可，不需要手动建表。
 *     <font color='red'>注意这个配置不能在生产环境配置</font><br/><br/>
 *
 *     自动生成的建表语句是这样的：
 *     <pre>
 *          CREATE TABLE `sample1` (
 *              `id` bigint NOT NULL AUTO_INCREMENT,
 *              `create_time` bigint DEFAULT NULL,
 *              `update_time` bigint NOT NULL,
 *              `age` int NOT NULL,
 *              `birthday` datetime(6) NOT NULL,
 *              `first_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
 *              PRIMARY KEY (`id`),
 *              KEY `idx_bd` (`birthday`),
 *              KEY `idx_ctime_age` (`create_time`,`age`)
 *          ) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
 *     </pre>
 * </p>
 * <p>
 *     请参考:
 *     {@link com.jwy.monkey1.dao.repository.SampleRepository1 SampleRepository1}
 *     {@link com.jwy.monkey1.service.SampleService1 SampleService1}
 *     {@link com.jwy.monkey1.web.SampleController SampleController}
 *     等"sample"系的例子
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/30
 */
@Entity
@Data
@Table(name = "sample1", indexes = {
        @Index(name = "idx_bd", columnList = "birthday"),
        @Index(name = "idx_ctime_age", columnList = "createTime, age")
})
public class SampleEntity1 extends AbstractAutoIncIdEntity {

    @Column(length = 100, nullable = false)
    private String firstName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 100, nullable = false)
    private Date birthday;

    @Column(nullable = false)
    private Integer age;

}
