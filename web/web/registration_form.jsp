<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card mt-4">
                        <div class="card-header text-center">
                            <i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
                            <h4>Registration</h4>
                        </div>
                        
                        <!-- Code below will show message when user has successfully registered-->
                        <%
                            String regMsg = (String)session.getAttribute("reg-success");
                            
                            if(regMsg != null) 
                            {%>    
                                <div class="alert alert-success" role="alert"><%=regMsg%> Login <a href="login.jsp">Click Here</a></div>
                            <%   
                                session.removeAttribute("reg-success");
                            }
                        %>    
   
                        <!-- Code below will show message when user has not registered successfully-->
                        <%
                            String FailedMsg = (String)session.getAttribute("failed-msg");
                            
                            if(FailedMsg != null) 
                            {%>    
                                <div class="alert alert-danger" role="alert"><%= FailedMsg %></div>
                            <%     
                                session.removeAttribute("failed-msg");
                            }
                        %>                          
                        
                        <div class="card-body">
                            <form action="registrationServlet" method="post"> <!--action = (Url Pattern of registrationServlet)-->
                           
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" name="name" placeholder="Enter Your First Name" required>                                   
                                </div>

                                <div class="form-group">
                                    <label>Surname</label>
                                    <input type="text" class="form-control" name="surname" placeholder="Enter Your Last Name" required>                                    
                                </div>

                                <div class="form-group">
                                    <label>Email Address</label>
                                    <input type="email" class="form-control" name="email"  placeholder="Enter Your Email Address" required>                                  
                                </div>

                                <div class="form-group">
                                    <label>ID Number</label>
                                    <input type="number" class="form-control" name="idNum" placeholder="Enter Your ID Number" required>                                                                       
                                </div>   

                                <div class="form-group">
                                    <label>Phone Number</label>
                                    <input type="number" class="form-control" name="phoneNo" placeholder="Enter Your Phone Number" required>                                   
                                </div>

                                <div class="form-group">
                                    <label>Login Username</label>
                                    <input type="text" class="form-control" name="loginUsername" placeholder="Enter Your Login Username" required>                                    
                                </div>

                                <div class="form-group">
                                    <label>Login Password</label> 
                                    <input type="password" class="form-control" name="loginPassword" placeholder="*******" required>
                                </div>    

                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Register</button> <button type="reset" class="btn btn-dark">Reset</button>
                                </div>
                                <br>
                                <div>
                                    <a class="form text-center" href="login.jsp">Already have an account? Login here</a>
                                </div>    
                            </form>
                        </div>        
                    </div>
                </div>
            </div>
        </div>
        <div class='col-md-4 offset-md-4'>
             <%@include file="includes/footer.jsp" %>
        </div>                       
    </body>
</html>
