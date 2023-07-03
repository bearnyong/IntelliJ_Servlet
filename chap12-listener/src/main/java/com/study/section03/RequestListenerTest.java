package com.study.section03;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/*3.2. Request Listener - 작성순서일뿐 동작은 이벤트를 감지해햐함.*/
@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletContextAttributeListener {

    public RequestListenerTest() {
        /*was가 실행될 때 리스너를 생성한다.*/
        System.out.println("reqeust listener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        /*request에 attribute가 추가될 때 호출된다.*/
        System.out.println("request attribute added!!");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        /*request에 attribute가 제거될 때 호출된다.*/
        System.out.println("request attribute Removed!!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent srae) {
        /*reqeust에 attribute가 수정될 때 호출된다.
        * org.apache.catalina.ASYNC_SUPPORTED라는 attribute가 자동 수정되기 때문에 한 번 호출은 된다.
        * 서블릿 3.0에서부터 비동기 방식의 요청 처리를 지원한다는 내용이니 너무 신경쓰지 말자.*/
        System.out.println("request attribute replaced");
        System.out.println(srae.getName() + ", " + srae.getValue());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        /*request 요청이 소멸될 때 호출된다.*/
        System.out.println("request destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        /*reqeust가 생성될 때 호출된다.*/
        System.out.println("request initialized!");
    }
}
