package com.sohu.test.service;

import com.sohu.test.bean.Department;
import com.sohu.test.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    //按照ID查找部门信息
    public Department searchById(Integer dept_id){

        return departmentMapper.searchById(dept_id);
    }
    //查找部门的信息
    public List<Department> searchAll(){
        return departmentMapper.searchAll();
    }
}
