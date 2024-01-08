<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- If you try to access registration_list page without logging in, then will be returned to the Login page and message "Please Login..." will be shown-->
<%
    userBean user2 =(userBean)session.getAttribute("userB");
    
    if(user2 == null)
    {
        response.sendRedirect("login.jsp");
        session.setAttribute("Login-error", "Please Login...");
    }
%>   

<!DOCTYPE html>
<html>
    <head>
        <title>User Details Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        
        <%
            userBean UB = (userBean)session.getAttribute("userB");
            if(UB != null) 
            {%>  
                <div class="modal-body">
                    <div class="container text-center">
                        <div class="container table-dark"> <br>
                            <i class="fa fa-user fa-3x"></i>                     
                            <h5>Personal Details</h5> 
                        </div>
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <th>Name: </th>
                                    <td ><%=user.getName() %></td>
                                </tr>

                                <tr>
                                    <th>Surname: </th>
                                    <td><%=user.getSurname() %></td>
                                </tr>

                                <tr>
                                    <th>Email Address:</th>
                                    <td><%=user.getEmail() %></td>
                                </tr> 

                                <tr>
                                    <th>ID Number:</th>
                                    <td><%=user.getIdNum() %></td>
                                </tr> 

                                <tr>
                                    <th>Phone Number:</th>
                                    <td><%=user.getPhoneNo() %></td>
                                </tr> 
        <!--
                                <tr>
                                    <th>Account Number</th>
                                    <td><!%=user.getAccNo() %></td>
                                </tr> 
        -->
                                <tr>
                                    <th>Login Username:</th>
                                    <td><%=user.getLoginUsername() %></td>
                                </tr> 

                                <tr>
                                    <th>Login Password:</th>
                                    <td>**********</td>
                                </tr> 

                            </tbody>
                        </table>
                    </div>
                </div> 
            <%}
        %>                                   
        <div>
            <%@include file="includes/footer.jsp" %> 
        </div>                                                   
    </body>
</html>