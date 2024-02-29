package org.example.mysqlcurdjpa.controller;

import org.example.mysqlcurdjpa.entity.Department;
import org.example.mysqlcurdjpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // Save operation
    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(
            @Validated @RequestBody Department department)
    {
        return ResponseEntity.ok().body(departmentService.saveDepartment(department));
    }

    // Read operation
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> fetchDepartmentList()
    {
        return ResponseEntity.ok().body(departmentService.fetchDepartmentList());
    }


    // Read operation
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> fetchDepartmentById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(departmentService.fetchDepartmentById(id));
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department>
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return ResponseEntity.ok().body(departmentService.updateDepartment(
                department, departmentId));
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public HttpStatus deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
                departmentId);
        return HttpStatus.OK;
    }
}
