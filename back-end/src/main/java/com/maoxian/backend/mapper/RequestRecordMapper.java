package com.maoxian.backend.mapper;

import com.maoxian.backend.pojo.RequestRecord;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Lin
 * @date 2023/11/5 9:14
 */
@Mapper
public interface RequestRecordMapper {

    /**
     * 查询记录数：模糊查询
     *
     * @param uuid 模糊查询字段
     * @return 记录数
     */
    Integer count(String uuid);

    /**
     * 查询指定状态请求的数量
     *
     * @param status 请求状态
     * @return 符合条件的个数
     */
    Integer countForStatus(Integer status);

    /**
     * 查询请求列表：分页+模糊查询
     *
     * @param start    开始位置
     * @param pageSize 查询个数
     * @param uuid     模糊查询字段
     * @return 请求列表
     */
    List<RequestRecord> selectList(int start, int pageSize, String uuid);

    /**
     * 通过id查询请求模式
     *
     * @param id id
     * @return 请求模式
     */
    Integer selectModeById(Long id);

    /**
     * 查询指定时间之后的所有请求的请求时间
     *
     * @param targetTime 指定时间
     * @return 请求时间列表
     */
    List<Integer> selectRequestTimeAfterTargetTime(LocalDateTime targetTime);
}
