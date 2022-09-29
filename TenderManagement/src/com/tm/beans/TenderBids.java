package com.tm.beans;

public class TenderBids {
	
	private int sr_no;
	
    private String t_uid;
    
    private String client_uid;
    
    private int priceInCr;
    
    
    

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public String getT_uid() {
		return t_uid;
	}

	public void setT_uid(String t_uid) {
		this.t_uid = t_uid;
	}

	public String getClient_uid() {
		return client_uid;
	}

	public void setClient_uid(String client_uid) {
		this.client_uid = client_uid;
	}

	public int getPriceInCr() {
		return priceInCr;
	}

	public void setPriceInCr(int priceInCr) {
		this.priceInCr = priceInCr;
	}

	
	public TenderBids() {
		
	}
	
	
	
	public TenderBids(int sr_no, String t_uid, String client_uid, int priceInCr) {
		super();
		this.sr_no = sr_no;
		this.t_uid = t_uid;
		this.client_uid = client_uid;
		this.priceInCr = priceInCr;
	}

	@Override
	public String toString() {
		return "TenderBids [sr_no=" + sr_no + ", t_uid=" + t_uid + ", client_uid=" + client_uid + ", priceInCr="
				+ priceInCr + ", getSr_no()=" + getSr_no() + ", getT_uid()=" + getT_uid() + ", getClient_uid()="
				+ getClient_uid() + ", getPriceInCr()=" + getPriceInCr() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
    
    

}
