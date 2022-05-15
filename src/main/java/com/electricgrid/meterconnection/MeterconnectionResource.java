package com.electricgrid.meterconnection;

import com.electricgrid.meterconnection.Meterconnection;
import com.electricgrid.meterconnection.MeterconnectionRepository;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/meterconnections")

public class MeterconnectionResource {
	
	MeterconnectionRepository mc1 = new MeterconnectionRepository();
	
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Meterconnection> getAllMeterconnections() {
		return mc1.getAllMeterconnections();
    }
	

    @GET
    @Path("metercon/{mc_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Meterconnection getMeterconnection(@PathParam("mc_id") int mc_id) {

        return mc1.getMeterconnection(mc_id);

    }
	
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createMeterconnection(Meterconnection mc) {
		return mc1.createMeterconnection(mc);
	}
	
	
	
	
	@DELETE
	@Path("/delete/{mc_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMeterconnection(@PathParam("mc_id") int mc_id) {
		return mc1.deleteMeterconnection(mc_id);
	}
	
	
	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	
	public String updateMeterconnection(Meterconnection mc) 
	{ 
		return mc1.updateMeterconnection(mc);
	}
	
	
	
	
}
