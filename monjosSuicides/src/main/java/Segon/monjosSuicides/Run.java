package Segon.monjosSuicides;

import java.util.List;
import java.util.Random;

public class Run {
	
	// ********** AGAFA ELS DINERS DE TOTS EL MONJOS ***********
	public int conseguirDiners(List<Monjo> monjos){
		int pasta = 0;
		for(Monjo temp: monjos){
			pasta += temp.getDiners();
		}
		return pasta;
	}
	
	// ****************** EXTENSIO DEL APP *******************
	public void controller(int DINERSTOTALSMONJOS, int PREUVITLLET, Vaixell vaixell, List<Monjo> monjos){
		if(DINERSTOTALSMONJOS < PREUVITLLET){
			monjos.removeAll(monjos);
			System.out.println("Els diners totals dels monjos son "+DINERSTOTALSMONJOS+" i el preu"
					+ " del bitllet és "+PREUVITLLET+" com que no els arriba, han acordat fer un suicidi "
							+ "col·lectiu.");
		}else{
			boolean morts = false;
			while(PREUVITLLET * monjos.size() > DINERSTOTALSMONJOS){
				joc(monjos);
				if(monjos.size() == 0){
					morts = true;
					break;
				}
			}
			if(morts){
				System.out.println("Tots els monjos han mort perque Déu no els estima");
			}else{
				vaixell.monjosPujen(monjos);
				System.out.println("Han pogut pujar al vaixell "+monjos.size()+", Déu els ha escollit.");
			}
		}
	}

	
	
	public void joc(List<Monjo> monjos){
		
		Random rand = new Random();
		int dau = rand.nextInt(5)+1;
		
		for(int i = monjos.size()-1; i>0; i--){
			monjos.get(i).agafaPedres();
			if(dau == monjos.get(i).getPedresAgafades()){
				monjos.remove(monjos.get(i));
			}
		}
		
	}
	
}
