

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="home.css" />
<title>Welcome Home</title>
</head>

<body>

<div id="container">
<img src="<%= session.getAttribute("imgurl") %>" height="130" width="130">

		<div id="header">
        	<h1>Welcome &nbsp;<span class="off"> <%= session.getAttribute( "firstname" ) %></span></h1>
            <h2>LogOut</h2>
        </div>   
        
        <div id="menu">
        	<ul>
            	<li class="menuitem"><a href="#">Home</a></li>
                <li class="menuitem"><a href="#">About</a></li>
                <li class="menuitem"><a href="#">Products</a></li>
                <li class="menuitem"><a href="#">Services</a></li>
                <li class="menuitem"><a href="#">Design</a></li>
              <li class="menuitem"><a href="#">Contact</a></li>
            </ul>
        </div>
        
        <div id="leftmenu">

        <div id="leftmenu_top"></div>

				<div id="leftmenu_main">    
                
                        
                <ul>
                    <li><a href="home.jsp">view Profile</a></li>
                    <ti><a href="#">update Profile</a></ti>
                    <li><a href="home_photo.jsp">Photo</a></li>
                    <li><a href="home_video.jsp">Video</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Design</a></li>
                    <li><a href="#">Submit articles</a></li>
                    <li><a href="#">Deactivate Account</a></li>
                </ul>
</div>
                
                
              <div id="leftmenu_bottom"></div>
        </div>
        
        
        
        
		<div id="content">
        
        
        <div id="content_top"></div>
        <div id="content_main">
        	

<form action="Edit">
   
Telephone:&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="text" name="phone" /><br>
<p>&nbsp;</p>
Web URL: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="weburl" /><br>
<p>&nbsp;</p>
Facebook URL:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      <input type="text" name="fb" /><br>
<p>&nbsp;</p>
Linked In URL:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="text" name="ln" /><br>
<p>&nbsp;</p>
Years of Experience: <input type="text" name="exp" /><br>
<p>&nbsp;</p>
<<input type="submit" value="submit"/>>


</form>

       
         <p>&nbsp;</p>

        </div>
        <div id="content_bottom"></div>
            
            <div id="footer"><h3><a href="http://www.capitalgainadvisor.com/">Capital Gain Advisor</a></h3></div>
      </div>
   </div>
</body>
</html>
