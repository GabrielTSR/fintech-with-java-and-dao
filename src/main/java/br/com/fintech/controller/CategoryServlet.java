package br.com.fintech.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.category.CategoryDAO;
import br.com.fintech.factory.DAOFactory;


@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryDAO categoryDAO;

    public CategoryServlet() {
        categoryDAO = DAOFactory.getCategoryDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
