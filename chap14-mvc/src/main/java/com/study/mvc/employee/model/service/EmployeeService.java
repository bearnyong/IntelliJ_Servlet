package com.study.mvc.employee.model.service;

import com.study.mvc.employee.model.dao.EmployeeDAO;
import com.study.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.Objects;

import static com.study.mvc.common.jdbc.JDBCTemplate.close;
import static com.study.mvc.common.jdbc.JDBCTemplate.getConnection;

public class EmployeeService {

    /*데이터베이스 커넥션 정보를 전달해주는 ...*/
    private final EmployeeDAO empDAO;

    public EmployeeService() {
        /*필드에서 직접 초기화 해주기*/
        empDAO = new EmployeeDAO();
    }

    public EmployeeDTO selectOneEmpById(String empId) {

        /*DB Connection 생성*/
        Connection con = getConnection();
        /*비즈니스 로직 실행*/
        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);
        /*DB를 닫아준다.*/
        close(con);

        return selectEmp;
    }
}
