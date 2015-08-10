package chrisnig.mastermind.game;

public class GameAlreadySolvedException extends Exception {
	
	private static final long serialVersionUID = 3750397023225083434L;
	
	public GameAlreadySolvedException() {
		super("This game has already been solved!");
	}

}
