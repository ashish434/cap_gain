import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*; 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SignInServlet extends GenericServlet
{
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{

String fname=req.getParameter("fname");
String mname=req.getParameter("mname");
String lname=req.getParameter("lname");
String email=req.getParameter("email");
String crd=req.getParameter("crd");
String street=req.getParameter("street");
String city=req.getParameter("city");
String state=req.getParameter("state");
String zip=req.getParameter("zip");
String phone=req.getParameter("phone");
String weburl=req.getParameter("weburl");


Connection con=null;
try{
  Class c=Class.forName("oracle.jdbc.driver.OracleDriver");
  Driver d=(Driver)c.newInstance();
  String jdbcURL="jdbc:oracle:thin:@localhost:1521:XE";
  Properties p=new Properties();
  p.put("user","scott");
  p.put("password","tiger");
  con=d.connect(jdbcURL,p);
  PreparedStatement ps=con.prepareStatement("insert into advisor_details(fname,mname,lname,email,crd,street,city,state,zip,phone,weburl) values(?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,fname);
ps.setString(2,mname);
ps.setString(3,lname);
ps.setString(4,email);
ps.setString(5,crd);
ps.setString(6,street);
ps.setString(7,city);
ps.setString(8,state);
ps.setString(9,zip);
ps.setString(10,phone);
ps.setString(11,weburl);
ps.executeUpdate();
System.out.println("Here");

  }

catch(Exception se)
{se.printStackTrace();}

finally{
try{con.close();
System.out.println("connection closed");}
catch(SQLException se){se.printStackTrace();}}

System.out.println("New Advisor datails saved");

try{

final String username = "admin@capitaladvisorsearch.com";
final String password = "admin123";
 
Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "mail.capitaladvisorsearch.com");
	props.put("mail.smtp.port", "26");
 
Session session = Session.getInstance(props,new javax.mail.Authenticator() {protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username, password);}});
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("admin@capitaladvisorsearch.com"));
message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(req.getParameter("email")));
message.setSubject("Testing Subject");
message.setText("This mail is sent in request to register at capital gain search.\n\n\n Your details will be verified and we will send you a confirmation email with a valid username and password");
Transport.send(message);

res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<h1><b><font color=\"black\">Your details will be verified and we will send you a confirmation email with a valid username and password</font></b></h1> <a href=\"advisor.html\">Go back to Login Page</a></body>");
     }
catch (MessagingException e){throw new RuntimeException(e);}


}}
