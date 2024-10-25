package com.yupi.mianshiji.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author liyuhang
 * @version 1.0
 * @time 2024-10-25-15:20
 **/


@TableName(value = "notification")
@Data
public class Notifications {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 内容
     */
    private String message;

    /**
     * 标签列表（json 数组）
     */
    private String type;


    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 编辑时间
     */
    private Date editTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
