package com.study.mvc.employee.model.service;

import com.study.mvc.employee.model.dao.EmployeeDAO;
import com.study.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

import static com.study.mvc.common.jdbc.JDBCTemplate.*;

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

    public String selectNewEmpId(){

        /*DB Connection을 생성함*/
        Connection con = getConnection();

        /*비지니스 로직 수행*/
        String newEmpId = empDAO.selectNewEmpId(con);

        /*Connection 닫기*/
        close(con);

        return newEmpId;
    }

    public int insetEmp(EmployeeDTO emp) {

        /*DB Connection을 생성함*/
        Connection con = getConnection();

        /*비지니스 로직 수행*/
        int result = empDAO.insetEmp(con, emp);
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        /*Connection 닫기*/
        close(con);

        return result;
    }

    public List<EmployeeDTO> selectAllEmp() {

        /*DB Connection을 생성함*/
        Connection con = getConnection();

        List<EmployeeDTO> empList = empDAO.selectAllEmp(con);
        close(con);

        return empList;
    }

    public int updateEmp(EmployeeDTO emp) {

        /*DB Connection을 생성함*/
        Connection con = getConnection();

        /*비즈니스 로직 수행 -> 작성후 empDAO파일에 매서드 추가*/
        int result = empDAO.updateEmp(con, emp);

        /*오류가 날 수도 있기 때문에 if문 작성*/
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }
}
