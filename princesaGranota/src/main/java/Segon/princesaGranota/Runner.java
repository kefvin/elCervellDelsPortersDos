package Segon.princesaGranota;

import java.util.List;
import java.util.Random;

import acm.graphics.GImage;

/*
Se puede acabar por:
	- encuentra la princesa
	- demasiadas ranas
Recargar por:
	- encuentra rana
*/

public class Runner {

	App pantalla;
	GImage panta;
	
	public Runner(App p, GImage i) {
		pantalla = p;
		panta = i;
	}

	public void run(Cavaller cavaller, List<Granota>granotes,Princesa princesa, int MAXIMGRANOTES) {
		
		
		boolean trobada = false;
		while(!trobada){
			moureGranota(granotes, princesa);
			trobada = comprovaChoca(cavaller, granotes, princesa, MAXIMGRANOTES);
		}
		
		
	}



	private boolean comprovaChoca(Cavaller cavaller, List<Granota>granotes,Princesa princesa, int MAXIMGRANOTES) {
		boolean chocaPrincesa = cavaller.getICavaller().getBounds().intersects(princesa.getIPrincesa().getBounds());
		if(chocaPrincesa){
			pantalla.win();
			return true;
		}
		for( Granota granota: granotes){
			boolean chocaGranota = cavaller.getICavaller().getBounds().intersects(granota.getIGranota().getBounds());
			if(chocaGranota){
				if(granotes.size()< MAXIMGRANOTES){
					pantalla.creaGranotes(granotes);
					pantalla.recolocarGranotes(granotes, princesa);
					return false;
				}else{
					pantalla.gameOver();
					return true;
				}
				
			}
		}
		return false;
	}



	private void moureGranota(List<Granota>granotes, Princesa princesa) {

		Random rand = new Random();
		int signeX = positiuONegatiu();
		int signeY = positiuONegatiu();
		princesa.getIPrincesa().move(rand.nextInt(20)*signeX, rand.nextInt(20)*signeY);
		limitPantalla(princesa.getIPrincesa());
		
		for(Granota granota: granotes){
			granota.getIGranota().move(rand.nextInt(20)*signeX, rand.nextInt(20)*signeY);
			limitPantalla(granota.getIGranota());
			pausa();
		}
	}



	private int positiuONegatiu() {
		Random rand = new Random();
		if(rand.nextInt(2) == 0){
			return -1;
		}
		return 1;
	}
	
	public void pausa(){
		// Crea la pausa
				try {
					Thread.sleep(30L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void limitPantalla(GImage imatge){
		double x = imatge.getX();
		double y = imatge.getY();
		double limitX = pantalla.getWidth()-imatge.getWidth();
		double limitY = pantalla.getHeight()-imatge.getHeight();
						
		if(x < 0 ){
			imatge.setLocation(0, y);
		}else if(x > limitX){
			imatge.setLocation(limitX, y);
		}
		
		if(y < 0 ){
			imatge.setLocation(x, 0);
		}else if(y > limitY){
			imatge.setLocation(x, limitY);
		}
		
	}
}
