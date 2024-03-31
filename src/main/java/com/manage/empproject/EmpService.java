package com.manage.empproject;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmpService {
    String createEmp(Employee employee);
    List<Employee> getAllEmp();
    boolean deleteEmp(Long id);
    Employee getEmpById(Long id);
    String updateEmp(Long id, Employee employee);
}
