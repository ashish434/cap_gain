import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomeServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{

String uname=req.getParameter("uname");
String pass=req.getParameter("pass");


String sql="select * from advisor_details where password='"+pass+"' and fname='"+uname+"'";
System.out.println(sql);
Connection con=null;
try{
  Class c=Class.forName("oracle.jdbc.driver.OracleDriver");
  Driver d=(Driver)c.newInstance();
  String jdbcURL="jdbc:oracle:thin:@localhost:1521:XE";
  Properties p=new Properties();
  p.put("user","scott");
  p.put("password","tiger");
  con=d.connect(jdbcURL,p);
  Statement st=con.createStatement();
  ResultSet rs=st.executeQuery(sql);
  if(rs.next())
  {

String fname=rs.getString(1);
String mname=rs.getString(2);
String lname=rs.getString(3);
String email=rs.getString(4);
String crd=rs.getString(5);
String street=rs.getString(6);
String city=rs.getString(7);
String state=rs.getString(8);
String zip=rs.getString(9);
String phone=rs.getString(10);
String weburl=rs.getString(11);
HttpSession hs = req.getSession();
hs.setAttribute("firstname",fname);
hs.setAttribute("middlename",mname);
hs.setAttribute("lastname",lname);
hs.setAttribute("emailid",email);
hs.setAttribute("crdnumber",crd);
hs.setAttribute("street",street);
hs.setAttribute("city",city);
hs.setAttribute("state",state);
hs.setAttribute("zip",zip);
hs.setAttribute("phone",phone);
hs.setAttribute("weburl",weburl);
hs.setAttribute("imgurl","displayphoto?id="+crd);

RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
rd.include(req,res);
}
else
System.out.println("nothing returned");
    }

catch(Exception se)
{se.printStackTrace();}

finally{
try{con.close();
System.out.println("connection closed");}
catch(SQLException se){se.printStackTrace();}}

  


}}
