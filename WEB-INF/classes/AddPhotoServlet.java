import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AddPhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        try {
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);

            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }

            // parse request
            List items = sfu.parseRequest(request);


            // get uploaded file
            FileItem file = (FileItem) items.get(0);
                        
            // Connect to Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            con.setAutoCommit(false);
Statement stmt=con.createStatement();
stmt.executeUpdate("delete from photos");

            PreparedStatement ps = con.prepareStatement("insert into photos values(?,?,?)");

HttpSession hs=request.getSession(false);
            ps.setString(1, (String)hs.getAttribute("crdnumber"));
            ps.setString(2, (String)hs.getAttribute("firstname"));
            // size must be converted to int otherwise it results in error
            ps.setBinaryStream(3, file.getInputStream(), (int) file.getSize());
            ps.executeUpdate();
            con.commit();
            con.close();
RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
rd.include(request,response);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    } 
}