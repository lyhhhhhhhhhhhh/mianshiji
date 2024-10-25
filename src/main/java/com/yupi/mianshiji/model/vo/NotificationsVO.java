package com.yupi.mianshiji.model.vo;

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
public class NotificationsVO {

    /**
     * id
     */
    private Long id;

    /**
     * 内容
     */
    private String message;

    /**
     * 类型
     */
    private String type;


    /**
     * 创建用户 id
     */
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
