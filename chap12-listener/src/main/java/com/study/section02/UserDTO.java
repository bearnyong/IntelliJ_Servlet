package com.study.section02;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserDTO implements HttpSessionBindingListener {

    private String name;
    private int age;

    public UserDTO() {
    }

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*상속받은 메서드*/
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        /*클래스로 만든 인스턴스가 세션에 바인딩(값이 추가되는 것)되는 경우 동작됨*/
        System.out.println("value bound");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        /*클래스로 만든 인스턴스가 세션에 바인딩 해제(값 제거 혹은 세션 만료)하는 경우 동작됨*/
        System.out.println("value unbouded");
    }
}
