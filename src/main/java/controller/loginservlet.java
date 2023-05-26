package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;
@WebServlet("/login")
public class loginservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentDao dao = new StudentDao();
		Student student;

		try {
			long mobile = Long.parseLong(email);
			student = dao.fetch(mobile);
		} catch (NumberFormatException e) {
			student = dao.fetch(email);
		}

		if (student == null) {
			resp.getWriter().print("<h1>Invalid email</h1>");
		} else {
			if (student.getPassword().equals(password)) {
				resp.setContentType("text/html");
				resp.getWriter().print("<h1>Login successfull</h1>");

				resp.getWriter().print("<div style='color:yellow'>");
				resp.getWriter()
						.print("<table border='1'>" + "<tr>" + "<th>Id</th>" + "<th>Name</th>" + "<th>Mobile</th>"
								+ "<th>Email</th>" + "<th>Password</th>" + "</tr>" + "<tr>" + "<th>" + student.getId()
								+ "</th>" + "<th>" + student.getName() + "</th>" + "<th>" + student.getMobile()
								+ "</th>" + "<th>" + student.getEmail() + "</th>" + "<th>" + student.getPassword()
								+ "</th>" + "</tr>"+"</table>");
				resp.getWriter().print("</div><br><br>");

				resp.getWriter().print("<div style='color:cyan'>");
				resp.getWriter().print("<table border='1'>" + "<tr>" + "<th>Id</th>" + "<th>Name</th>"
						+ "<th>Mobile</th>" + "<th>Email</th>" + "<th>Password</th>" + "</tr>");
				List<Student> list=dao.fetch();
				for (Student std : list) {
					resp.getWriter()
							.print("<tr>" + "<th>" + std.getId() + "</th>" + "<th>" + std.getName() + "</th>"
									+ "<th>" + std.getMobile() + "</th>" + "<th>" + std.getEmail() + "</th>"
									+ "<th>" + std.getPassword() + "</th>" + "</tr>");
				}
				resp.getWriter().print("</table>");

			} else {
				resp.getWriter().print("<h1>Invalid password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
	}

}