package com.maoxian.backend.service;

import com.maoxian.backend.pojo.Waf;
import com.maoxian.backend.pojo.WafMonitor;

import java.util.List;

/**
 * @author Lin
 * @date 2023/10/11 3:14
 */
public interface WafService {

    /**
     * 查询所有waf
     *
     * @return waf列表
     */
    List<Waf> findWafList();

    /**
     * 查询waf的监控数据
     *
     * @param id wafId
     * @return 查询结果
     */
    WafMonitor findWafMonitorById(Long id);

    /**
     * 增加或更新waf
     *
     * @param waf waf信息
     */
    void addOrModifyWaf(Waf waf);

    /**
     * 上线waf
     *
     * @param id wafId
     */
    void online(Long id);

    /**
     * 下线waf
     *
     * @param id wafId
     */
    void offline(Long id);

    /**
     * 根据镜像创建waf实例
     *
     * @param name    waf名
     * @param imageId 镜像id
     */
    void createWafByImageId(String name, Long imageId);

    /**
     * 通过id删除waf
     *
     * @param id 删除条件
     */
    void deleteWafById(Integer id);
}
