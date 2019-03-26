package com.tmh.springbootcrud.controller;

import com.tmh.springbootcrud.dao.DepartmentDao;
import com.tmh.springbootcrud.dao.EmployeeDao;
import com.tmh.springbootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author TMH
 * @date 2018/9/24 - 17:16
 */
@Controller
public class CrudController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Map<String,Object> map){
        map.put("emps",employeeDao.getAll());
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Map<String,Object> map){
        map.put("deps",departmentDao.getDepartments());
        return "emp/add";
    }

    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toBpage(@PathVariable("id")Integer id, Model model){
        model.addAttribute("emp",employeeDao.get(id));
        model.addAttribute("deps",departmentDao.getDepartments());
        return "emp/add";
    }

    @PutMapping("/emp")
    public String rewriter(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
