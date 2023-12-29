package com.maoxian.gateway.service;

import com.maoxian.gateway.dto.RequestStatusDTO;
import com.maoxian.gateway.dto.WafIpDTO;
import com.maoxian.gateway.dto.WafPoolDTO;

import java.util.List;

/**
 * @author Lin
 * @date 2023/11/23 14:30
 */
public interface StatService {
    /**
     * 获取waf的上线情况
     *
     * @return waf池状态
     */
    WafPoolDTO findWafPoolStatus();

    /**
     * 计算一分钟之内所有请求的平均请求时间
     *
     * @return 平均请求时间
     */
    Integer findAvgRequestTimePerMinute();

    /**
     * 获取请求成功失败的情况
     *
     * @return 请求情况
     */
    RequestStatusDTO getRequestStatus();

    /**
     * 获取waf的IP
     *
     * @return waf信息
     */
    List<WafIpDTO> getWafIp();
}