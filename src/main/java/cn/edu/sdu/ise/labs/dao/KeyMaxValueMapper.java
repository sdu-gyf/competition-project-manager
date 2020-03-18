package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.KeyMaxValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component(value = "keyMaxValueMapper")
public interface KeyMaxValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeyMaxValue record);

    int insertSelective(KeyMaxValue record);

    KeyMaxValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeyMaxValue record);

    int updateByPrimaryKey(KeyMaxValue record);

    /**
     * 根据前缀查询当前值
     *
     * @param keyPrefix  前缀
     * @param datePart   日期部分
     * @param tenantCode 租户代码
     * @return 当前值
     */
    KeyMaxValue getKeyValue(
            @Param("keyPrefix") String keyPrefix,
            @Param("datePart") String datePart,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据当前值回写业务主键最大值表
     *
     * @param keyPrefix    前缀
     * @param datePart     日期部分
     * @param currentValue 当前值
     * @param tenantCode   租户代码
     */
    void insertAndUpdate(@Param("keyPrefix") String keyPrefix,
                         @Param("datePart") String datePart,
                         @Param("currentValue") Integer currentValue,
                         @Param("tenantCode") String tenantCode);
}