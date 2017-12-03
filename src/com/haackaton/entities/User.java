package com.haackaton.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Users")
public class User {
	
	private int id;
	private String ime;
	private String prezime;
	private String email;
	private String tel;
	private int godiste;
	private String mjesto;
	private int kompanijaId;
	private String tipUsera;
	
	public User() {}

	public User(int id, String ime, String prezime, String email, String tel, int godiste, String mjesto,
			int kompanijaId, String tipUsera) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.tel = tel;
		this.godiste = godiste;
		this.mjesto = mjesto;
		this.kompanijaId = kompanijaId;
		this.tipUsera = tipUsera;
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

	@Column(name="ime", nullable = false)
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	@Column(name="prezime", nullable = false)
	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Column(name="email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="telefon", nullable = false)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name="godiste", nullable = false)
	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	@Column(name="mjesto", nullable = false)
	public String getMjesto() {
		return mjesto;
	}

	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}

	@Column(name="kompanijaID", nullable = false)
	public int getKompanijaId() {
		return kompanijaId;
	}

	public void setKompanijaId(int kompanijaId) {
		this.kompanijaId = kompanijaId;
	}

	@Column(name="tipUsera", nullable = false)
	public String getTipUsera() {
		return tipUsera;
	}

	public void setTipUsera(String tipUsera) {
		this.tipUsera = tipUsera;
	}
	
}
