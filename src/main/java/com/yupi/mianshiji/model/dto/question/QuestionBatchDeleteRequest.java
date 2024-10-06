package com.yupi.mianshiji.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 批量题目请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://www.code-nav.cn">编程导航学习圈</a>
 */
@Data
public class QuestionBatchDeleteRequest implements Serializable {

    /**
     * 题目Id列表
     */
    private List<Long> questionIds;

    private static final long serialVersionUID = 1L;
}