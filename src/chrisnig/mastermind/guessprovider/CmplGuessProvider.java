package chrisnig.mastermind.guessprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class CmplGuessProvider extends GuessProvider {
	static String cmplFile = "etc/mastermind.cmpl";
	static String constraintFile = "etc/constraints.cmpl";
	static String solutionFile = "etc/solution.sol";
	
	@Override
	public int[] getGuess() throws GuessNotAvailableException {
		if (this.guesses.isEmpty()) {
			return new RandomGuessProvider().getGuess();
		}
		
		try {
			PrintWriter writer = new PrintWriter(CmplGuessProvider.constraintFile, "UTF-8");
			writer.print(CmplModelGenerator.generateConstraints(this.guesses));
			writer.close();
			
			File solutionFile = new File(CmplGuessProvider.solutionFile);
			solutionFile.delete();
			
			Process process = (new ProcessBuilder("cmpl", CmplGuessProvider.cmplFile, "-solutionAscii", CmplGuessProvider.solutionFile)).start();
			process.waitFor();
			
			if (!solutionFile.exists()) {
				throw new Exception("No solution file found after invoking CMPL.");
			}
			
			return this.getSolution(solutionFile);
		} catch (Exception e) {
			GuessNotAvailableException exc = new GuessNotAvailableException(e);
			throw exc;
		}
	}
	
	private int[] getSolution(File solutionFile) {
		try {
			int[] solution = new int[4];
			BufferedReader br = new BufferedReader(new FileReader(solutionFile));
			String line;
			int separatorCount = 0;
			int solutionCount = 0;
			while ((line = br.readLine()) != null && solutionCount < 4) {
				if (line.equals("---------------------------------------------------------------------------------------------------------")) {
					separatorCount++;
					continue;
				}
				
				if (separatorCount < 3) {
					continue;
				}
				
				String resultWithBracket = line.split(" ")[0].split(",")[1];
				String result = resultWithBracket.substring(0, resultWithBracket.length()-1);
				solution[solutionCount] = Integer.parseInt(result);
				solutionCount++;
			}
			
			br.close();
			return solution;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}

}
