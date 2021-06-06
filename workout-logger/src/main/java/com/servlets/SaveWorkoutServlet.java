package com.servlets;

import com.entities.*;
import com.helper.FactoryProvider;
import com.captchaprovider.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Servlet implementation class SaveWorkoutServlet
 */
public class SaveWorkoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveWorkoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Check captcha password first then proceed to next step
		CaptchasDotNet captchas = new com.captchaprovider.CaptchasDotNet(
				request.getSession(true),     // Ensure session
				"jarmous",                       // client
				"KQ8ezrsYzDvduRTDEg2XF4jIqzvCA90pGcRQG3ZR"                      // secret
				);
		String message  = request.getParameter("message");
		String password = request.getParameter("password");
		String body;
		int code;
		switch (captchas.check(password)) {
		case 's':
			code = 1;
			body = "Session seems to be timed out or broken. ";
			body += "Please try again or report error to administrator.";
			break;
		case 'm':
			code = 3;
			body = "Every CAPTCHA can only be used once. ";
			body += "The current CAPTCHA has already been used. ";
			body += "Please use back button and reload";
			break;
		case 'w':
			code = 4;
			body = "You entered the wrong password. ";
			body += "Please use back button and try again. ";
			break;
		default:
			code = 2;
			body = "Your message was verified to be entered by a human and is \"" + message + "\"";
			break;
		}
		if(code==2) {
			try {

				String workoutname = request.getParameter("workoutName");
				String workoutType = request.getParameter("workoutType");
				String workoutDate = request.getParameter("workoutDate");
				String workoutDuration = request.getParameter("workoutDuration");
				String workoutDetails = request.getParameter("workoutDetails");
				String workoutLink = request.getParameter("workoutLink");

				Workouts workout = new Workouts(workoutname, workoutType, workoutDetails, workoutDuration, workoutLink, workoutDate);
				System.out.println("\nFollowing are workout details received from user - "+

					"\nWorkout ID: "+workout.getWorkoutId()+
					"\nWorkout Name: "+workout.getWorkoutName()+
					"\nWorkout Date: "+workout.getWorkoutDate()+
					"\nWorkout Type: "+workout.getWorkoutType()+
					"\nWorkout Details: "+workout.getWorkoutDetails()+
					"\nWorkout Duration: "+workout.getWorkoutDuration()+
					"\nWorkout Link: "+workout.getWorkoutLink()+"\n"
						);
				//hibernate:save();
				Session s = FactoryProvider.getFactory().openSession();
				Transaction tx = s.beginTransaction();
				s.save(workout);
				tx.commit();
				s.close();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1> Workout has been added successfully!</h1>");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>"+body+"</h1>");
		}
	}

}
