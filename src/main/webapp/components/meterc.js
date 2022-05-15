$(document).ready(function() 
{  
	if ($("#alertSuccess").text().trim() == "")  
	{   
		$("#alertSuccess").hide();  
	} 
	$("#alertError").hide(); 
}); 

//SAVE ============================================ 
$(document).on("click", "#btnSave", function(event) 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 

	// Form validation-------------------  
	var status = validateMeterConnectionForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 

	// If valid------------------------  
	var t = ($("#hidmc_idSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
	{
		url : "MeterconnectionApi",
		type : t,
		data : $("#formMeterconnection").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onMeterconnectionSaveComplete(response.responseText, status);
		}
	});
}); 

function onMeterconnectionSaveComplete(response, status){
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Saved.");
			$("#alertSuccess").show();
					
			$("#divItemsGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Saving.");
		$("#slertError").show();
	}else{
		$("#alertError").text("Unknown Error while Saving.");
		$("#alertError").show();
	}
	$("#hidmc_idSave").val("");
	$("#formMeterconnection")[0].reset();
}

//UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) 
		{     
	$("#hidmc_idSave").val($(this).closest("tr").find('#hidPaymentIDUpdate').val());     
	$("#Mc_type").val($(this).closest("tr").find('td:eq(0)').text());    
	$("#Mc_phase_type").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#Mc_capacity").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#Mc_monthly_unit_usage").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#Mc_validity_status").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#Mc_power_distribution_status").val($(this).closest("tr").find('td:eq(3)').text()); 

});


//Remove Operation
$(document).on("click", ".btnRemove", function(event){
	$.ajax(
	{
		url : "MeterconnectionApi",
		type : "DELETE",
		data : "mc_id=" + $(this).data("mcid"),
		dataType : "text",
		complete : function(response, status)
		{
			onMeterconnectionDeletedComplete(response.responseText, status);
		}
	});
});

function onMeterconnectionDeletedComplet(response, status)
{
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Deleted.");
			$("#alertSuccess").show();
					
			$("#divItemsGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Deleting.");
		$("#alertError").show();
	}else{
		$("#alertError").text("Unknown Error While Deleting.");
		$("#alertError").show();
	}
}

//CLIENTMODEL
function validateMeterConnectionForm() {  
	
	if ($("#Mc_type").val().trim() == "")  {   
		return "Insert Meter Connection type.";  
		
	} 
	
 
	if ($("#Mc_phase_type").val().trim() == "")  {   
		return "Insert Meter Connection Phase type.";  
	} 
	

	if ($("#Mc_capacity").val().trim() == "")  {   
		return "Insert Meter Connection Capacity."; 
		 
	}
	 
	if ($("#Mc_monthly_unit_usage").val().trim() == "")  {   
		return "Monthly Unit Usage."; 
		 
	
	}
	
	if ($("#Mc_validity_status").val().trim() == "")  {   
		return "Validity Status."; 
	 
	}
	
	if ($("#Mc_power_distribution_status").val().trim() == "")  {   
		return "Power distribution status."; 
	 
	}
		

	 
	 return true; 
	 
}
/**
 * 
 */