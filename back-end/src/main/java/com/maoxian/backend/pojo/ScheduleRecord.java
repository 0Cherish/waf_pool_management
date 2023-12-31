package com.maoxian.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Lin
 * @date 2023/12/19 23:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRecord {

    private Long id;
    private Long time;
    private Boolean pass;
    private Long wafId;
    private Long requestId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
