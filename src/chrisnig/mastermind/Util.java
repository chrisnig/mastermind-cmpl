package chrisnig.mastermind;

public class Util {
	public static int randomWithRange(int min, int max)
	{
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
}
