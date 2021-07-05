package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Workouts;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int workoutId = Integer.parseInt(request.getParameter("workout_id").trim());
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Workouts workout = (Workouts)s.get(Workouts.class, workoutId);
			s.delete(workout);
			tx.commit();
			s.close();
			response.sendRedirect("all_workouts.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
