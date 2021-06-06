<%@ page language="java" import="com.captchaprovider.CaptchasDotNet"%>

<html>
<head>
<title>Successful!</title>
</head>
<h1>Captcha Verification</h1>
<%
// Construct the captchas object
// Use same settings as in query.jsp
CaptchasDotNet captchas = new com.captchaprovider.CaptchasDotNet(
  request.getSession(true),     // Ensure session
  "jarmous",                       // client
  "KQ8ezrsYzDvduRTDEg2XF4jIqzvCA90pGcRQG3ZR"                      // secret
  );
// Read the form values
String message  = request.getParameter("message");
String password = request.getParameter("password");
// Check captcha
String body;
String code;
switch (captchas.check(password)) {
  case 's':
	code = "1";
	body = "Session seems to be timed out or broken. ";
    body += "Please try again or report error to administrator.";
    break;
  case 'm':
	code = "3";
    body = "Every CAPTCHA can only be used once. ";
    body += "The current CAPTCHA has already been used. ";
    body += "Please use back button and reload";
    break;
  case 'w':
	code = "4";
    body = "You entered the wrong password. ";
    body += "Please use back button and try again. ";
    break;
  default:
	code = "2";
    body = "Your message was verified to be entered by a human and is \"" + message + "\"";
    break;
}
%>
<%=body%>
</html>