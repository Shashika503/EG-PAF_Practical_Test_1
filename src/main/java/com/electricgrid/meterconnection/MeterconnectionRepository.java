package com.electricgrid.meterconnection;

import com.electricgrid.meterconnection.Meterconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MeterconnectionRepository {
	
	 //Creating the Database Connection
    Connection con = null;

    public MeterconnectionRepository() {

        String url = "jdbc:mysql://localhost:3306/electric_grid";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);

            System.out.println("Database is successfully Connected!!!");
        }
        catch (Exception e) {
            System.out.println("Error while Connecting to database!!");
        }
    }

		
    //Implementing a method for retrive data for display
    public List<Meterconnection> getAllMeterconnections(){

        List<Meterconnection> meterCon = new ArrayList<>();
        String sql = "SELECT * FROM electric_grid.meter_connection";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
            	Meterconnection pc = new Meterconnection();
                pc.setMc_id(rs.getInt(1));
                pc.setMc_type(rs.getString(2));
                pc.setMc_phase_type(rs.getString(3));
                pc.setMc_capacity(rs.getFloat(4));
                pc.setMc_monthly_unit_usage(rs.getFloat(5));
                pc.setMc_validity_status(rs.getString(6));
                pc.setMc_power_distribution_status(rs.getString(7));
                pc.setUser_acc_id(rs.getInt(8));
                pc.setBilling_id(rs.getInt(9));
              

                meterCon.add(pc);
            }
        }
        catch (Exception e) {
            System.out.println("Error while fetching data!");
        }

        return   meterCon;
    }
    
    //Implementing a method for retrieve data for search operation
    public Meterconnection getMeterconnection(int mc_id) {

        String sql = "SELECT * FROM electric_grid.meter_connection WHERE id=" +mc_id;
        Meterconnection pc = new Meterconnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
            	  pc.setMc_id(rs.getInt(1));
                  pc.setMc_type(rs.getString(2));
                  pc.setMc_phase_type(rs.getString(3));
                  pc.setMc_capacity(rs.getFloat(4));
                  pc.setMc_monthly_unit_usage(rs.getFloat(5));
                  pc.setMc_validity_status(rs.getString(6));
                  pc.setMc_power_distribution_status(rs.getString(7));
                  pc.setUser_acc_id(rs.getInt(8));
                  pc.setBilling_id(rs.getInt(9));

            }
        }
        catch (Exception e) {
            System.out.println("Error in Serching data!!!");
        }

        return pc;
    }

    //Implementing a method for Create data for update operation
		public String createMeterconnection(Meterconnection mc) {
			
			
			// create a prepared statement
		    String sql = "INSERT INTO electric_grid.meter_connection VALUE (?,?,?,?,?,?,?,?,?)";
	        String output ="";
			try {
				
				PreparedStatement st = con.prepareStatement(sql);
				
				// binding values
				st.setInt(1, mc.mc_id);
				st.setString(2, mc.mc_type);
				st.setString(3, mc.mc_phase_type);
				st.setFloat(4, mc.mc_capacity);
				st.setFloat(5, mc.mc_monthly_unit_usage);
				st.setString(6, mc.mc_validity_status);
				st.setString(7, mc.mc_power_distribution_status);
				st.setInt(8, mc.user_acc_id);
				st.setInt(9, mc.billing_id);
				
				// execute the statement
				 st.executeUpdate();
		            output = "Inserted Successfully !";
		        }
		        catch (Exception e) {
		            output = "adding data into database went wrong!";
		            System.err.println(e.getMessage());
		        }
		        return output;
		    }


		
		 //Implementing a method for Delete data for delete operation
	    public String deleteMeterconnection(int mc_id) {

	        String sql = "DELETE FROM electric_grid.meter_connection WHERE mc_id =?";
	        String output ="";
	        try {
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setInt(1, mc_id);
	            st.executeUpdate();
	            //System.out.println("Successfully deleted the Power Consumption Entry!!!");
	            output = "Deleted Successfully !";
	        }
	        catch (Exception e) {
	            output = "Error While Deleting!";
	            System.err.println(e.getMessage());
	        }
	    return output;
	    }
		
		
		
	    //Implementing a method for Update data for update operation
			
		public String updateMeterconnection(Meterconnection mc) {
			 String sql = "UPDATE electric_grid.meter_connection SET mc_type=?, mc_phase_type=?, mc_capacity=?, mc_monthly_unit_usage=?, mc_validity_status=?, mc_power_distribution_status=?, user_acc_id=?, billing_id=? WHERE mc_id =?";
		        String output ="";
		        try {
		            PreparedStatement st = con.prepareStatement(sql);
		            st.setString(1, mc.getMc_type());
		            st.setString(2, mc.getMc_phase_type());
		            st.setFloat(3, mc.getMc_capacity());
		            st.setFloat(4, mc.getMc_monthly_unit_usage());
		            st.setString(5, mc.getMc_validity_status());
		            st.setString(6, mc.getMc_power_distribution_status());
		            st.setInt(7,mc.getUser_acc_id());
		            st.setInt(8,mc.getBilling_id());
		            st.setInt(9,mc.getMc_id());

		            st.executeUpdate();
		            output = "Updated Successfully !";
		        }
		        catch (Exception e) {
		            output = "Database cannot update Power Consumption details !";
		            System.err.println(e.getMessage());
		        }
		        return output;
		    }
}
