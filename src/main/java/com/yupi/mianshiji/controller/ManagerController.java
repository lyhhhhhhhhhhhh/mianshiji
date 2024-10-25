package com.yupi.mianshiji.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.yupi.mianshiji.common.BaseResponse;
import com.yupi.mianshiji.common.ResultUtils;
import com.yupi.mianshiji.constant.UserConstant;
import com.yupi.mianshiji.mapper.ManagerNotificationMapper;
import com.yupi.mianshiji.model.dto.notification.NotificationAddRequest;
import com.yupi.mianshiji.model.entity.Notifications;
import com.yupi.mianshiji.model.entity.User;
import com.yupi.mianshiji.model.vo.NotificationsVO;
import com.yupi.mianshiji.service.ManagerNotificationService;
import com.yupi.mianshiji.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.Notification;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liyuhang
 * @version 1.0
 * @time 2024-10-25-15:13
 **/

@RestController
@RequestMapping
public class ManagerController {

    @Resource
    private ManagerNotificationService managerNotificationService;

    @Resource
    private UserService userService;


    //添加一条通知 以及类型
    @PostMapping("/add/notification")
    @SaCheckRole(UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> addNotification(@RequestBody NotificationAddRequest notificationAddRequest, HttpServletRequest request){
        User loginUser = userService.getLoginUser(request);
        managerNotificationService.addNotification(notificationAddRequest, loginUser.getId());
        return ResultUtils.success(true);
    }

    //根据时间获取最后一条通知记录
    @GetMapping("/get/notification")
    public BaseResponse<NotificationsVO> getNotification(){
        Notifications notification = managerNotificationService.getNotification();
        NotificationsVO notificationsVO = new NotificationsVO();
        BeanUtils.copyProperties(notification, notificationsVO);
        return ResultUtils.success(notificationsVO);
    };

}
