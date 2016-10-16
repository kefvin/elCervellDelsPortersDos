package Segon.elCervellDelsPortersDos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {

	
	public List crea(int qClients) {
		List<Client> clients = new ArrayList<Client>();
		Random rand = new Random();
		String[] sexe = { "Home", "Dona" };
		String[] sabates = { "Bambes", "Sandalies", "Botes", "Espardeñes" };
		String[] nom = { "Bambi", "Simba", "Ariel", "Mulan" };


		for (int i = 0; i < qClients; i++) {
			clients.add(
					new Client(nom[rand.nextInt(3)], rand.nextInt(90), sexe[rand.nextInt(1)], sabates[rand.nextInt(3)], rand.nextInt(200)));
		}
		return clients;
	}
	
	public List<Client> corre(List<Client> clients, int edatEntrada, String sexeEntrada, String sabatesEntrada , int dinersEntrada){
		 List<Client> entren = new ArrayList<>();
		// Comprovar que demana el porter i per ifs per comprovar els clients
    	Porter porter = new Porter(edatEntrada, sexeEntrada, sabatesEntrada, dinersEntrada);
    	
		for(Client client: clients){
			if(porter.check(client)){
				entren.add(client);
			}
		}
		return entren;
	}
	
	public void imprimeix(List<Client> entren){
		for(Client dints: entren){
			System.out.println(dints);
		}
	}
	
}
