package com.maoxian.backend.dto;

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
    private Long id;
    private String username;
    private String email;
}
