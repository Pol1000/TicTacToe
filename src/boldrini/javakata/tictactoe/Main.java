package boldrini.javakata.tictactoe;

import java.util.Random;
import java.util.Scanner;

import boldrini.javakata.tictactoe.exception.GiocoFinitoException;
import boldrini.javakata.tictactoe.model.TicTacToe;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean run = true;
		while(run){
		    Scanner input = new Scanner(System.in);
		    int scelta;
		    System.out.println("cosa vuoi fare?");
		    System.out.print("1: vedi un'altra partita \n2: esci\n Option: ");
		    scelta = input.nextInt();

		    switch(scelta){
		        case 1:
		            nuovaPartita();
		            break;
	            case 2:
	            	System.out.println("Arrivederci!");
		            run=false;
		            break;
		            default:
		            System.out.println("Opzione non valida");
		    }
		}
	}

	
	private static void nuovaPartita() {
		TicTacToe gioco = new TicTacToe();
		
		gioco.stampaSchemaAVideo();
		try {
			boolean giocataFatta;
			for (int i = 0; i < 9; i++) {
				giocataFatta=false;
				while(giocataFatta==false){
				 int colonna = getNumeroRandom(); 
				 int riga = getNumeroRandom();
				 
				 if ((i%2)==0){
					 giocataFatta=gioco.setCerchio(riga, colonna);
				 }
				 else{
					 giocataFatta=gioco.setCroce(riga,colonna);
				 }
				} 
				if(gioco.isVincitoreDiversoDaVuoto())
				{
					break;
				}
				 Thread.sleep(2000); 
			}
			System.out.println("Ha vinto : "+gioco.getVincitore().toString());
		} catch (GiocoFinitoException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static int getNumeroRandom(){
		Random rand = new Random();
		return rand.nextInt(3);
	}
}
