package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.moldels.ctdonthuoc;
import com.moldels.ctdonthuocDB;
import com.moldels.thuoc;
import com.moldels.thuocDB;

/**
 * Servlet implementation class updatectThuoc
 */
public class updatectThuoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatectThuoc() {
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
		
		String idthuoc = request.getParameter("idthuoc");
		String iddt = request.getParameter("iddt");
		String idbs = request.getParameter("idbs");
		String idbn = request.getParameter("idbn");
		int iddti = Integer.parseInt(iddt);
		
		String ten = request.getParameter("tenthuoc");
		String idm = thuocDB.getIDBYName(ten);
		int lieuluong = Integer.parseInt(request.getParameter("lieuluong"));
		int ts = Integer.parseInt(request.getParameter("ts"));
		int sl = Integer.parseInt(request.getParameter("sl"));
		String dang = request.getParameter("dang");
		
		ctdonthuoc ctdt = new ctdonthuoc(iddti, idm, lieuluong, ts, sl, dang);
		ctdonthuocDB. updateCTById(iddti, idthuoc, ctdt);
		HttpSession session = request.getSession();
		session.setAttribute("iddt", iddti);
        session.setAttribute("idbn", idbn);
        session.setAttribute("idbs", idbs);
		request.getRequestDispatcher("prescription.jsp").forward(request, response);
	}

}
