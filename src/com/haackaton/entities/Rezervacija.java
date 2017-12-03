package com.haackaton.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Rezervacije")
public class Rezervacija {
	
	private int id;
	private String qrCode;
	private int voznjaId;
	private int userId;
	private int kompanijaId;
	private int paymentId;
	
	public Rezervacija() {}

	public Rezervacija(int id, String qrCode, int voznjaId, int userId, int kompanijaId, int paymentId) {
		super();
		this.id = id;
		this.qrCode = qrCode;
		this.voznjaId = voznjaId;
		this.userId = userId;
		this.kompanijaId = kompanijaId;
		this.paymentId = paymentId;
	}
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="qrcode", nullable = false)
	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
	@Column(name="voznjaID", nullable = false)
	public int getVoznjaId() {
		return voznjaId;
	}

	public void setVoznjaId(int voznjaId) {
		this.voznjaId = voznjaId;
	}
	
	@Column(name="userID", nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="kompanijaID", nullable = false)
	public int getKompanijaId() {
		return kompanijaId;
	}

	public void setKompanijaId(int kompanijaId) {
		this.kompanijaId = kompanijaId;
	}
	
	@Column(name="paymentID", nullable = false)
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	

}
