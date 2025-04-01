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

@WebServlet("/details")
public class Details extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String email = (String) session.getAttribute("email");
		email.trim();

		Connection connection = ConnectionPool.getConnection();

		try {

			PreparedStatement pstm = connection.prepareStatement("select * from task where email=?");

			pstm.setString(1, email);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				req.setAttribute("name", rs.getString("name"));

				req.setAttribute("uemail", rs.getString("email"));

				req.setAttribute("phone", rs.getLong("cno"));
				req.setAttribute("std", rs.getString("std"));
				req.setAttribute("pwd", rs.getString("password"));

				RequestDispatcher rd = req.getRequestDispatcher("Details.jsp");
				rd.forward(req, resp);
			} else {

				req.setAttribute("error", "No user found with the given email.");
				RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
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
