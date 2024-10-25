package com.yupi.mianshiji.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.mianshiji.common.ErrorCode;
import com.yupi.mianshiji.exception.ThrowUtils;
import com.yupi.mianshiji.mapper.ManagerNotificationMapper;
import com.yupi.mianshiji.model.dto.notification.NotificationAddRequest;
import com.yupi.mianshiji.model.entity.Notifications;
import com.yupi.mianshiji.model.entity.Question;
import com.yupi.mianshiji.service.ManagerNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author liyuhang
 * @version 1.0
 * @time 2024-10-25-15:35
 **/

@Service
@Slf4j
public class ManagerNotificationServiceImpl extends ServiceImpl<ManagerNotificationMapper, Notifications> implements ManagerNotificationService{


    /**
     * 添加一条通知记录
     * @param notificationAddRequest
     * @param useId
     */
    @Override
    public void addNotification(NotificationAddRequest notificationAddRequest, Long useId) {
        ThrowUtils.throwIf(notificationAddRequest == null, ErrorCode.PARAMS_ERROR);
        //从对象当中取值
        ThrowUtils.throwIf(StringUtils.isBlank(notificationAddRequest.getMessage()), ErrorCode.PARAMS_ERROR);
        ThrowUtils.throwIf(StringUtils.isBlank(notificationAddRequest.getType()), ErrorCode.PARAMS_ERROR);
        Notifications notifications = new Notifications();
        BeanUtils.copyProperties(notificationAddRequest, notifications);
        if (useId != null){
            notifications.setUserId(useId);
        }
        this.baseMapper.insert(notifications);
    }

    /**
     * 根据时间获取最新的记录
     * @return
     */
    @Override
    public Notifications getNotification() {
        LambdaQueryWrapper<Notifications> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Notifications::getEditTime).last("LIMIT 1");;
        //selectOne 期望只返回一条记录，如果数据库中存在多条记录满足条件，通常会抛出异常或者返回第一条找到的记录
        Notifications notifications = this.baseMapper.selectOne(queryWrapper);

        return notifications;
    }

}
