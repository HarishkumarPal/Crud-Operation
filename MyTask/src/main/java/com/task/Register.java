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

@WebServlet("/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String email = req.getParameter("uemail");
		long phoneNumber = Long.parseLong(req.getParameter("unum"));
		String standard = req.getParameter("ustd");
		String password = req.getParameter("upwd");

		Connection connection = ConnectionPool.getConnection();

		try {
			PreparedStatement chkpstm = connection.prepareStatement("SELECT * FROM task WHERE email=?");
			chkpstm.setString(1, email);
			ResultSet rs = chkpstm.executeQuery();

			if (rs.next()) {

				String msg = "Registeration Already done..please login";
				req.setAttribute("msgr", msg);
				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			} else {

				PreparedStatement ps = connection.prepareStatement("INSERT INTO task VALUES (?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setLong(3, phoneNumber);
				ps.setString(4, standard);
				ps.setString(5, password);

				int eu = ps.executeUpdate();

				if (eu > 0) {
					String msgr1 = "Registeration Successful";
					req.setAttribute("msgr1", msgr1);
					RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
					rd.forward(req, resp);
				} else {
					String msg = "Registeration Failed..Try again";
					req.setAttribute("msgr2", msg);
					RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
					rd.include(req, resp);
				}
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
