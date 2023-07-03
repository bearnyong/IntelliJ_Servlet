package com.study.mvc.employee.controller;

import com.study.mvc.employee.model.dto.EmployeeDTO;
import com.study.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*post 요청의 경우 한글이 깨짐 -> reqeust 챕터 필기 확인*/
        req.setCharacterEncoding("UTF-8");

        /*사용자의 요청값을 꺼내옴*/
        String empName = req.getParameter("empName");
        String empNo = req.getParameter("empNo");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        int salary = Integer.parseInt(req.getParameter("salary"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        String managerId = req.getParameter("managerId");
        java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));

        /*(중요)유효성 검사*/
        /*-------*/

        EmployeeService empService = new EmployeeService();
        /*newEmpId의 시퀀스 값 가져오기 위해 작성한 부분*/
        String newEmpId = empService.selectNewEmpId();

        EmployeeDTO emp = new EmployeeDTO();
        String path = null;
        if (newEmpId != null) {
            emp.setEmpId(newEmpId);
            emp.setEmpName(empName);
            emp.setEmpNo(empNo);
            emp.setEmail(email);
            emp.setPhone(phone);
            emp.setDeptCode(deptCode);
            emp.setJobCode(jobCode);
            emp.setSalary(salary);
            emp.setBonus(bonus);
            emp.setManagerId(managerId);
            emp.setHireDate(hireDate);

            System.out.println("emp 값 조회 : " + emp);
            
            /*서비스 등록하는 매서드 호출*/
            int result = empService.insetEmp(emp);

            path = "";
            if (result > 0) {
                path = "/WEB-INF/views/common/successPage.jsp";
                req.setAttribute("successCode", "직원 등록 성공");
            } else {
                path = "/WEB-INF/views/common/errorPage.jsp";
                req.setAttribute("message", "직원 등록 실패");
            }
        } else {
            /*성공도 실패도 아닐 경우 에러 발생 메세지 노출 (에러 매핑페이지 별도 구성)*/
            resp.sendError(500, "사용자 인덱스 호출 오류");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
