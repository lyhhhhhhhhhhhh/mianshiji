package com.yupi.mianshiji.model.dto.questionBankQuestion;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @author liyuhang
 * @version 1.0
 * @time 2024-09-17-16:14
 **/

@Data
public class QuestionBankQuestionRemoveRequest implements Serializable {

    /**
     * 题库id
     */
    private Long questionBankId;

    /**
     * 题目id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;

}
