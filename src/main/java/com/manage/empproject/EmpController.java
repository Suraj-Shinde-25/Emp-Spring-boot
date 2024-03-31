package com.manage.empproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;
    @GetMapping("/employee")
    public List<Employee> getAllEmp(){
        return empService.getAllEmp();
    }
    @PostMapping("/employee")
    public String insertEmp(@RequestBody Employee employee){
        return empService.createEmp(employee);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if (empService.deleteEmp(id))
            return "Delete Successfully";
        return "Not Found";
    }
    @GetMapping("/employee/{id}")
    public Employee getEmpById(@PathVariable Long id){
        return empService.getEmpById(id);
    }
    @PutMapping("/employee/{id}")
    public String updateEmp(@PathVariable Long id, @RequestBody Employee employee){
        return empService.updateEmp(id,employee);
    }
}
