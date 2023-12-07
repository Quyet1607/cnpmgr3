package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.moldels.thuocDB;
import com.moldels.ctdonthuoc;
import com.moldels.ctdonthuocDB;
import com.moldels.donthuocDB;

/**
 * Servlet implementation class add
 */
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		String id = request.getParameter("iddt");
		int iddt= Integer.parseInt(id);
		String tenthuoc = request.getParameter("tenthuoc");
		int lieuluong = Integer.parseInt(request.getParameter("lieuluong"));
		int ts = Integer.parseInt(request.getParameter("ts"));
		int sl = Integer.parseInt(request.getParameter("sl"));
		String dang = request.getParameter("dang");
		String idbn = request.getParameter("idbn");
		String idthuoc = thuocDB.getIDBYName(tenthuoc);
		ctdonthuoc ct = new ctdonthuoc(iddt, idthuoc, lieuluong, ts, sl, dang);
		ctdonthuocDB.insertctdonthuoc(ct);
        request.setAttribute("idbn", idbn);
        request.getRequestDispatcher("addmedicine1.jsp").forward(request, response);
	}

}
