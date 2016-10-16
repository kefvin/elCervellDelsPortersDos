package Segon.monjosSuicides;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Random rand = new Random();
    	
    	int DINERSTOTALSMONJOS = 0;
        int QUANTITATDEMONJOS = 5;
        int PREUVITLLET = 60;
        
        Vaixell vaixell = new Vaixell(PREUVITLLET);
        
    	List<Monjo> monjos = new ArrayList();
        for(int i=0;i<QUANTITATDEMONJOS;i++){
        	monjos.add(new Monjo(rand.nextInt(PREUVITLLET-10)));
        }
        
        Run run = new Run();
        DINERSTOTALSMONJOS = run.conseguirDiners(monjos);
        run.controller(DINERSTOTALSMONJOS, PREUVITLLET, vaixell, monjos);
        
        
    }
}
