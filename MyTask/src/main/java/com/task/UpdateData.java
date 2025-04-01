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

@WebServlet("/change")
public class UpdateData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("uemail");
		String name = req.getParameter("uname");
		long phone = Long.parseLong(req.getParameter("unum"));
		String std = req.getParameter("ustd");
		String pass = req.getParameter("upwd");

		Connection connection = ConnectionPool.getConnection();
		try {

			PreparedStatement pstm = connection
					.prepareStatement("UPDATE task SET name=?,cno=?,std=?,password=? WHERE email=?");
			pstm.setString(1, name);
			pstm.setLong(2, phone);
			pstm.setString(3, std);
			pstm.setString(4, pass);
			pstm.setString(5, email);
			int n = pstm.executeUpdate();
			if (n > 0) {

				req.setAttribute("name", name);
				String msg = "data updated";
				req.setAttribute("msgu", msg);
				RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
				rd.forward(req, resp);

			} else {
				String msg = "data not updated";
				req.setAttribute("msgu", msg);
				RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
				rd.forward(req, resp);
			}

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.submitConnection(connection);
		}
	}
}
