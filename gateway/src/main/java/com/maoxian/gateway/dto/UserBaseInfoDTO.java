package com.maoxian.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lin
 * @date 2023/10/11 3:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBaseInfoDTO {
    private Integer id;
    private String username;
    private String email;
    private String status;
}