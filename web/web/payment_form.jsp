<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- If you try to access payment_form page without logging in, then will be returned to the Login page and message "Please Login..." will be shown-->
<%
    userBean user1 =(userBean)session.getAttribute("userB");
    
    if(user1 == null)
    {
        response.sendRedirect("login.jsp");
        session.setAttribute("Login-error", "Please Login...");
    }
%>    
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Payment Page</title>
        <%@include file="includes/head.jsp" %> 
    </head>
    <body>  
        <div class="container-fluid">
            <%@include file="includes/navbar.jsp" %>
            
            <h1 class="text-center">Make Transaction</h1> 

            <div class="container">
                <div class="row">
                    <div class="col-md-12">                        
                        <!-- userB (from LoginServlet) -->
                        <%
                            userBean UB = (userBean)session.getAttribute("userB");
                            if(UB != null) 
                            {%>                                                                
                                <div class="form-group text-center">
                                    <label>Your User ID is : <%=UB.getId()%> </label> <!-- This userID is from the database table(users), need it to insert foreign key value into payment table -->
                                </div> 
                            <%}
                        %>    
                        
                        <form action="addPaymentServlet" method="post"> <!-- Will make use of addPaymentServlet-->
                            <div class="form-group text-center">
                                <label>Enter Your User ID To Make A Payment</label> <br>
                                <input style="width: 300px; text-align: center" type="text" name="userID" required="required"> <!-- Must enter this number displayed from above to avoid NullPointerException and is also used for foreign key in database table (payment) -->
                            </div>    
                            <div class="form-group text-center">
                                <label>Enter Your Account Number</label> <br>
                                <input style="width: 300px; text-align: center" type="password"  name="accNo" placeholder="**********" required="required">
                            </div>
                            <div class="form-group text-center">
                                <label>Enter Recipients Account Number</label> <br>
                                <input style="width: 300px; text-align: center" type="password" name="receiverAccNo" placeholder="**********" required="required">
                            </div> 
                            <div class="form-group text-center">
                                <label>Enter Amount</label> <br>
                                <input style="width: 300px; text-align: center" type="number" name="amount" placeholder="*****" required="required">
                            </div> 
                            
                            <div class=" container text-center">
                                <button type="submit" class="btn btn-primary">Send</button>
                            </div>
                        </form>
                        
                        <br> <!-- <br> is used to create a new line --> 
                        
                        <!-- Just below the form, if you have successfully added the notes, then AddPaymentSuccess message will show -->
                        <%
                            String AddPaymentSuccessMsg = (String)session.getAttribute("addPayment-successMsg");
                            
                            if(AddPaymentSuccessMsg != null) 
                            {%>    
                                <div class="alert alert-success" role="alert"><%= AddPaymentSuccessMsg %></div> To View Your Payment Details <a href="payment_list.jsp">Click Here</a></div>
                            <%     
                                session.removeAttribute("addPayment-successMsg");
                            }
                        %>                          
                        
                            <!-- If have not added/ made the payment successfully, like maybe entered the wrong id number(userID), then AddPaymentErrorMsg will show -->
                        <%
                            String AddPaymentErrorMsg = (String)session.getAttribute("addPayment-errorMsg");
                            if(AddPaymentErrorMsg != null)
                            {%>
                                <div class="alert alert-danger" role="alert"><%= AddPaymentErrorMsg %></div>
                            <%
                                session.removeAttribute("addPayment-errorMsg");
                            }
                        %>                          
                        
                    </div>
                </div>
            </div>
        <div>
             <%@include file="includes/footer.jsp" %>
        </div>  
    </body>
</html>
