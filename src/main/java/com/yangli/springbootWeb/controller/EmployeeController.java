package com.yangli.springbootWeb.controller;

import com.yangli.springbootWeb.dao.EmployeeDao;
import com.yangli.springbootWeb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yangli
 * Date: 2018-10-25
 * Time: 21:25
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/getEmployees")
    public String getList(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "/emps/list";
    }

}
