<%@page import="com.bean.userBean"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light" > 
    <a class="navbar-brand" href="#">Rivonia Internet Banking</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
            
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a></li> 
                <li class =" nav-item"><a class="nav-link" href="registration_list.jsp">Personal Details</a></li>
                <li class =" nav-item"><a class="nav-link" href="payment_form.jsp">Make Payment</a></li>
                <li class =" nav-item"><a class="nav-link" href="payment_list.jsp">Payment Details</a></li>  
            </ul>
           
             <!-- 
                Explanation for code below (if user != null): 
                #If the user has successfully logged in, navbar will show the Users Name from database and Logout.  (At the top right)
                #If user has not logged in, navbar will show Login and Register (At the top right)
                #userB is from loginServlet  (Look below) [session.getAttribute("userB")]         
            -->
            <%
                userBean user = (userBean) session.getAttribute("userB"); 

                if(user != null)
                {%>
                    <a class="btn btn-light my-2 my-sm-0 mr-2" data-toggle="modal" data-target="#exampleModal"> Hello <%=user.getName() %></a>                       
                    <a href="logoutServlet" class="btn btn-light my-2 my-sm-0">Logout</a> <!-- References the logout servlet -->
                <%}
                else
                {%>                                    
                    <a href="login.jsp" class="btn btn-light my-2 my-sm-0 mr-2">Login</a>                    
                    <a href="registration_form.jsp" class="btn btn-light my-2 my-sm-0">Register</a>                   
                <%}
            %>    
         
        </div>           
</nav>
                
                
            
        
    
