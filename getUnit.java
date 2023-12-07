package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.moldels.thuoc;
import com.moldels.thuocDB;

/**
 * Servlet implementation class getUnit
 */
public class getUnit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUnit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String medicineName = request.getParameter("medicineName");
		String dos = request.getParameter("medicineLL");
		String fre = request.getParameter("medicinefre");
		int doss = Integer.parseInt(dos);
				
		String idt = thuocDB.getIDBYName(medicineName);
		thuoc thuoc = thuocDB.getThuocById(idt);
		
		int dose = thuoc.getUnit()*doss;
		String result = "";
	    int fre_max = thuoc.getTsmax();
	    int dose_max = thuoc.getLieumax();
	    int dose_min = thuoc.getLieumin();
	    int dose_max_pday = dose_max * Integer.parseInt(fre);
	    int dose_min_pday = dose_min * Integer.parseInt(fre);
	    System.out.println(idt);	    
	    System.out.println(thuoc.getLieumax());
	    if (dose > dose_max || dose < dose_min) {
	        result = "Error, the single dose is too high or too low";
	    } else if (Integer.parseInt(fre) > fre_max) {
	        result = "Error, the single dose is correct but the frequency is too high";
	    } else if (dose * Integer.parseInt(fre) >= dose_min_pday && dose * Integer.parseInt(fre) <= dose_max_pday) {
	        result = "OK, the single dose * frequency is in the permitted range";
	    } else {
	        result = "Error, the single dose * frequency is too high or too low";
	    }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
