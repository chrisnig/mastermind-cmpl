package chrisnig.mastermind.game;

import java.util.ArrayList;
import chrisnig.mastermind.Util;

public class Board {
	public static int numberOfColors = 4;
	public static int[] availableColors = {1, 2, 3, 4, 5, 6};
	
	private int[] colors = new int[numberOfColors];

	public Board() {
		for (int i = 0; i < numberOfColors; ++i) {
			this.colors[i] = availableColors[Util.randomWithRange(0, availableColors.length-1)];
		}
	}
	
	public String[] guess(int[] guess) throws InvalidGuessException {
		if (guess.length != numberOfColors) {
			throw new InvalidGuessException("You need to guess " + numberOfColors + " colors!");
		}
		
		int whitePins = 0, blackPins = 0;
		
		for (int i = 0; i < numberOfColors; ++i) {
			if (guess[i] == this.colors[i]) {
				blackPins += 1;
			} else {
				for (int j = 0; j < numberOfColors; ++j) {
					if (guess[i] == this.colors[j]) {
						whitePins += 1;
						break;
					}
				}
			}
		}
		
		ArrayList<String> pins = new ArrayList<String>(numberOfColors);
		
		for (int i = 0; i < blackPins; ++i) {
			pins.add("B");
		}
		for (int i = 0; i < whitePins; ++i) {
			pins.add("W");
		}
		
		return pins.toArray(new String[pins.size()]);
	}
}
