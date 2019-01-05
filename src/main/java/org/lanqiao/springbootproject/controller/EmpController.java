package org.lanqiao.springbootproject.controller;

import org.lanqiao.springbootproject.dao.DepartmentDao;
import org.lanqiao.springbootproject.dao.EmployeeDao;
import org.lanqiao.springbootproject.entities.Department;
import org.lanqiao.springbootproject.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Auther: WDS
 * @Date: 2019/1/4 17:07
 * @Description:
 */
@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String emps(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "list";
    }

    @GetMapping("emp")
    public String toAddEmpPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "addEmp";
    }

    @PostMapping("emp")
    public String saveEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("emp/{id}")
    public String deleteEmp(@PathVariable int id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @GetMapping("emp/{id}")
    public String toUpdateEmpPage(@PathVariable int id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);
        return "addEmp";
    }

    @PutMapping("emp")
    public String modify(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }


}
