package com.maoxian.mapper;

import com.maoxian.pojo.Perm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermMapper {
    /**
     * 通过用户id查询权限
     *
     * @param userId 查询条件
     * @return 用户权限
     */
    List<String> selectByUserId(Integer userId);

    /**
     * 增加权限
     *
     * @param perm 权限
     */
    int insert(Perm perm);

    /**
     * 更新权限
     *
     * @param perm 权限
     */
    int update(Perm perm);

    /**
     * 通过id删除权限
     *
     * @param id 删除条件
     */
    int deleteById(Integer id);
}