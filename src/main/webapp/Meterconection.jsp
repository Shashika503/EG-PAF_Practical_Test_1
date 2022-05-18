<%@page import com.electricgrid.meterconnection.Meterconnection;%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meter Connection Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css"> 

<script src="components/jquery-3.6.0.js"></script>
<script src="components/pay.js"></script>



<nav class="navbar navbar-expand-md navbar-dark" style="background-color: 	#5353ff">
                   

                    <ul class="navbar-nav">
                        <li><a href="Index.jsp" class="nav-link">EG Online Platform</a></li>
                    </ul>
                </nav>
</head>
<body>


<br>
<br>


<div class="container"> 
		<div class="row">  
		 <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       

                        <caption>
                            <h2>
                                Meter Connection Management
                            </h2>
                        </caption>  
				
				<form id="formPayment" name="formPayment" method="post" action="Payment.jsp">  
					Meter Connection Type:  
					<input id="Meterconnectiontype" name="Meterconnectiontype" type="text" class="form-control form-control-sm">  
					
					<br> 
					Meter Connection Phase Type:  
					<input id="Meterconnectionphasetype" name="Meterconnectionphasetype" type="text" class="form-control form-control-sm">  
					
					<br>
					 Meter Connection Capacity:  
					 <input id="meterconnectioncapacity" name="meterconnectioncapacity" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					 Monthly Unit Usage:  
					 <input id="CardNumber" name="CardNumber" type="text" class="form-control form-control-sm">  
					 
					 Validity Status:  
					 <input id="Validitystatus" name="validitystatus" type="text" class="form-control form-control-sm">  
					
					 Power Distribution Status:  
					 <input id="Powerdistributionstatus" name="Powerdistributionstatus" type="text" class="form-control form-control-sm">  
					 
					 <br>  
					 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					 <input type="hidden" id="hidmc_idSave" name="hidmc_idSave" value=""> 
					 
				</form> 
				
				  </div>
                </div>
            </div>
				
				<div id="alertSuccess" class="alert alert-success"></div>  
				<div id="alertError" class="alert alert-danger"></div> 
				
				<br>
					
				
            <div class="row">
               

                <div class="container">
                    <h3 class="text-center">Meter Connection Details</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="Index.jsp" class="btn btn-success"style="background-color:#5353ff">Navigate To Home page</a>
                    </div>
                    <br>
                   <div id="divItemsGrid">   
					<%    
					Meterconnection meterc = new Meterconnection();
						out.print(meterc.readMeterconnection());   
					%>  
					
					
					<br><br><br>
				
                   
                </div>
            </div>
				  
 			</div>
 		 
 		</div>   
 		 <br>
</body>


</html>