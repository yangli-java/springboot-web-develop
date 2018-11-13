package com.yangli.springbootWeb.controller;

import com.yangli.springbootWeb.dao.DepartmentDao;
import com.yangli.springbootWeb.dao.EmployeeDao;
import com.yangli.springbootWeb.entities.Department;
import com.yangli.springbootWeb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
    @Autowired
    DepartmentDao departmentDao;

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

    /**
     * 删除员工
     * @param id
     * @return
     */
    @GetMapping("/delEmployee")
    public String delEmployee(Integer id){
        employeeDao.delete(id);
        return "redirect:/getEmployees";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(Integer id,Model model){
        System.err.println(id);
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "/emps/updateEmployee";
    }

    @GetMapping("/toUpdateEmployee")
    public String toUpdateEmployee(Employee employee) {
        System.err.println(employee);
        Employee employee1 = employeeDao.get(employee.getId());
        System.err.println(employee1);
        employee1.setEmail(employee.getEmail());
        employee1.setLastName(employee.getLastName());
        Department department = departmentDao.getDepartment(employee.getDepartment().getId());
        employee1.setDepartment(department);
        employee1.setGender(employee.getGender());
        employee1.setBirth(employee.getBirth());
        return "redirect:/getEmployees";
    }
}
