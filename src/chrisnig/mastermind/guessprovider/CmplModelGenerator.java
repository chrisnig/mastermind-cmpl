package chrisnig.mastermind.guessprovider;

import chrisnig.mastermind.game.GuessResult;

public class CmplModelGenerator {
	static String whiteConstraint = "\t{\n\t\tp in P:\n\t\t\twhite[1, %1$d] + white[2, %2$d] + white[3, %3$d] + white[4, %4$d] = %5$d;\n\t}\n\n";
	static String blackConstraint = "\t{\n\t\tp in P:\n\t\t\tx[1, %1$d] + x[2, %2$d] + x[3, %3$d] + x[4, %4$d] = %5$d;\n\t}\n\n";
	
	public static String generateConstraints(Iterable<GuessResult> guessResults) {
		StringBuilder constraints = new StringBuilder();
		
		for(GuessResult result : guessResults) {
			constraints.append(CmplModelGenerator.generateConstraintBody(result));
		}
		
		return constraints.toString();
	}
	
	private static String generateConstraintBody(GuessResult guessResult) {
		StringBuilder result = new StringBuilder();
		int[] guess = guessResult.getGuess();
		
		result.append(String.format(CmplModelGenerator.whiteConstraint, guess[0], guess[1], guess[2], guess[3], guessResult.getWhitePins()));
		result.append(String.format(CmplModelGenerator.blackConstraint, guess[0], guess[1], guess[2], guess[3], guessResult.getBlackPins()));
		
		return result.toString();
	}
}
