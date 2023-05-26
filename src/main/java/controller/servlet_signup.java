package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/signup")
public class servlet_signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Student student = new Student();
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setMobile(Long.parseLong(req.getParameter("mobile")));
		student.setPassword(req.getParameter("password"));
		student.setGender(req.getParameter("gender"));
		
		StudentDao dao=new StudentDao();
		dao.save(student);
		
		res.getWriter().print("<h1>Data Saved Successfully</h1>");
		req.getRequestDispatcher("login.html").include(req, res);

	}

}
