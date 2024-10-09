package com.yupi.mianshiji.model.dto.questionBank;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 编辑题库请求
 *


 */
@Data
public class QuestionBankEditRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片
     */
    private String picture;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}