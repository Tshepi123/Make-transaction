<%@page import="com.dao.paymentDao"%>
<%@page import="com.bean.paymentBean"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- If you try to access payment_list page without logging in, then will be returned to the Login page and message "Please Login..." will be shown-->
<%
    userBean user3 =(userBean)session.getAttribute("userB");
    
    if(user3 == null)
    {
        response.sendRedirect("login.jsp");
        session.setAttribute("Login-error", "Please Login...");
    }
%>    
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Details Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>       
        
        <div class="container">
            <h2 class="text-center">All Payment Details: </h2>
           
            <br>
                        
            <div class="row">
                <div class="col-md-12">
                <!-- po is the list from paymentDao (getData method) -->    
                <%
                    if(user3 != null)
                    {
                        paymentDao AD = new paymentDao(DBConnect.getConn());
                        List<paymentBean> po = AD.getData(user3.getId());

                        for(paymentBean PB : po)
                        {%>
                            <div class="container">
                                <div class="card-header my-3">Payment Details</div>
                                <table class="table table-light table-bordered">
                                    <thead>
                                        <tr> 
                                            <th scope="col">Sender's Account Number</th>
                                            <th scope="col">Recipient Account Number</th>
                                            <th scope="col">Payment Amount</th>
                                            <th scope="col">Payment Date</th>
                                        </tr>
                                    </thead>
                                        <tr> 
                                            <td> <%=PB.getAccNo() %></td>
                                            <td> <%=PB.getReceiverAccNo() %></td>
                                            <td> <%=PB.getAmount() %></td>
                                            <td> <%=PB.getPaymentDate() %></td>
                                        </tr>                
                                </table>
                            </div>                
                        <%}    
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
