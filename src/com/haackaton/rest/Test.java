package com.haackaton.rest;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haackaton.entities.Kompanija;
import com.haackaton.entities.Main;
import com.haackaton.entities.Rezervacija;
import com.haackaton.entities.User;
import com.haackaton.entities.Voznja;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;


@Path("/test")
public class Test implements ContainerResponseFilter{
	Timestamp ts = null;
	
	@Override
    public ContainerResponse filter(ContainerRequest request,
            ContainerResponse response) {
		
        response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHttpHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        
        return response;
    }

		
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String search(@QueryParam("od")String polazak,
			@QueryParam("do")String dolazak){
			
			Gson gson = new GsonBuilder().create();
			Voznja voznja = null;
			Main ma = new Main();
			ma.main(null);
			List<Voznja> listaVoznje;
			
			listaVoznje = ma.getVoznja(polazak, dolazak);
			
			String json = gson.toJson(listaVoznje);
			return json;
			}
	

}
