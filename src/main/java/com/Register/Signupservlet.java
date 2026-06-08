package com.Register;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Signupservlet
 */
@WebServlet("/Signupservlet")
public class Signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("uname");
		String p = request.getParameter("upass");
		String cp = request.getParameter("cpass");
		String e = request.getParameter("uemailId");
		String c = request.getParameter("ucountry");

		if(!p.equals(cp))
		{
		    request.setAttribute("msg",
		            "Password and Confirm Password do not match!");

		    request.getRequestDispatcher("index.jsp")
		           .forward(request, response);

		    return;
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/register", "root", "tanishka");

			PreparedStatement stmt = con
					.prepareStatement("insert into userlogin(uname, upass, uemailId, ucountry) values(?,?,?,?)");

			stmt.setString(1, n);
			stmt.setString(2, p);
			stmt.setString(3, e);
			stmt.setString(4, c);

			int i = stmt.executeUpdate();

			if (i > 0) {
				out.println("You are successfully registered.....");
			}
		} catch (Exception ey) {
			System.out.println(ey);
		}
		out.close();
	}

}
