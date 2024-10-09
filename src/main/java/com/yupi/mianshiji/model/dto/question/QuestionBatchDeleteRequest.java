package com.yupi.mianshiji.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 批量题目请求
 *


 */
@Data
public class QuestionBatchDeleteRequest implements Serializable {

    /**
     * 题目Id列表
     */
    private List<Long> questionIds;

    private static final long serialVersionUID = 1L;
}