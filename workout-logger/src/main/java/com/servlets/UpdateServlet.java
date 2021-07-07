package com.servlets;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Workouts;
import com.helper.FactoryProvider;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String workoutName = request.getParameter("workoutName");
			String workoutType = request.getParameter("workoutType");
			String workoutDate = request.getParameter("workoutDate");
			String workoutDuration = request.getParameter("workoutDuration");
			String workoutDetails = request.getParameter("workoutDetails");
			String activityLink = request.getParameter("workoutLink");
			int workoutID = Integer.parseInt(request.getParameter("workoutId").trim());
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Workouts workout = s.get(Workouts.class, workoutID);
			workout.setWorkoutName(workoutName);
			workout.setWorkoutType(workoutType);
			workout.setWorkoutDate(workoutDate);
			workout.setWorkoutDuration(workoutDuration);
			workout.setWorkoutDetails(workoutDetails);
			workout.setWorkoutLink(activityLink);
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			workout.setAddedDate(formatter.format(new Date()));
			tx.commit();
			s.close();
			
			response.sendRedirect("all_workouts.jsp");
						
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
	}

}
