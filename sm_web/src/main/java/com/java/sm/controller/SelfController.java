package com.java.sm.controller;

import com.java.sm.bean.Staff;
import com.java.sm.service.SelfService;
import com.java.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("selfController")
public class SelfController {
   @Autowired
    private SelfService selfService;

   @Autowired
   private StaffService staffService;
   public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("login.jsp").forward(request,response);
   }
   public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String account = request.getParameter("account");
       String password = request.getParameter("password");
       Staff staff = selfService.login(account,password);

       if(staff!=null){
           request.getSession().setAttribute("USER",staff);
           request.getRequestDispatcher("index.jsp").forward(request,response);
       }else{
           response.sendRedirect("toLogin.do");
       }
   }

   public  void info(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("../info.jsp").forward(request,response);
   }
   public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
       request.getSession().setAttribute("USER",null);
       response.sendRedirect(request.getContextPath()+"/toLogin.do");
   }
   public void toChangePassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("../change_password.jsp").forward(request,response);
   }

    public void changePassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
       String password = request.getParameter("password");
       String password1 = request.getParameter("password1");
       Staff staff =(Staff) request.getSession().getAttribute("USER");
        System.out.println(staff.toString());
       if(!staff.getPassword().equals(password)){
          response.sendRedirect("toChangePassword.do");
       }else{
           staff.setPassword(password1);
           staffService.edit(staff);
           request.getSession().setAttribute("USER",null);
           response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
       }
    }
}
