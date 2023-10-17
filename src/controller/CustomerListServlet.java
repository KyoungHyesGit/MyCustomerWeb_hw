package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import vo.CustomerVo;

/**
 * Servlet implementation class CustomerListServlet
 */
// @WebServlet("/customerList")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerDAO customerDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
        String driverClass = config.getInitParameter("driverClass");
		String url = config.getInitParameter("dbUrl");
		String username = config.getInitParameter("dbUserName");
		String userpw = config.getInitParameter("dbUserPw");
		
		customerDAO = new CustomerDAO(driverClass, url, username, userpw);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		customerDAO.connectionClosed();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		List<CustomerVo> customerAllList = customerDAO.getAllCustomerList();
		
		request.setAttribute("customerList", customerAllList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerList.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
