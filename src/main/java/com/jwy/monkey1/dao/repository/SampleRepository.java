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
package com.jwy.monkey1.dao.repository;

import com.jwy.monkey1.dao.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *     sample持久化例子 看这里{@link SampleEntity}
 * </p>
 * <p>
 *     如何写查询参考{@code https://docs.spring.io/spring-data/jpa/docs/2.7.18/reference/html/#repository-query-keywords}
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/2/2
 */
@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long> {


}
