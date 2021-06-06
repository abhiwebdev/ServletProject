<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="all_js_css.jsp"%>
<%@ page language="java" import="com.captchaprovider.CaptchasDotNet"%>


<meta charset="ISO-8859-1">
<title>Add Workout</title>
</head>
<body>
	<div class="container-fluid p-0 m-0">

		<%@include file="NavBar.jsp"%>
	</div>

	<h1 align="center">LET'S FILL IT UP!</h1>

	<!--This is Add workout Form  -->
	<div class="container p-10	m-100">
		<form action="SaveWorkoutServlet" method="post">
			<div class="mb-3">
				<label for="nameWorkout" class="form-label">Workout Name </label> <input name="workoutName"
					type="Text" class="form-control" id="nameWorkout"
					aria-describedby="emailHelp">
				<div id="workoutName" class="form-text"></div>
			</div>
			<!-- <div class="container p-10 m-100"> -->
			<div class="row">
				<div class="col">
					<label for="listWorkout" class="form-label">Workout Type</label> <input name="workoutType"
						list="listWorkout" class="form-control" placeholder="Select">
					<datalist id="listWorkout">
						<option value="Run" />
						<option value="Ride" />
						<option value="Weightlifting" />
						<option value="HIIT Cardio" />
						<option value="Swimming" />
					</datalist>

				</div>
				<div class="col">
					<label for="date" class="form-label">Workout Date</label> <input name="workoutDate"
						type="date" class="form-control" id="date">
				</div>
				<div class="col">
					<label for="workoutDuration" class="form-label">Workout
						Duration</label> <input name="workoutDuration" type="time" class="form-control" id="duration"
						step="2" value="00:00:00">
				</div>

			</div>
			<!-- </div> -->
			<div class="mb-3">
				<!-- <label for="exampleInputPassword1" class="form-label"></label> -->
				<label class="form-label" for="textAreaExample">Workout
					Details</label>
				<textarea name="workoutDetails" required class="form-control" id="textAreaExample1" rows="4"></textarea>


			</div>

			<div class="mb-3">
				<label for="activityLink" class="form-label">Workout
					Link</label> <input name="workoutLink" required type="url" pattern="^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$" 
					 class="form-control"
					id="exampleInputPassword1" placeholder="Please enter URL by appending https:// at start..">
			</div>

			<!-- <div class="mb-3 form-check"> -->
				<!-- <input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label> -->

				<%@ page language="java" import="com.captchaprovider.CaptchasDotNet"%>

				<html>
<h1>Captcha Verification</h1>
<%
// Construct the captchas object (Default Values)
CaptchasDotNet captchas = new com.captchaprovider.CaptchasDotNet(request.getSession(true), // Ensure session
		"jarmous", // client
		"KQ8ezrsYzDvduRTDEg2XF4jIqzvCA90pGcRQG3ZR" // secret
);
// Construct the captchas object (Extended example)
// CaptchasDotNet captchas = new captchas.CaptchasDotNet(
//  request.getSession(true),     // Ensure session
//  "demo",                       // client
//  "secret",                     // secret
//  "01",                         // alphabet
//  16,                           // letters
//  500,                          // width
//  80                            // height
//  );
%>
<%-- 
   % encodeUrl produces jsessionid=xyz in case of disabled cookies
   % Please test your implementation also with disabled cookies
   --%>
<%-- <form method="get" action="<%=response.encodeUrl("check.jsp")%>"> --%>
	<table>
		<tr>
			<td>Your message:</td>
			<td><input name="message"
				value="Please Complete Captcha Verification" size="60" /></td>
		</tr>
		<tr>
			<td>The CAPTCHA password:</td>
			<td><input name="password" size="16" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<%-- 
           % it's possible to set a random in captchas.image("xyz"),
           % captchas.imageUrl("xyz") and captchas.audioUrl("xyz").
           % This is only needed at the first request
           --%> <%=captchas.image()%><br> <a
				href="<%=captchas.audioUrl()%>">Phonetic spelling (mp3)</a>
			</td>
		</tr>
		<tr>
			<td></td>
			<%-- <td><input type="submit" value="Verify Captcha!" formaction=<%@response.encodeUrl("check.jsp")%></td> --%>
		</tr>
	</table>
<!-- 	</form>  -->
<!-- </form> -->

<input type="submit" class="btn btn-primary"></button>

</form>
</body>
</html>