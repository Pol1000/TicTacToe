package boldrini.javakata.tictactoe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import boldrini.javakata.tictactoe.exception.GiocoFinitoException;
import boldrini.javakata.tictactoe.model.TicTacToe.SIMBOLI_AMMESSI;

public class TicTacToeTest {

    private TicTacToe schemaGioco;

    @Before
    public void setUp() {
        schemaGioco = new TicTacToe();
    }

    
    
    @Test(expected=GiocoFinitoException.class)
    public void pareggio() throws GiocoFinitoException
    {
        schemaGioco.setCerchio(0, 0);
        schemaGioco.setCroce(1, 0);
        schemaGioco.setCerchio(2, 0);
        schemaGioco.setCroce(0, 1);
        schemaGioco.setCerchio(1, 1);
        schemaGioco.setCroce(2, 1);
        schemaGioco.setCroce(0, 2);
        schemaGioco.setCroce(1, 2);
        schemaGioco.setCerchio(2, 2);
        

    }
    
    @Test
    public void setCerchio() throws GiocoFinitoException {
        schemaGioco.setCerchio(1, 1);

        assertEquals(true, schemaGioco.getSimboloAllaPosizione(1, 1) == SIMBOLI_AMMESSI.O);
    }

 
    @Test
    public void setCroce() throws GiocoFinitoException {
        schemaGioco.setCroce(1, 1);

        assertEquals(true, schemaGioco.getSimboloAllaPosizione(1, 1) == SIMBOLI_AMMESSI.X);
    }

    @Test
    public void mossaNonValida() throws GiocoFinitoException {
    	schemaGioco.setCroce(1, 1);
        boolean croceSettata = schemaGioco.setCroce(1, 1);

        assertEquals(false, croceSettata);
    }

    @Test
    public void vincoSullaColonna() throws GiocoFinitoException {
        schemaGioco.setCerchio(0, 0);
        schemaGioco.setCerchio(1, 0);
        schemaGioco.setCerchio(2, 0);

        assertEquals(true, schemaGioco.isVincitoreDiversoDaVuoto());
    }

    @Test
    public void vincoSullaRiga() throws GiocoFinitoException {
        schemaGioco.setCerchio(0, 0);
        schemaGioco.setCerchio(0, 1);
        schemaGioco.setCerchio(0, 2);

        assertEquals(true, schemaGioco.isVincitoreDiversoDaVuoto());
    }

    @Test
    public void vincoSullaDiagonaleSinistra() throws GiocoFinitoException {
        schemaGioco.setCerchio(0, 0);
        schemaGioco.setCerchio(1, 1);
        schemaGioco.setCerchio(2, 2);

        assertEquals(true, schemaGioco.isVincitoreDiversoDaVuoto());
    }

    @Test
    public void vincoSullaDiagonaleDestra() throws GiocoFinitoException {
        schemaGioco.setCerchio(0, 2);
        schemaGioco.setCerchio(1, 1);
        schemaGioco.setCerchio(2, 0);

        assertEquals(true, schemaGioco.isVincitoreDiversoDaVuoto());
    }

    @Test
    public void simboloVincenteCorretto() throws GiocoFinitoException {
        schemaGioco.setCerchio(0,0);
        schemaGioco.setCerchio(1,1);
        schemaGioco.setCerchio(2,2);

        assertEquals(TicTacToe.SIMBOLI_AMMESSI.O, schemaGioco.getVincitore());
    }
}