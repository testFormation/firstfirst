package org.formation.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.formation.BeanMetier.Client;
import org.formation.dao.ClientDBUtil;

public class ServiceClient {

	private List<Client> listClient = new ArrayList<>();

	public List<Client> getClient() {
		try {
			listClient = ClientDBUtil.getInstance().getClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listClient;
	}

	public void addClient(Client c) {
		try {
			boolean exist = false;
			for (Client client : listClient) {
				if (c.getNom().equals(client.getNom()) && c.getPrenom().equals(client.getPrenom())) {
					exist = true;
					System.out.println("Je suis dans ma boucle");
					// return "AjoutClient";
				} else {

					System.out.println("un client nouveau");
				}
			}
			if(!exist){
				ClientDBUtil.getInstance().addClient(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
