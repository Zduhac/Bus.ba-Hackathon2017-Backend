package com.haackaton.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Voznje")
public class Voznja {
	
	private int id;
	private String mjestoPolazak;
	private String mjestoDolazak;
	private Timestamp vrijemePolazak;
	private Timestamp vrijemeDolazak;
	private int voznjaId;
	private int kompanijaId;
	private String status;
	private String vozac;
	
	//(GET)search api na osnovu mjestaPolaska, dolaska, vrijemePolaska /search?polazak=Mostar&dolazak=Sarajevo&vrijeme=Timestamp
	//(POST)kreirati juzera iz JSONa koji dobijem u badiju od POSTa
	
	public Voznja() {}

	public Voznja(int id, String mjestoPolazak, String mjestoDolazak, Timestamp vrijemePolazak,
			Timestamp vrijemeDolazak, int voznjaId, int kompanijaId, String status, String vozac) {
		super();
		this.id = id;
		this.mjestoPolazak = mjestoPolazak;
		this.mjestoDolazak = mjestoDolazak;
		this.vrijemePolazak = vrijemePolazak;
		this.vrijemeDolazak = vrijemeDolazak;
		this.voznjaId = voznjaId;
		this.kompanijaId = kompanijaId;
		this.status = status;
		this.vozac = vozac;
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
	
	@Column(name="mjestoPolazak", nullable = false)
	public String getMjestoPolazak() {
		return mjestoPolazak;
	}

	public void setMjestoPolazak(String mjestoPolazak) {
		this.mjestoPolazak = mjestoPolazak;
	}
	
	@Column(name="mjestoDolazak", nullable = false)
	public String getMjestoDolazak() {
		return mjestoDolazak;
	}

	public void setMjestoDolazak(String mjestoDolazak) {
		this.mjestoDolazak = mjestoDolazak;
	}
	
	@Column(name="vrijemePolazak", nullable = false)
	public Timestamp getVrijemePolazak() {
		return vrijemePolazak;
	}

	public void setVrijemePolazak(Timestamp vrijemePolazak) {
		this.vrijemePolazak = vrijemePolazak;
	}
	
	@Column(name="vrijemeDolazak", nullable = false)
	public Timestamp getVrijemeDolazak() {
		return vrijemeDolazak;
	}

	public void setVrijemeDolazak(Timestamp vrijemeDolazak) {
		this.vrijemeDolazak = vrijemeDolazak;
	}

	@Column(name="voznjaID", nullable = false)
	public int getVoznjaId() {
		return voznjaId;
	}

	public void setVoznjaId(int voznjaId) {
		this.voznjaId = voznjaId;
	}
	
	@Column(name="kompanijaID", nullable = false)
	public int getKompanijaId() {
		return kompanijaId;
	}

	public void setKompanijaId(int kompanijaId) {
		this.kompanijaId = kompanijaId;
	}

	@Column(name="status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="vozac", nullable = false)
	public String getVozac() {
		return vozac;
	}

	public void setVozac(String vozac) {
		this.vozac = vozac;
	}
	
	
}
