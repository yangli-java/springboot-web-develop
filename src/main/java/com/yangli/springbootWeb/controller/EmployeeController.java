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

    /**
     * 员工添加，springMvc会自动将请求参数和入参对象的属性进行一一绑定，但前提是请求参数的参数名必须与入参对象的属性名相一致。
     * 即请求参数在HTML中的name属性与对象的属性名一致
     * @param employee
     * @return
     */
    @GetMapping("/addEmployee")
    public String saveEmployee(Employee employee){
        System.err.println(employee);
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址;forward：表示转发到一个地址
        return "redirect:/getEmployees";
    }

    @GetMapping("/delEmployee")
    public String delEmployee(Integer id){
        employeeDao.delete(id);
        return "redirect:/getEmployees";
    }

}
