package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：无用类
 *
 * @author 高逸飞
 * @date 2020-3-5
 */
@Data
public class Supply {
    private Integer id;

    private String title;

    private Integer categoryId;

    private String province;

    private String city;

    private String district;

    private String address;

    private String property;

    private String description;

    private Integer sellDateType;

    private Date sellDate;

    private String specificationName;

    private Integer unit;

    private BigDecimal price;

    private Integer startingValue;

    private Integer transportType;

    private Integer clicks;

    private BigDecimal amount;

    private Integer createdBy;

    private Integer updatedBy;

    private Date createdAt;

    private Date updatedAt;

    private Boolean deleted;

}