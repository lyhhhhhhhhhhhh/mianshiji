package com.yupi.mianshiji.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.mianshiji.model.dto.notification.NotificationAddRequest;
import com.yupi.mianshiji.model.entity.Notifications;

/**
 * @author liyuhang
 * @version 1.0
 * @time 2024-10-25-15:32
 **/

public interface ManagerNotificationService extends IService<Notifications> {

    void addNotification(NotificationAddRequest notificationAddRequest, Long useId);

    Notifications getNotification();
}
