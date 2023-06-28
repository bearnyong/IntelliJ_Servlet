package com.study.section03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/status")
public class StatusCodeTestservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req/*요청*/, HttpServletResponse resp/*응답*/) throws ServletException, IOException {

        /* 사용자가 잘못된 요청을 하는 경우 */
//        resp.sendError(404, "없는 페이지 입니다. 경로를 다시 확인해 주세요.");

        /* */
        resp.sendError(500, "서버에 문제가 발생되엇습니다. 서버는 여러분이 개발 하였으니 여러분 잘못 입니다.");
    }
}
