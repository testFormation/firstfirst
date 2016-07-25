package org.formation.BeanMetier;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.formation.BeanMetier.Client;



public class ClientDB {
	

	private List<Client> listClient=new ArrayList<>();
	
	public ClientDB(){
		addClient();		
	}
	
	public void addClient(){
		listClient.add(new Client("bobo", "toto", "toto@123.gmail"));	
		listClient.add(new Client("popo", "titi", "titi@123.gmail"));		
		listClient.add(new Client("dodo", "bubu", "bubu@123.gmail"));		
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}
	

}
