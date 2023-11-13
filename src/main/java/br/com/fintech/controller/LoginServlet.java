package br.com.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.category.CategoryDAO;
import br.com.fintech.dao.user.UserDAO;
import br.com.fintech.factory.DAOFactory;
import br.com.fintech.model.Category;
import br.com.fintech.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO dao;
    private CategoryDAO categoryDAO;

    public LoginServlet() {
    	super();
        dao = DAOFactory.getUserDAO();
        categoryDAO = DAOFactory.getCategoryDAO();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(email, password);

        if (dao.validate(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("id", user.getId());
            
    		List<Category> lista = categoryDAO.listar();
            request.setAttribute("categories", lista);
            
            request.getRequestDispatcher("transaction-register.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Campos inseridos incorretos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}
}
