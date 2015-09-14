package boldrini.javakata.tictactoe.exception;

public class GiocoFinitoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2973044068750040696L;


	   public GiocoFinitoException()
	    {
	        super("Il gioco finisce in pareggio");
	    }

	    public GiocoFinitoException(String personalMEssage)
	    {
	        super(personalMEssage);
	    }
}
