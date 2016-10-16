package Segon.monjosSuicides;

import java.util.Random;

public class Monjo {

	int pedres = 5;
	int diners;
	int pedresAgafades = 0;
	
	// ******* Constructor *********
	public Monjo(int d){
		diners = d;
	}
	
	public void agafaPedres(){
		Random rand = new Random();
		pedresAgafades = (rand.nextInt(3)+1);
	}
	
	
	
	// ******** Getters & Setters **********
	public int getPedresAgafades(){
		return pedresAgafades;
	}
	
	public int getPedres() {
		return pedres;
	}

	public void setPedres(int pedres) {
		this.pedres = pedres;
	}

	public int getDiners() {
		return diners;
	}

	public void setDiners(int diners) {
		this.diners = diners;
	}
	
}
