package com.study.mvc.employee.model.dao;

import com.study.mvc.common.config.ConfigLocation;
import com.study.mvc.common.jdbc.JDBCTemplate;
import com.study.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.study.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();
        try {
            /*DAO를 호출했을 때 매퍼 어쩌구*/
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION/*매퍼연결*/ + "employee-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EmployeeDTO selectEmpById(/*커넥션 정보 넘기면서 어쩌구...*/Connection con, String empId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO selectEmp = null;

        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1/*첫 번째 물음표에*/, empId/*empId를 담아준다.*/);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectEmp = new EmployeeDTO();
                selectEmp.setEmpId(rset.getString("EMP_ID"));
                selectEmp.setEmpName(rset.getString("EMP_NAME"));
                selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEmp.setJobCode(rset.getString("JOB_CODE"));
                selectEmp.setSalary(rset.getInt("SALARY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return selectEmp;
    }
    
    public EmployeeDAO(Properties prop) {
        this.prop = prop;
    }

    public String selectNewEmpId(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String newEmpId = null;
        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                newEmpId = rset.getString("NEXTVAL");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return newEmpId;
    }

    /*직원 등록*/
    public int insetEmp(Connection con, EmployeeDTO emp) {

        PreparedStatement pstmt = null;

        int result = 0;
        String query = prop.getProperty("insetEmp");

        try {
            /*값 매핑시켜주기*/
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());
            /*반환되는 자료형과 맞춰준다. empDTO.salary 자료형은 int로 정의됨*/
            pstmt.setInt(8, emp.getSalary());
            /*empDTO.bonus 자료형은 double로 정의됨*/
            pstmt.setDouble(9, emp.getBonus());
            pstmt.setString(10, emp.getManagerId());
            pstmt.setDate(11, emp.getHireDate());
            /*반환되는 데이터는 int값이다. (성공하면 1, 실패하면 0)*/
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public List<EmployeeDTO> selectAllEmp(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        List<EmployeeDTO> empList = null;

        String query = prop.getProperty("selectAllEmp");

        /*쿼리 짜고 다시 넘어오기*/
        try {
            stmt = con.createStatement();
            /*쿼리 돌린 경과를 rset에 넣어준다.*/
            rset = stmt.executeQuery(query);

            empList = new ArrayList<>();

            while (rset.next()) {
                /*쿼리에 있는 값 매핑...*/
                EmployeeDTO emp = new EmployeeDTO();
                emp.setEmpId(rset.getString("EMP_ID"/*쿼리 작성 값*/));
                emp.setEmpName(rset.getString("EMP_NAME"));
                emp.setEmpNo(rset.getString("EMP_NO"));
                emp.setEmail(rset.getString("EMAIL"));
                emp.setPhone(rset.getString("PHONE"));
                emp.setDeptCode(rset.getString("DEPT_CODE"));
                emp.setJobCode(rset.getString("JOB_CODE"));
                emp.setSalLevel(rset.getString("SAL_LEVEL"));
                emp.setBonus(rset.getDouble("BONUS"));
                emp.setSalary(rset.getInt("SALARY"));
                emp.setManagerId(rset.getString("MANAGER_ID"));
                emp.setHireDate(rset.getDate("HIRE_DATE"));
                emp.setEntYn(rset.getString("ENT_YN"));

                /*empList에 값 계속 추가해주기...*/
                empList.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace(); //오류 보여줌
        } finally {
            close(rset);
            close(stmt);
        }

        System.out.println(empList);
        return empList;
    }

    public int updateEmp(Connection con, EmployeeDTO emp) {
        
        PreparedStatement pstmt = null;

        /*작성 후 쿼리 작성 (employee-mapper.xml)파일로*/
        String query = prop.getProperty("updateEmp");

        /*쿼리 작성후 돌아와서 작성해요...*/
        int result = 0;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setDate(1, emp.getEntDate());
            pstmt.setString(2, emp.getEmpId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
        /*작성 후 successPage로 이동...?*/
    }
}
