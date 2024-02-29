package org.example.mysqlcurdjpa.service;

import org.example.mysqlcurdjpa.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    // Read operation
    List<Department> fetchDepartmentList();

    //Read operation
    Department fetchDepartmentById(Long id);

    // Update operation
    Department updateDepartment(Department department,
                                Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);
}
