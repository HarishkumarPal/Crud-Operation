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

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection connection = ConnectionPool.getConnection();

		try {
			HttpSession session = req.getSession();

			PreparedStatement pstm = connection.prepareStatement("DELETE FROM task where email=?");

			pstm.setString(1, req.getParameter("email").trim());
			System.out.println(req.getParameter("email").trim());
			int rs = pstm.executeUpdate();
			if (rs > 0) {
				session.invalidate();
				req.setAttribute("msgd", "User Deleted");
				RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
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
