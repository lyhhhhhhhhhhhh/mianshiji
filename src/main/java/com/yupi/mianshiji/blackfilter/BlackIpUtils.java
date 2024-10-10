package com.yupi.mianshiji.blackfilter;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author liyuhang
 * @version 1.0
 * @time 2024-10-10-17:03
 **/

@Slf4j
public class BlackIpUtils {

    private static BitMapBloomFilter bloomFilter;

    //判断ip是否在黑名单中
    public static boolean isBlackIp(String ip){
        return bloomFilter.contains(ip);
    }

    /**
     * 重建 Ip 黑名单
     * @param configInfo
      */
    public static void rebuildBlackIp(String configInfo){
        if (StrUtil.isBlank(configInfo)){
            configInfo = "{}";
        }
        //解析配置文件
        Yaml yaml = new Yaml();
        Map map = yaml.loadAs(configInfo, Map.class);
        //获取ID黑名单
        List<String> blackIpList =(List<String>) map.get("blackIpList");
        synchronized (BlackIpUtils.class){
            if (CollUtil.isNotEmpty(blackIpList)){
                // 注意构造参数的设置
                BitMapBloomFilter bitMapBloomFilter =  new BitMapBloomFilter(958506);
                for (String ip : blackIpList){
                    bitMapBloomFilter.add(ip);
                }
                bloomFilter = bitMapBloomFilter;
            }else {
                bloomFilter = new BitMapBloomFilter(100);
            }
        }

    }
}
