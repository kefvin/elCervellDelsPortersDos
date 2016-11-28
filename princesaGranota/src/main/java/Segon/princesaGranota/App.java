package Segon.princesaGranota;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * Plantilla base per fer un programa fent servir les llibreries ACM.
 *
 */
public class App extends GraphicsProgram {
	/**
	*
	*/
	private static final long serialVersionUID = 1299094805237490891L;
	private static final int AMPLADAPANTALLA = 1024;
	private static final int ALTURAPANTALLA = 644;
	private static final int GRANOTESACREAR = 10;
	GImage Icavaller = new GImage("cavallerr.png");
	GImage panta = new GImage("panta.png");
	private static final int MOVIMENTCAVALLER = 10;
	private static final int MAXIMGRANOTES = 15;
	
	Runner runner = new Runner(this, panta);
	// Private Constructor per evitar que el crein

	/**
	 * Programa principal...
	 */
	@Override
	public final void run() {
		setSize(AMPLADAPANTALLA, ALTURAPANTALLA);
		addKeyListeners();
		clicaPerComencar();

		List<Granota> granotes = new ArrayList();
		panta.setSize(AMPLADAPANTALLA, ALTURAPANTALLA);
		add(panta, 0, 0);

		Cavaller cavaller = new Cavaller(Icavaller);
		add(Icavaller, AMPLADAPANTALLA / 2, ALTURAPANTALLA / 2);

		for (int i = 0; i < GRANOTESACREAR; i++) {
			creaGranotes(granotes);
		}
		
		Random rand = new Random();
		GImage Iprincesa = new GImage("princesa.png");
		Princesa princesa = new Princesa(Iprincesa);
		add(Iprincesa, rand.nextInt(AMPLADAPANTALLA), rand.nextInt(ALTURAPANTALLA));

		runner.run(cavaller, granotes, princesa, MAXIMGRANOTES);

	}
	
	public void creaGranotes(List<Granota> granotes){
		Random rand = new Random();
		GImage Igranota = new GImage("grranota.png");
		Granota granota = new Granota(Igranota);
		add(Igranota, rand.nextInt(AMPLADAPANTALLA), rand.nextInt(ALTURAPANTALLA));
		granotes.add(granota);
	}

	/**
	 * Clica per començar.
	 */
	private void clicaPerComencar() {
		GLabel label = new GLabel("Clica per començar");
		double x = (AMPLADAPANTALLA - label.getWidth()) / 2;
		double y = (ALTURAPANTALLA + label.getAscent()) / 2;
		add(label, x, y);
		waitForClick();
		remove(label);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		switch(tecla){
		case KeyEvent.VK_UP:
			Icavaller.move(0, -MOVIMENTCAVALLER);
			break;
		case KeyEvent.VK_DOWN:
			Icavaller.move(0, MOVIMENTCAVALLER);
			break;
		case KeyEvent.VK_LEFT:
			Icavaller.move(-MOVIMENTCAVALLER, 0);
			break;
		case KeyEvent.VK_RIGHT:
			Icavaller.move(MOVIMENTCAVALLER, 0);
			break;
		}
		runner.limitPantalla(Icavaller);
	}
	
	public void gameOver(){
		GImage acaba = new GImage("gameover.png");
		add(acaba, (AMPLADAPANTALLA / 2) - (acaba.getHeight() /2), (ALTURAPANTALLA / 2) - (acaba.getWidth() /2));
	}

	public void recolocarGranotes(List<Granota>granotes,Princesa princesa) {
		Random rand = new Random();
		for(Granota granota: granotes){
			granota.getIGranota().setLocation(rand.nextInt(AMPLADAPANTALLA), rand.nextInt(ALTURAPANTALLA));
		}
		runner.pausa();
	}

	public void win() {
		GImage acaba = new GImage("princessa.png");
		add(acaba, (AMPLADAPANTALLA / 2) - (acaba.getHeight() /2), (ALTURAPANTALLA / 2) - (acaba.getWidth() /2));
	}
	
	
}