package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.CompetitionEvent;

/**
 * 描述:
 * auth:高逸飞
 */
public interface CompetitionEventMapper {
    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insert(CompetitionEvent record);

    /**
     * 通过一条主键选择一条记录
     *
     * @param id
     * @return CompetitionEvent
     */
    CompetitionEvent selectByPrimaryKey(Integer id);

    /**
     * 通过主键更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(CompetitionEvent record);
}