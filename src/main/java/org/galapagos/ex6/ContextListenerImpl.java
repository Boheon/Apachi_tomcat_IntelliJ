package org.galapagos.ex6;

import org.galapagos.common.JDBCUtil;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListenerImpl implements ServletContextListener {
    public ContextListenerImpl() {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("웹 어플리케이션 초기화");
        ServletContext sc = servletContextEvent.getServletContext();

        String driver = sc.getInitParameter("driver");
        String dburl = sc.getInitParameter("dburl");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        //JDBC 연결
        try{
            JDBCUtil.connect(driver, dburl, username, password);
            System.out.println("DB 연결 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("웹 어플리케이션 제거");
        JDBCUtil.close();
    }
}
