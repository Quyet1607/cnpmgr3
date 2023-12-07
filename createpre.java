package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.moldels.donthuoc;
import com.moldels.donthuocDB;

/**
 * Servlet implementation class createpre
 */
public class createpre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createpre() {
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
		int id = 0;
		String idbs = request.getParameter("idbs");
		String idbn = request.getParameter("idbn");
		
		System.out.println(idbs);
		System.out.println(idbn);
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngay = currentDate.format(dateFormat);

        String trangthai = "Chưa hoàn thành";
        
        donthuoc dt =  new donthuoc(id, idbn, idbs, ngay, trangthai);
         id = donthuocDB.insertDonThuoc(dt);
         HttpSession session = request.getSession();
         session.setAttribute("dt", dt);
         session.setAttribute("idbn", idbn);
         session.setAttribute("idbs", idbs);
         request.getRequestDispatcher("addmedicine1.jsp").forward(request, response);
	}

}
