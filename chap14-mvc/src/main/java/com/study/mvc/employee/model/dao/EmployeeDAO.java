package com.study.mvc.employee.model.dao;

import com.study.mvc.common.config.ConfigLocation;
import com.study.mvc.common.jdbc.JDBCTemplate;
import com.study.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            pstmt.setString(1, empId);

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
}
