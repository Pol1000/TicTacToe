package boldrini.javakata.tictactoe.model;

import boldrini.javakata.tictactoe.exception.GiocoFinitoException;

public class TicTacToe {
    
	  public static enum SIMBOLI_AMMESSI {
	    	EMPTY("-"),
	    	X("X"),
	    	O("O");
	    	
			private final String label;
			
			private SIMBOLI_AMMESSI(String label) {
				this.label = label;
			}

			@Override
			public String toString() {
				return label;
			}
	    	}
    private SIMBOLI_AMMESSI[][] schemaGioco;
    
    private SIMBOLI_AMMESSI vincitore;
    
    private int celleUsate;
    
    public TicTacToe() {
    	 schemaGioco= new SIMBOLI_AMMESSI[3][3];
         vincitore=SIMBOLI_AMMESSI.EMPTY;
         init();
    }
    
    public void stampaSchemaAVideo(){
		for (int x = 0; x < 3; x++) {
			System.out.print("|");
            for (int y = 0; y < 3; y++) {
            	System.out.print(" "+schemaGioco[x][y].toString()+" ");
            }
			System.out.println("|");
       }
		
		System.out.println("----------------------");
		System.out.println(" ");
    }
    

    //Inizializza lo schema di gioco
	private void init() {
		celleUsate=0;
		for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                schemaGioco[x][y] = SIMBOLI_AMMESSI.EMPTY;
            }
        }
	}

	//Setta simbolo O alle posizione x, y passate.
	public boolean setCerchio(int x, int y) throws GiocoFinitoException {
        return set(x, y, SIMBOLI_AMMESSI.O);
    }

    
  //Setta simbolo X alle posizione x, y passate.
     public boolean setCroce(int x, int y) throws GiocoFinitoException {
        return set(x, y, SIMBOLI_AMMESSI.X);
    }

     // Restituisce il simbolo alla posizione passata.
     SIMBOLI_AMMESSI getSimboloAllaPosizione(int x, int y)
     {
    	 return schemaGioco[x][y];
     } 
     
     public boolean isVincitoreDiversoDaVuoto() {
         return vincitore != SIMBOLI_AMMESSI.EMPTY;
     }
        
     public SIMBOLI_AMMESSI getVincitore() {
          return vincitore;
     }
     
    //Dopo ogni mossa controllo se è quella vincente. 
    private boolean set(int x, int y, SIMBOLI_AMMESSI simboloDaMettere) throws GiocoFinitoException {
        if (schemaGioco[x][y] == SIMBOLI_AMMESSI.EMPTY) {
            schemaGioco[x][y] = simboloDaMettere;
            //Mossa valida.
            checkForvincitore(x, y, simboloDaMettere);
            celleUsate=celleUsate+1;
            stampaSchemaAVideo();

        	if((celleUsate==9)&&(getVincitore().equals(SIMBOLI_AMMESSI.EMPTY)))
        	{
        		vincitore=SIMBOLI_AMMESSI.EMPTY;
        		throw new GiocoFinitoException();
        	}
            return true;
        }
        //La mossa non era valida
        return false;
    }

    private void checkForvincitore(int x, int y, SIMBOLI_AMMESSI simboloDaMettere) {
        checkForThreeInACol(y, simboloDaMettere);
        checkForThreeInARow(x, simboloDaMettere);
        checkForThreeInTheDiag(x, y, simboloDaMettere);
        checkForThreeInTheAntiDiag(x, y, simboloDaMettere);
    }

    private void checkForThreeInTheAntiDiag(int x, int y, SIMBOLI_AMMESSI simboloDaMettere) {
        if (x + y == 2) {
            for (int i = 0; i < schemaGioco.length; i++) {
                if (getValoreCella(i,2-i) != simboloDaMettere) {
                    break;
                }

                if(i == 2) {
                    vincitore = simboloDaMettere;
                }
            }
        }
    }


    private void checkForThreeInTheDiag(int x, int y, SIMBOLI_AMMESSI simboloDaMettere) {
        if (x == y) {
            for (int i = 0; i < schemaGioco.length; i++) {
                if (getValoreCella(i,i) != simboloDaMettere) {
                    break;
                }

                if (i == 2) {
                    vincitore = simboloDaMettere;
                }
            }
        }
    }



    private void checkForThreeInARow(int x, SIMBOLI_AMMESSI simboloDaMettere) {
        for (int i = 0; i < schemaGioco.length; i++) {
            if (getValoreCella(x, i) != simboloDaMettere) {
                break;
            }

            if (i == 2) {
                vincitore = simboloDaMettere;
            }
        }
    }

    private void checkForThreeInACol(int y, SIMBOLI_AMMESSI simboloDaMettere) {
        for (int i = 0; i < schemaGioco.length; i++) {
            if (getValoreCella(i, y) != simboloDaMettere) {
                break;
            }

            if (i == 2) {
                vincitore = simboloDaMettere;
            }
        }
    }

    private SIMBOLI_AMMESSI getValoreCella(int x, int y){
        return schemaGioco[x][y];
    }

    

}