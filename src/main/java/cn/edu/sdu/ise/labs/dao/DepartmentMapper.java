package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Department record);
}