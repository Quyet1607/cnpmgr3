package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.moldels.donthuocDB;

/**
 * Servlet implementation class hoanthanh
 */
public class hoanthanh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoanthanh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idbs = request.getParameter("idbs");
		String idbn = request.getParameter("idbn");
		String iddt = request.getParameter("iddt");
		int iddti = Integer.parseInt(iddt);
		donthuocDB.updateTrangThai(iddti);
		HttpSession session = request.getSession();
		session.setAttribute("iddt", iddti);
        session.setAttribute("idbn", idbn);
        session.setAttribute("idbs", idbs);
		request.getRequestDispatcher("done.jsp").forward(request, response);
	}

}
