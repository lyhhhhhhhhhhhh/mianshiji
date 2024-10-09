package com.yupi.mianshiji.esdao;

import com.yupi.mianshiji.model.dto.question.QuestionEsDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: Liyuhang
 * @date: 7/10/2024 下午4:16
 * @Description:
 */
public interface QuestionEsDao extends ElasticsearchRepository<QuestionEsDTO,Long> {
}
