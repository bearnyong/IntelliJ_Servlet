package com.study.mvc.employee.controller;

import com.study.mvc.employee.model.dto.EmployeeDTO;
import com.study.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    @Override /*form에서 데이터 전송 시 post로 전송하기 때문에 해당 메서드가 호출된다.*/
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String empId = req.getParameter("empId");
        java.sql.Date entDate = java.sql.Date.valueOf(req.getParameter("entDate"));

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEntDate(entDate);

        /*작성후 서비스로 이동*/
        int result = new EmployeeService().updateEmp(emp);

        String path = "";
        if (result > 0) {
            /*사용자에게 보여줄 화면의 경로를 지정한다.*/
            path = "/WEB-INF/views/common/successPage.jsp";
            /*front화면에서 값을 꺼내올 때 아래의 key를 기준으로 꺼내온다.*/
            req.setAttribute("successCode", "직원 정보 수정 성공");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 정보 수정 실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
