package com.study.section01;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*1.2. context Listener*/
@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /* 리스너는 특정 이벤트 행위가 동작할 때 컨테이너에 의해 호출되는 메소드를 인터페이스에 정의해 두었다.
    *  이를 상속받아 구현한 메소드가 특정 이벤트 발생에 대한 피룡한 로직을 작성하는데, 크게 3가지 범주의 이벤트로 분류한다.
    *  1. context(-> 톰캣 컨테이너 자체에 리스너 연결)
    *    1.1. ServletContextListener : 웹애플리케이션의 시작, 종료에 대한 이벤트 리스너
    *    1.2. ServletContextAttributeListener : context에 attribute를 추가, 제거, 수정에 대한 이벤트 리스너
    *  2. session(-> 세션에서 발생 가능한 이벤트)
    *    2.1. HttpSessionListner : http 세션의 시작, 종료에 대한 이벤트 리스너
    *    2.2. HttpSessionAttributeListener : HttpSession에 attribute 추가, 제거, 수정에 대한 이벤트 리스너
    *  3. request(-> equest 관련 이벤트)
    *    3.1. ServletRequestListener : servletRequest 생성과 소멸에 대한 이벤트 리스너
    *    3.2. ServletRequest에 attribute를 추가, 제거, 수정하는 것에 대한 이벤트 리스너 */

    public ContextListenerTest() {
        System.out.println("Context Listner 인스턴스 생성");
    }

    /*이벤트 감지를 위해 ServletContextListener, ServletContextAttributeListener 인터페이스를 상속받았다.*/

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Context attribute added!");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Context attributeRemoved!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("Context attributeReplaced!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context contextInitialized!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context contextDestroyed!");
    }
}
