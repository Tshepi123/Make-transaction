<%@page import="com.connection.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <div class="container-fluid p-0">
            <%@include file="includes/navbar.jsp" %>
        
            <%            
               Connection conn=DBConnect.getConn();
               System.out.print(conn);
            %>
        
            <div class="card py-5">
                <div class="card-body text-center">
                    <img alt="" src="images/img1.jpg" class="img-fluid mx-auto" style="max-width: 300px;">
                    <h1>MAKE TRANSACTION</h1>
                    <a href="payment_form.jsp" class="btn btn-outline-primary">Click Here</a>
                </div>
            </div>
        </div>
        <div>
             <%@include file="includes/footer.jsp" %>
        </div>     
    </body>
</html>
