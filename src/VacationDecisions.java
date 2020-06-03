import java.util.InputMismatchException;
import java.util.Scanner;

public class VacationDecisions {
    private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String vacationType = "";
		String destination = "";
		String result = "";
		String travelSuggestion = "";
		int groupSize = 0;


		do {
			System.out.println("What kind of trip would you like to go on, " + "musical, tropical, or adventurous?");
			vacationType = scanner.nextLine();
			destination = getDestination(vacationType);
			if (destination == "") {
				System.out.print("Please enter only musical, tropical, or adventurous \n\n");
			}
		} while (destination == "");

		do {
			System.out.println("How many are in your group?");
			try {
				groupSize = scanner.nextInt();
			} catch (InputMismatchException exception) {
				groupSize = 0;
				System.out.println("Please enter digits only");
			}
			if (groupSize < 0) {
				System.out.println("Please enter digits greater that 0. (zero)");
			}
			scanner.nextLine();
		} while (groupSize <= 0);

		if (groupSize <= 2) {
			travelSuggestion = "First Class Flight";
		} else if (groupSize <= 5) {
			travelSuggestion = "Helicopter";
		} else {
			travelSuggestion = "Charter Flight";
		}
		
		/*  
		 * build result correctly
		 */
		if (groupSize == 1) {
			result = "As a group of "+ groupSize+", you are going on a " + vacationType
					+ " vacation, and you should take a " + travelSuggestion;
		} else {
			result = "Since you're a group of " + groupSize + " going on a " + vacationType
				+ " vacation, you should take a " + travelSuggestion;
		}

		if (destination.equals("New Orleans")){
			result += (" to "+ destination + ".");
		} else if (destination.equals("Beach Vaction in Mexico")) {
			result += (" to a "+ destination + ".");
		} else {
			result += (" to a vacation "+ destination + ".");
		}
				
		System.out.println("\n" + result);

	}

	private static String getDestination(String vacType) {
		vacType = vacType.toLowerCase();
		if (vacType.equals("musical")) {
			return "New Orleans";
		} else if (vacType.equals("tropical")) {
			return "Beach Vaction in Mexico";
		} else if (vacType.equals("adventurous")) {
			return "Whitewater Rafting the Grand Canyon";
		}
		return "";
	}
}
