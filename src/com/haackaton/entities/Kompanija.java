package com.haackaton.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Kompanije")
public class Kompanija {
	
	private int id;
	private String naziv;
	private String adresa;
	private String brojPorezne;
	private int kompId;
	
	public Kompanija() {}
	
	public Kompanija(int id, String naziv, String adresa, String brojPorezne, int kompId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojPorezne = brojPorezne;
		this.kompId = kompId;
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
	
	@Column(name="naziv", nullable = false)
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	@Column(name="adresa", nullable = false)
	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	@Column(name="vat", nullable = false)
	public String getBrojPorezne() {
		return brojPorezne;
	}

	public void setBrojPorezne(String brojPorezne) {
		this.brojPorezne = brojPorezne;
	}

	@Column(name="kompanijaID", nullable = false)
	public int getKompId() {
		return kompId;
	}

	public void setKompId(int kompId) {
		this.kompId = kompId;
	}
	
}
