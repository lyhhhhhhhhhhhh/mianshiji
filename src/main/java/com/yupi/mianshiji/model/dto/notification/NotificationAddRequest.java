package com.yupi.mianshiji.model.dto.notification;

import lombok.Data;

/**
 * @author liyuhang
 * @version 1.0
 * @time 2024-10-25-16:02
 **/

@Data
public class NotificationAddRequest {

    /**
     * 消息
     */
    private String message;

    /**
     * 类型
     */
    private String type;


    private static final long serialVersionUID = 1L;

}
