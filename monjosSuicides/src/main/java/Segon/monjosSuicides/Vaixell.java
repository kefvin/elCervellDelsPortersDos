package Segon.monjosSuicides;

import java.util.ArrayList;
import java.util.List;

public class Vaixell {

	int preuVitllet;
	List<Monjo> monjos = new ArrayList();
	
	// ***** CONSTRUCTOR ******
	public Vaixell(int pVitllet){
		preuVitllet = pVitllet;
	}
	
	public void monjosPujen(List<Monjo> m){
		monjos = m;
	}

	// ****** GETTERS & SETTERS ******
	public int getPreuVitllet() {
		return preuVitllet;
	}

	public void setPreuVitllet(int preuVitllet) {
		this.preuVitllet = preuVitllet;
	}
	
}
