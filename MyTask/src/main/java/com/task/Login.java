package com.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("uemail");
		String password = req.getParameter("upass");

		Connection connection = ConnectionPool.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM task WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String dbname = rs.getString(1);
				String dbemail = rs.getString(2);
				long phone = rs.getLong(3);
				String std = rs.getString(4);
				String dbpassword = rs.getString(5);

				if (dbemail.equals(email) && dbpassword.equals(password)) {
					HttpSession session = req.getSession();
					session.setAttribute("name", dbname);
					session.setAttribute("email", dbemail);
					session.setAttribute("phone", phone);
					session.setAttribute("std", std);
					session.setAttribute("password", dbpassword);

					RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
					rd.forward(req, resp);

				} else {
					String msg = "Wrong Password or Email";
					req.setAttribute("msgl1", msg);
					RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
					rd.include(req, resp);
				}
			} else {
				req.setAttribute("msgl2", "User Not Registered");
				RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.submitConnection(connection);
		}

	}
}
