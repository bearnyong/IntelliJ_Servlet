package com.study.mvc.employee.controller;

import com.study.mvc.employee.model.dto.EmployeeDTO;
import com.study.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmployeeIdServlet extends HttpServlet {

    @Override
    protected void doGet/*뭐시깽이 요청을 get으로 받았기 때문에 doget*/(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        System.out.println("empId" + empId);

        if (empId.isEmpty()) {
            resp.sendError(404, "니가 잘못했어..............");
        }

        /*비즈니스 로직 호출*/
        EmployeeService empService = new EmployeeService();
        EmployeeDTO selectEmp = empService.selectOneEmpById(empId);

        System.out.println("selecteEmp : " + selectEmp/*.toString()*/);

        String path = "";
        if (selectEmp != null) {
            /*사용자에게 보여줄 화면의 경로를 지정한다.*/
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            /*front화면에서 값을 꺼내올 때 아래의 key를 기준으로 꺼내온다.*/
            req.setAttribute("selectedEmp"/*showEmpInfo.jsp 값 연결*/, selectEmp);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 정보 조회 실패!!");
        }
        req.getRequestDispatcher(path).forward(req, resp);

        /*이 응답들을 showEmpInfo.jsp로 넘겨준다.(?)*/
    }
}
