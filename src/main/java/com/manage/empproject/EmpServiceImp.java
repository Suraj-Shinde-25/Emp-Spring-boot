package com.manage.empproject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmpServiceImp implements EmpService{
    @Autowired
    EmpRepository empRepository;
    @Override
    public String createEmp(Employee employee) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(employee,empEntity);
        empRepository.save(empEntity);
        return "Employee Create successfully";
    }
    @Override
    public List<Employee> getAllEmp() {
        List<EmpEntity> empEntityList = empRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmpEntity empEntity: empEntityList){
            Employee emp = new Employee();
            emp.setId(empEntity.getId());
            emp.setNo(empEntity.getNo());
            emp.setName(empEntity.getName());
            emp.setEmail(empEntity.getEmail());
            employees.add(emp);
        }
        return employees;
    }
    @Override
    public boolean deleteEmp(Long id) {
        EmpEntity emp = empRepository.findById(id).get();
        empRepository.delete(emp);
        return true;
    }
    @Override
    public Employee getEmpById(Long id) {
        EmpEntity emp = empRepository.findById(id).get();
        Employee emp1 = new Employee();
        BeanUtils.copyProperties(emp,emp1);
        return emp1;
    }
    @Override
    public String updateEmp(Long id, Employee employee) {
        EmpEntity oldEmp = empRepository.findById(id).get();
        oldEmp.setNo(employee.getNo());
        oldEmp.setName(employee.getName());
        oldEmp.setEmail(employee.getEmail());
        empRepository.save(oldEmp);
        return "Update successfully";
    }
}
