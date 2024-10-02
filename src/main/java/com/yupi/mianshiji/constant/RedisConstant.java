package com.yupi.mianshiji.constant;

/**
 * Redis常量
 */
public interface RedisConstant {
    /**
     * 用户签到记录的Redis key前缀
     */
    String USER_SIGN_IN_REDIS_KEY_PREFIX = "user:signins";

    /**
     * 获取用户钱到的记录的redis key
     * @param year 年份
     * @param userId 用户id
     * @return 拼接好的redisKey
     */
    static String getUserSignInRedisKey(int year,long userId){

        return String.format("%s:%s:%s", USER_SIGN_IN_REDIS_KEY_PREFIX, year, userId );
    }
}

