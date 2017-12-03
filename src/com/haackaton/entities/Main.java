package com.haackaton.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


import java.sql.Timestamp;


public class Main {
	
	
	private static SessionFactory factory;
	public static void main(String[] args) {
	
	Timestamp ts1 = new Timestamp(System.currentTimeMillis());
	Timestamp ts2 = new Timestamp(System.currentTimeMillis());
	Timestamp proba = null;
		
	try {	
	factory = new AnnotationConfiguration()
			.addPackage("com.haackaton.entities")
			.addAnnotatedClass(Kompanija.class)
			.addAnnotatedClass(Rezervacija.class)
			.addAnnotatedClass(Voznja.class)
			.addAnnotatedClass(User.class)
			.configure()
			.buildSessionFactory();
	}catch (Throwable ex) {
		ex.printStackTrace();
	}
			
		
	}
	
	public static void addData(int id,String naziv,String adresa,String brojPorezne,int kompId) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
		tx = session.beginTransaction();
		Kompanija komp = new Kompanija(id,naziv,adresa,brojPorezne,kompId);
		session.save(komp);
		tx.commit();
		}catch (HibernateException e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	
	public static void addRezervacija(int id, String qrCode, int voznjaId, int userId, int kompanijaId, int paymentId) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
		tx = session.beginTransaction();
		Rezervacija rez = new Rezervacija(id,qrCode,voznjaId,userId,kompanijaId,paymentId);
		session.save(rez);
		tx.commit();
		}catch (HibernateException e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public static void addVoznja(int id, String mjestoPolazak, String mjestoDolazak, Timestamp vrijemePolazak,
			Timestamp vrijemeDolazak, int voznjaId, int kompanijaId, String status, String vozac) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		
		try {
		tx = session.beginTransaction();
		Voznja voz = new Voznja(id,mjestoPolazak,mjestoDolazak,vrijemePolazak,vrijemeDolazak,voznjaId,kompanijaId,status,vozac);
		session.save(voz);
		tx.commit();
		}catch (HibernateException e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public static void addUser(int id, String ime, String prezime, String email, String tel, int godiste, String mjesto,
			int kompanijaId, String tipUsera) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
		tx = session.beginTransaction();
		User u = new User(id,ime,prezime,email,tel,godiste,mjesto,kompanijaId,tipUsera);
		session.save(u);
		tx.commit();
		}catch (HibernateException e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public static List<Voznja> getVoznja(String mjestoPolaska, String mjestoDolaska) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		Voznja voz = null;
		List<Voznja> listaVoznje = new ArrayList<Voznja>();
		
		try {
			tx = session.beginTransaction();
			String sql = "SELECT * FROM Voznje WHERE mjestoPolazak = ? AND mjestoDolazak = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Voznja.class);
			query.setString(0, mjestoPolaska);
			query.setString(1, mjestoDolaska);
			List results = query.list();
			
			
			for(Iterator iterator = results.iterator(); iterator.hasNext();) {
				Voznja voznja = (Voznja)iterator.next();
				voz = new Voznja(voznja.getId(),voznja.getMjestoPolazak(),voznja.getMjestoDolazak(),
						voznja.getVrijemePolazak(),voznja.getVrijemeDolazak(),voznja.getVoznjaId(),
						voznja.getKompanijaId(),voznja.getStatus(),voznja.getVozac());
				listaVoznje.add(voz);
				
			}
			tx.commit();
		}catch(HibernateException e) {
			if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}finally {
			session.close();
		}
		
		return listaVoznje;
		
	}

}
