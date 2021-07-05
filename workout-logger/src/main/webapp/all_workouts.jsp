<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="all_js_css.jsp"%>

<meta charset="ISO-8859-1">
<title>Workouts' List - Workout Logger</title>
</head>
<body>
	<div class="container-fluid p-0 m-0">
		<%@include file="NavBar.jsp"%>
		<br>
		<h1 class="text-uppercase">Workouts' List -</h1>
		<div class="row">

			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				@SuppressWarnings("unchecked")
				/* 		Query q = s.createQuery("from Workouts");*/
				List<Workouts> list = s.createQuery("from Workouts").getResultList();
				for (Workouts workout : list) {
				%>
				<div class="card mt-3">
					<div class="container text-center">
						<img class="card-img-top m-4" style="max-width: 100px;"
							src="img/trainer.png" alt="Card image cap">
					</div>
					<div class="card-body px-5">
						<h5 class="card-title"><%=workout.getWorkoutName()%></h5>
						<p class="card-text"><%=workout.getWorkoutDetails()%></p>
						<div class="container text-center mt-2">
							<a href="DeleteServlet?workout_id= <%=workout.getWorkoutId()%>" class="btn btn-danger">Delete</a> 
							<a href="UpdateServlet" class="btn btn-outline-primary">Update</a>
						</div>
					</div>
				</div>
				<!-- 				out.println(workout.getWorkoutId() + " : " +
				workout.getWorkoutName() + "<br>"); -->

				<%
				}
				s.close();
				%>
			</div>

		</div>


	</div>
</body>
</html>