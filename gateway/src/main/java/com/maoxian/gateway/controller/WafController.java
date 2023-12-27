package com.maoxian.gateway.controller;

import com.maoxian.gateway.exceprion.RequestException;
import com.maoxian.gateway.pojo.Waf;
import com.maoxian.gateway.pojo.WafMonitor;
import com.maoxian.gateway.service.WafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lin
 * @date 2023/10/11 3:14
 */
@RestController
@RequestMapping("waf")
@PreAuthorize("hasAuthority('waf')")
public class WafController {

    @Autowired
    private WafService wafService;

    /**
     * 查询所有waf
     *
     * @return 查询结果
     */
    @GetMapping
    public List<Waf> queryWaf() {
        return wafService.findWafList();
    }

    @GetMapping("status/{wafId}")
    public WafMonitor queryWafStatus(@PathVariable Integer wafId) {
        return wafService.findWafStatusById(wafId);
    }

    //TODO 将废弃
    @GetMapping("{id}")
    public Waf queryWaf(@PathVariable Integer id) {
        return wafService.findWafById(id);
    }

    /**
     * 增加waf
     *
     * @param waf waf信息
     */
    @PostMapping
    public void addWaf(@RequestBody Waf waf) {
        String name = waf.getName();
        String ip = waf.getIp();
        Integer port = waf.getPort();
        String configUrl = waf.getConfigUrl();
        if (name == null || name.isEmpty()) {
            throw new RequestException("名称不能为空");
        }
        if (ip == null || ip.isEmpty()) {
            throw new RequestException("ip不能为空");
        }
        if (port == null) {
            throw new RequestException("端口不能为空");
        }
        if (configUrl == null || configUrl.isEmpty()) {
            throw new RequestException("配置地址不能为空");
        }
        wafService.addOrModifyWaf(waf);
    }

    /**
     * 修改waf
     *
     * @param waf waf信息
     */
    @PutMapping
    public void updateWaf(@RequestBody Waf waf) {
        Long id = waf.getId();
        if (id == null) {
            throw new RequestException("id不能为空");
        }
        wafService.addOrModifyWaf(waf);
    }

    /**
     * 通过id删除waf
     *
     * @param id 删除条件
     */
    @DeleteMapping("{id}")
    public void deleteWaf(@PathVariable Integer id) {
        wafService.deleteWafById(id);
    }
}