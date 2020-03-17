package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.Date;

/**
 * 描述：无用类
 *
 * @author 高逸飞
 * @date 2020-3-5
 */
@Data
public class KeyMaxValue {
    private Integer id;

    private String tenantCode;

    private String keyPrefix;

    private String datePart;

    private Integer currentValue;

    private Date updatedAt;

}