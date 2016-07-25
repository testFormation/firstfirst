package org.formation.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.formation.BeanMetier.Client;
import org.formation.dao.ClientDBUtil;
import org.formation.service.ServiceClient;

import com.sun.media.jfxmedia.logging.Logger;

@ManagedBean(name = "clientController")
@SessionScoped

public class ClientController {

	ServiceClient serviceClient=new ServiceClient();
	private List<Client> listClient = new ArrayList<>();

	public ClientController() {
		// addClient();
	}

	/*
	 * public void addClient(){ listClient.add(new Client("bobo", "toto",
	 * "toto@123.gmail")); listClient.add(new Client("popo", "titi",
	 * "titi@123.gmail")); listClient.add(new Client("dodo", "bubu",
	 * "bubu@123.gmail")); }
	 */
	public List<Client> getListClient() {
		try {
			listClient= serviceClient.getClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public String ajoutUnClient(Client c) {

		try {			
			
			serviceClient.addClient(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*logger.log(Level.SEVERE, "Error adding students", e);
			return null;*/
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Votre information est déjà enregistré", null);
		
		}
		return "index?faces-redirect=true";
	}

}
