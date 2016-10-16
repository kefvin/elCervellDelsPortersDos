package Segon.elCervellDelsPortersDos;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

    	List<Client> clients = new ArrayList<Client>();
    	
    	int qClients = 3;
    	int edatEntrada =20;
    	String sexeEntrada = "";
    	String sabatesEntrada = "";
    	int dinersEntrada = 50;
    	
    	Run run = new Run();
    	
    	clients = run.crea(qClients);
    	List<Client> entren = new ArrayList<Client>();
    	entren = run.corre(clients, edatEntrada, sexeEntrada, sabatesEntrada, dinersEntrada);
    	run.imprimeix(entren);
    	
    }
}
