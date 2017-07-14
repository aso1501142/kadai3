package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudentDAO;
import model.Student;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String path = "";

		try {
			HttpSession session = request.getSession();

			int stu_id = Integer.parseInt(request.getParameter("stu_id"));
			String stu_password = request.getParameter("stu_password");

			//System.out.println(stu_id);
			//System.out.println(stu_password);

			StudentDAO studentDAO = new StudentDAO();
			Student student = new Student();

			student = studentDAO.getStudent(stu_id, stu_password);

			if (student != null) {
				System.out.println("ログイン成功");

				session.setAttribute("stu_id", student);
				path = ("WEB-INF/jsp/top.jsp");

			} else {
				System.out.println("ログイン失敗");
				request.setAttribute("errorMessage", "IDまたはパスワードが違います。");

				path = ("WEB-INF/jsp/login.jsp");
			}

		} catch (Exception e) {
			System.out.println("ログイン失敗");
			request.setAttribute("errorMessage", "IDまたはパスワードが違います。");

			path = ("WEB-INF/jsp/login.jsp");
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
