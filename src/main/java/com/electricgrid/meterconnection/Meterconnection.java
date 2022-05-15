package com.electricgrid.meterconnection;

public class Meterconnection {
	
	public int mc_id;
	public String mc_type;
	public String mc_phase_type;
	public float mc_capacity;
	public float mc_monthly_unit_usage;
	public String mc_validity_status;
	public String mc_power_distribution_status;
	public int user_acc_id;
	public int billing_id;
	
	public int getMc_id() {
		return mc_id;
	}
	public void setMc_id(int mc_id) {
		this.mc_id = mc_id;
	}
	public String getMc_type() {
		return mc_type;
	}
	public void setMc_type(String mc_type) {
		this.mc_type = mc_type;
	}
	
	public String getMc_phase_type() {
		return mc_phase_type;
	}
	public void setMc_phase_type(String mc_phase_type) {
		this.mc_phase_type = mc_phase_type;
	}
	public float getMc_capacity() {
		return mc_capacity;
	}
	public void setMc_capacity(float mc_capacity) {
		this.mc_capacity = mc_capacity;
	}
	public float getMc_monthly_unit_usage() {
		return mc_monthly_unit_usage;
	}
	public void setMc_monthly_unit_usage(float mc_monthly_unit_usage) {
		this.mc_monthly_unit_usage = mc_monthly_unit_usage;
	}
	public String getMc_validity_status() {
		return mc_validity_status;
	}
	public void setMc_validity_status(String mc_validity_status) {
		this.mc_validity_status = mc_validity_status;
	}
	public String getMc_power_distribution_status() {
		return mc_power_distribution_status;
	}
	public void setMc_power_distribution_status(String mc_power_distribution_status) {
		this.mc_power_distribution_status = mc_power_distribution_status;
	}
	public int getUser_acc_id() {
		return user_acc_id;
	}
	public void setUser_acc_id(int user_acc_id) {
		this.user_acc_id = user_acc_id;
	}
	public int getBilling_id() {
		return billing_id;
	}
	public void setBilling_id(int billing_id) {
		this.billing_id = billing_id;
	}
	
	@Override
	public String toString() {
		return "Meter_connection [mc_id=" + mc_id + ", mc_type=" + mc_type + ", mc_phase_type=" + mc_phase_type + ", mc_capacity=" +mc_capacity
				+ ", mc_monthly_unit_usage=" + mc_monthly_unit_usage + ", mc_validity_status=" + mc_validity_status + ", mc_power_distribution_status=" + mc_power_distribution_status + ", user_acc_id=" + user_acc_id
				+ ", billing_id=" + billing_id + " ]";
	
	

	}
	
}

