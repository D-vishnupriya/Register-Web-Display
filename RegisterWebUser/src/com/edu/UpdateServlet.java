package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sn=request.getParameter("sname");
		int id=Integer.parseInt(request.getParameter("sid"));
		
		
		try {
		Connection conn=DbConnect.getConnection();
			Statement st=conn.createStatement();
			st=conn.createStatement();
		//String  ins="update into register values("+id+",'"+sn+"')";
			
		  String sql="select * from register  where sid="+id; 
		 ResultSet rs=st.executeQuery(sql);
		  if(rs.next()) { //if true record exists
			  //Update operation when record exists
			  
			String Update="update register set sname='"+sn+"' where sid="+id;
			  //String upd="update register set sname='"+sn+"' where sid="+id;

			int i=st.executeUpdate(Update);
			
			if(i>0) {
				out.println("Record is Updated");
			}
			}//if
		  else {
			  out.println("Record not exists");
		  }
		  
	}catch(Exception e) {
		e.printStackTrace();
	}
}



	}


