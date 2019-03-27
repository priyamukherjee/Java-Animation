
/************************************************************
 *                                                          *                   
 *  Programmer: Priya Mukherjee                             *  
 *                                                          *
 *  Date Due:   03/09/2019                                  *                          
 *                                                          *
 *  Purpose:    Animation Program                           *
 *                                                          * 
 ***********************************************************/

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Animation {

	/************************************************************************
	 * main
	 * 
	 * Usage: This method use the Scanner object to get the user input. Remove
	 * whitespace and double quotes from the particles pattern. Check
	 * checkCorrectInput() to check if the input is valid or not. Call animate() to
	 * get the final output and print it to the console.
	 *************************************************************************/
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String init;
		int inputCount = 0;

		while (inputCount < 50) {
			System.out.println("Enter the particles pattern");
			init = scanner.nextLine();
			init = init.trim().replace("\"", "");

			System.out.println("Enter the speed");
			int speed = scanner.nextInt();
			scanner.nextLine();

			if (checkCorrectInput(speed, init)) {
				List<String> result = animate(speed, init);
				Iterator<String> itr = result.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}

				inputCount++;
			} else {
				System.out.println("Please enter the valid input");
			}
		}

		scanner.close();
	}

	/************************************************************************
	 * animate
	 * 
	 * Usage: This method generate the complete animated pattern for the given
	 * input.
	 *************************************************************************/
	private static List<String> animate(int speed, String init) {
		List<String> output = new ArrayList<>();
		char[] input = init.toCharArray();
		int inputLen = input.length;

		char[] charR = new char[inputLen];
		char[] charL = new char[inputLen];

		// generate the output pattern for the given input
		String strFirstOutput = getOutputString(input);
		output.add(strFirstOutput);
		if (strFirstOutput.contains("X")) {

			boolean isTerminate = true;

			// loop until isTerminate is false
			while (isTerminate) {
				// get the new positions of the particles based on rightward(R) and leftward(L)
				// movement
				charR = output.size() == 1 ? getArrayPosition(input, 'R', speed) : getArrayPosition(charR, 'R', speed);
				charL = output.size() == 1 ? getArrayPosition(input, 'L', speed) : getArrayPosition(charL, 'L', speed);

				// Iterate through the input length and generate output particle pattern in
				// character array format
				for (int i = 0; i < inputLen; i++) {
					if (charR[i] != Character.MIN_VALUE || charL[i] != Character.MIN_VALUE) {
						input[i] = 'X';
					} else {
						input[i] = Character.MIN_VALUE;
					}
				}

				// add the output pattern to the List
				output.add(getOutputString(input));

				if (!(new String(input).contains("X"))) {
					isTerminate = false;
				}
			}
		}
		return output;
	}

	/************************************************************************
	 * getOutputString
	 * 
	 * Usage: This method returns the output pattern in string format.
	 *************************************************************************/
	private static String getOutputString(char[] charOutput) {
		StringBuffer str = new StringBuffer();

		for (char ch : charOutput) {
			if ((ch == Character.MIN_VALUE) || (ch == '.')) {
				str.append(".");
			} else {
				str.append("X");
			}
		}
		return str.toString();
	}

	/************************************************************************
	 * getArrayPosition
	 * 
	 * Usage: This method generates array with new position of the particles for
	 * rightward(R) and leftward(L) movement based on the speed.
	 *************************************************************************/
	private static char[] getArrayPosition(char[] input, char ch, int speed) {
		char[] charOutput = new char[input.length];

		for (int i = 0; i < input.length; i++) {
			if (input[i] == ch) {
				if (ch == 'R') {
					if ((i + speed) < charOutput.length) {
						charOutput[i + speed] = ch;
					}
				} else {
					if ((i - speed) >= 0) {
						charOutput[i - speed] = ch;
					}
				}
			}
		}
		return charOutput;
	}

	/************************************************************************
	 * checkCorrectInput
	 * 
	 * Usage: This method checks if the input is valid. If the input contains any
	 * character other then 'L', 'R' and '.' then it returns false i.e., the input
	 * is invalid.
	 *************************************************************************/
	private static boolean checkCorrectInput(int speed, String input) {
		if (speed <= (input.length() / 20)) {
			return false;
		}

		char[] inputArr = input.toCharArray();

		for (int i = 0; i < inputArr.length; i++) {
			if ((inputArr[i] != 'L') && (inputArr[i] != 'R') && (inputArr[i] != '.')) {
				return false;
			}
		}
		return true;
	}

}