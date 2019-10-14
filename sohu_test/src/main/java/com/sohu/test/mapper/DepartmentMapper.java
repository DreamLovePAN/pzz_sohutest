package com.sohu.test.mapper;

import com.sohu.test.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    //按照ID查找部门信息
    public Department searchById(Integer dept_id);

    //查找部门的所有信息
    public List<Department> searchAll();
}
