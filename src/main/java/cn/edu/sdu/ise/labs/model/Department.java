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
public class Department {
    private Integer id;

    private String tenantCode;

    private String departmentCode;

    private String departmentName;

    private String contact;

    private String contactPhone;

    private String description;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

    private Byte deleted;

}