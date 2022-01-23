package studyeasy.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import studyeasy.org.entity.Users;
import studyeasy.org.model.UsersModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		switch (page) {
		case "addusers":
			addUserFormLoader(request, response);
			break;
		case "listusers":
			listUsers(request, response);
			break;
		case "updateuser":
			updateUserFormLoader(request, response);
			break;
		case "deleteuser":
			deleteUser(Integer.parseInt(request.getParameter("userId")));
			listUsers(request, response);
			break;
		default:
			errorPage(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is addUserOperation");
		String operation = req.getParameter("form");
		System.out.println("Operation = " + operation);
		operation = operation.toLowerCase();
		switch (operation) {
		case "adduseroperation":
			Users newUser = new Users(req.getParameter("username"), req.getParameter("email"));
			addUserOperation(dataSource, newUser);
			System.out.println("OperationCpntroller");
			listUsers(req, resp);
			break;
		case "updateuseroperation":
			Users user = new Users(Integer.parseInt(req.getParameter("userId")), req.getParameter("userName"),
					req.getParameter("email"));
			System.out.println("username = " + req.getParameter("userName"));
			System.out.println("USERID = " + req.getParameter("userId"));
			System.out.println("email = " + req.getParameter("email"));
			updateUserOperation(dataSource, user);
			listUsers(req, resp);
			break;
		default:
			errorPage(req, resp);
			break;
		}
	}

	private void updateUserOperation(DataSource dataSource2, Users newUser) {
		Context initCtx = null;
		Context envCtx = null;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dataSource2 = (DataSource) envCtx.lookup("jdbc/project");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		new UsersModel().updateUser(dataSource2, newUser);
		return;
	}

	private void addUserOperation(DataSource dataSource2, Users newUser) {
		System.out.println("This is addUserOperation");
		Context initCtx = null;
		Context envCtx = null;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dataSource2 = (DataSource) envCtx.lookup("jdbc/project");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("This is addUserOperation---");
		new UsersModel().addUser(dataSource2, newUser);
		return;
	}

	protected void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}

	protected void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Users> listUsers = new ArrayList<Users>();
		Context initCtx = null;
		Context envCtx = null;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dataSource = (DataSource) envCtx.lookup("jdbc/project");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listUsers = new UsersModel().listUsers(dataSource);
		request.setAttribute("title", "List Users");
		request.setAttribute("listUsers", listUsers);
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
	}

	protected void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "UpdateUsers");
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
	}

	private void deleteUser(int userId) {
		new UsersModel().deleteUser(dataSource, userId);
		return;
	}

	protected void addUserFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "AddUsers");
		request.getRequestDispatcher("addUsers.jsp").forward(request, response);
	}

}
