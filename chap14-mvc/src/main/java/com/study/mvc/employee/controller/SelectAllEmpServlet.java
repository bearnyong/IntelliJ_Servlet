package com.study.mvc.employee.controller;

import com.study.mvc.employee.model.dto.EmployeeDTO;
import com.study.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDTO> empList = employeeService.selectAllEmp();

        for (EmployeeDTO employee : empList) {
            System.out.println(employee);
        }

        String path = "";
        if (empList != null) {
            path = "/WEB-INF/views/employee/employeelist.jsp";
            req.setAttribute("empList", empList);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 목록 조회 실패");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
