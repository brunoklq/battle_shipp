package griffith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


//Bruno Kennedy 

public class BattleShip {

	
	//Lock Values necessary for game.
	public static int rows = 10;
	public static int cols = 10;

	public static final int base = 0;
	public static final int ship = 1;
	public static final int hit = 2;
	public static final int empty = 3;
	public static boolean shipsleft = false;
	public static boolean computerships = false;
	public static boolean playerships = true;

	public static String name;
	public static int grid1[][] = new int[rows][cols];
	public static int grid2[][] = new int[rows][cols];

	public static void main(String[] args) throws InterruptedException, IOException {

		menuGame(); // Method unified to run the game.
	}

	public static void placeShipPlayer() throws InterruptedException, IOException {
		
		
		//Loop to reset the grid when display
		for (int i = 0; i < grid1.length; i++) {

			for (int j = 0; j < grid1.length; j++) {

				grid1[i][j] = base;
			}
		}

		
		//Inputs to creae and place the Ship of Player
		Scanner input = new Scanner(System.in);
		// Ship horizontal
		System.out.println("                      " + name
				+ " Please setup your SmallShip, put your ship vertical cordinates to 0-9 : ");
		while (input.hasNextInt() == false) { // while for validate the value select.

			System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

			input.next();
		}

		int limit_value_row = input.nextInt();
		int limit_value_row_push = limit_value_row + 3; /// ships size

		System.out.println("                  " + name
				+ " Please setup your SmallShip, put your ship cordinates vertical to A-J:");

		while (input.hasNextInt() == true) { // while for validate the value select.

			System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

			input.next();
		}

		try { //excepetions to avoid errors to display ships

			char limit_value_row_char = input.next().charAt(0);
			int select_row = (int) limit_value_row_char - 'A';

			for (int i = limit_value_row; i < limit_value_row_push; i++) {

				grid1[select_row][i] = ship;// loop to display grid1

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println(
					"Please put letter between A-J in Capital Letters, or rember the limit the range of the GRID");

			char limit_value_row_char = input.next().charAt(0);
			int select_row = (int) limit_value_row_char - 'A';

			for (int i = limit_value_row; i < limit_value_row_push; i++) {

				grid1[select_row][i] = ship;

			}

		} finally {

			System.out.println("Nice");

		}

		printGridPlayer(); 

		/// ships vertical
		System.out.println("                    " + name
				+ " Please setup your BigShip, put your ship horinzontal cordinates to 0-9: ");

		while (input.hasNextInt() == false) { // while for validate the value select.

			System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

			input.next();
		}

		int select_col = input.nextInt();
		System.out.println("                    " + name
				+ " Please setup your BigShip, put your ship horinzontal cordinates to A-J: ");

		while (input.hasNextInt() == true) { // while for validate the value select.

			System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

			input.next();
		}

		try {
			char limit_value_col_char = input.next().charAt(0);

			int limit_value_col = (int) limit_value_col_char - 'A';
			int limit_value_col_push = limit_value_col + 5; /// ships size

			for (int j = limit_value_col; j < limit_value_col_push; j++) {

				grid1[j][select_col] = ship;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println(
					"Please put letter between A-J in Capital Letters, or rember the limit the range of the GRID");

			char limit_value_col_char = input.next().charAt(0);

			int limit_value_col = (int) limit_value_col_char - 'A';
			int limit_value_col_push = limit_value_col + 5; /// ships size

			for (int j = limit_value_col; j < limit_value_col_push; j++) {

				grid1[j][select_col] = ship;

			}

		} finally {

			System.out.println("Nice");
		}

		
		Thread.sleep(1000);

	}

	public static void placeShipComputer() throws InterruptedException {
		
		
		
		//Loop to reset the grid 2
		for (int i = 0; i < grid2.length; i++) {

			for (int j = 0; j < grid2.length; j++) {

				grid2[i][j] = base;
			}
		}

		Thread.sleep(1000);
		int max = 7;
		int min = 0;
		int range = max - min;

		
		//input to display Ship of Computer
		System.out.println("\033[1;37m" + "Computer is Setting up your SmallShip, putting your ship cordinates 0-9: ");
		// Ship horizontal
		int select_row = (int) (Math.random() * range);
		System.out.println("Computer is Setting up your SmallShip, putting your ship cordinates vertical A-J:");
		Thread.sleep(1000);
		int limit_value_row = (int) (Math.random() * range);

		int limit_value_row_push = limit_value_row + 3; /// ships size
		System.out.println("Computer is Setting up your BigShip, putting your ship cordinates 0-9: ");
		/// ships vertical
		int select_col = (int) (Math.random() * range);
		System.out.println("Computer is Setting up your BigShip,putting your ship cordinates 0-9: ");
		int limit_value_col = (int) (Math.random() * range);
		int limit_value_col_push = limit_value_col + 2; /// ships size
		Thread.sleep(1000);
		System.out.println("All Right, Done, let's go!");

		for (int i = limit_value_row; i < limit_value_row_push; i++) {

			grid2[select_row][i] = ship;//grid to display

		}

		for (int j = limit_value_col; j < limit_value_col_push; j++) {

			grid2[j][select_col] = ship;

		}

		Thread.sleep(1000);

	}

	public static void printGridPlayer() {
		
		
		//loop to to display the structure of the grid for the player with some patterns 
		System.out.println("\033[0;32m" + "------------" + name + " Grid------------");

		System.out.print("\033[0;36m" + "   ");
		for (int col = 0; col < cols; col++) {
			System.out.print(col + 0 + " ");
		}
		System.out.println();

		for (int row = 0; row < rows; row++) {

			char rowLetter = (char) ('A' + row);
			System.out.print(rowLetter + " |");

			for (int col = 0; col < cols; col++) {//loop to to display the structure of the grid with some patterns 

				switch (grid1[row][col]) {
				case base:
					System.out.print("" + " |");
					break;
				case ship:
					System.out.print("\033[0;33m" + "S" + "\033[0;36m" + "|");
					break;
				case hit:
					System.out.print("\033[0;31m" + "X" + "\033[0;36m" + "|");
					break;
				case empty:
					System.out.print("*|");
				}
			}

			System.out.println("\n  " + "-".repeat(cols * 2 + 1));
		}

	}

	public static void printGridComputer() {
		
		
		
		//loop to to display the structure of the grid for the Computer with some patterns 
		System.out.println("\033[0;31m" + "------------Computer Grid------------");

		System.out.print("\033[0;36m" + "   ");
		for (int col = 0; col < cols; col++) {
			System.out.print(col + 0 + " ");
		}
		System.out.println();

		for (int row = 0; row < rows; row++) {

			char rowLetter = (char) ('A' + row);
			System.out.print(rowLetter + " |");

			for (int col = 0; col < cols; col++) {

				switch (grid2[row][col]) {
				case base:
					System.out.print(" |");
					break;
				case ship:
					System.out.print(" |");
					break;
				case hit:
					System.out.print("\033[0;31m" + "X" + "\033[0;36m" + "|");
					break;
				case empty:
					System.out.print("\033[1;37m" + "*" + "\033[0;36m" + "|");
				}
			}

			System.out.println("\n  " + "-".repeat(cols * 2 + 1));
		}

	}

	public static void playerHit() throws InterruptedException {

		
		// the structure of the playehit is to change
		// the values on grid for the symbols which represent the action
		System.out.println("\033[0;32m" + "-------------------" + name + " turn-------------------");

		System.out.println();

		Scanner input = new Scanner(System.in);
		
		

		try {

			System.out.println("\033[1;37m" + " Player Try to hit the enemy put the first Value A-J to hit the enemy");
			while (input.hasNextInt() == true) { // while for validate the value select.

				System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

				input.next();
			}
			char hit_char_value = input.next().charAt(0);// Converting the int number to char

			int hit_1 = (int) hit_char_value - 'A';

			System.out.println("Put the second Value 0-9");

			while (input.hasNextInt() == false) { // while for validate the value select.

				System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

				input.next();
			}

			int hit_2 = input.nextInt();

			// Conditionals to warning when the ship receive the Hit or not

			if (grid2[hit_1][hit_2] == 1) {

				System.out.println("YOU HIT THE SHIP");
				grid2[hit_1][hit_2] = hit;
			} else {
				Thread.sleep(1000);
				grid2[hit_1][hit_2] = empty;
				System.out.println("YOU DID NOT HIT  ");
			}
		}

		catch (Exception e) {
			System.out.println("Something wrong, Try to put a capital Letter or respect the grid limit ");

			System.out.println("\033[1;37m" + " Player Try to hit the enemy put the first Value A-J to hit the enemy");
			while (input.hasNextInt() == true) { // while for validate the value select.

				System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

				input.next();
			}
			char hit_char_value = input.next().charAt(0);// Converting the int number to char

			int hit_1 = (int) hit_char_value - 'A';

			System.out.println("Put the second Value 0-9");

			while (input.hasNextInt() == false) { // while for validate the value select.

				System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

				input.next();
			}

			int hit_2 = input.nextInt();

	

			if (grid2[hit_1][hit_2] == 1) {

				System.out.println("YOU HIT THE SHIP");
				grid2[hit_1][hit_2] = hit;
			} else {
				Thread.sleep(1000);
				grid2[hit_1][hit_2] = empty;
				System.out.println("YOU DID NOT HIT  ");
			}

		} finally {
			System.out.println("nice");

		}

		boolean playershipsleft = false; // variable with boolean values to identify when we don't have more ships


		for (int i = 0; i < grid2.length; i++) {

			for (int j = 0; j < grid2[i].length; j++) {

				if (grid2[i][j] == 1) {
					playershipsleft = true; 
				}
			}
		}
		// If no ships left, set b to a value other than 0 to exit the loop
		if (!playershipsleft) {

			shipsleft = true;
			System.out.println("\033[0;33m" + "YOUR ENEMY LOST, YOURS SHIPS SUNK");
			playerships = true;
		}

	}

	public static void computerHit() throws InterruptedException {

		
		// computer hit use the same structure of the player hit but without exceptions
		// i use the range to control that variation of numbers
		Thread.sleep(1000);
		System.out.println("-------------------Computer Turn-------------------");
		System.out.println();
		int max = 7;
		int min = 0;
		int range = max - min;

		Scanner input = new Scanner(System.in);
		Thread.sleep(1000);

		System.out.println("Now computer Try to hit the enemy ");
		System.out.println("Put the first Value");
		int hit_1 = (int) (Math.random() * range);
		Thread.sleep(1000);
		System.out.println(hit_1);
		System.out.println("Put the second Value");
		int hit_2 = (int) (Math.random() * range);
		Thread.sleep(1000);
		System.out.println(hit_2);

		if (grid1[hit_1][hit_2] == 1) {

			System.out.println("cOMPUTER HIT THE SHIP");
			Thread.sleep(2000);
			grid1[hit_1][hit_2] = hit;
		} else {
			Thread.sleep(1000);
			grid1[hit_1][hit_2] = empty;
			System.out.println("YOU DID NOT HIT  ");
		}

		boolean computershipsleft = false;

		for (int i = 0; i < grid1.length; i++) {

			for (int j = 0; j < grid1[i].length; j++) {

				if (grid1[i][j] == 1) {
					computershipsleft = true;
				}
			}

		}
		// If no ships left, set b to a value other than 0 to exit the loop
		if (!computershipsleft) {
			shipsleft = true;
			System.out.println("YOUR ENEMY LOST");
			computerships = true;
		}

	}

	public static void saveGame() throws IOException {
		
		

		try (PrintWriter writer = new PrintWriter("game_state.txt")) { // Write the txt with the name selected
			// grid to save the values from grid1
			
			for (int i = 0; i < grid1.length; i++) {
				for (int j = 0; j < grid1.length; j++) {

					writer.print(grid1[i][j]);

				}
				writer.println();
			}

		} catch (IOException e) { //exception in case of any kind of mistake

			System.out.println("ERROR");
		} finally { // warning about the process is done!

			System.out.println("Saved");
		}
	}

	public static void loadGame() throws IOException, InterruptedException {

		
		//exceptions to read the file saved with the previous method and avoid the break the code 
		// and warning when process finish.
		try {

			File myfile = new File("game_state.txt");
			Scanner scanner = new Scanner(myfile);

			char[][] grid = new char[rows][rows]; // Define ROWS and COLUMNS appropriately

			int row = 0;
			while (scanner.hasNextLine() && row < rows) {
				String line = scanner.nextLine();
				for (int col = 0; col < line.length() && col < cols; col++) {
					grid[row][col] = line.charAt(col);
				}
				row++;
			}

			int[][] intArray = convertCharToInt(grid);

			grid1 = intArray;
		} catch (Exception e) {

			System.out.println("Save file not found. Starting a new game.");
		} finally {

			Scanner input = new Scanner(System.in);

			System.out.println();
			System.out.println("Game Loaded ");

			boolean variable_control = true;

			Scanner input_2 = new Scanner(System.in);

			System.out.println("Welcome back, Please Write your Name Again!: ");
			System.out.println();

			while (variable_control) {

				while (input.hasNextInt() == true) { // while for validate the value select.

					System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

					input.next();
				}
				name = input.next();// repeat the code from menu game to keep from here

				printGridPlayer();
				System.out.println();
				placeShipComputer();
				System.out.println();
				printGridComputer();

				do {

					playerHit();
					System.out.println();
					printGridComputer();
					System.out.println();
					computerHit();
					System.out.println();
					printGridPlayer();

					System.out.println("");
					System.out.println("                        Press 1 to keep, 2 to get out, or 3 to Save the game.");
					while (input.hasNextInt() == false) { // while for validate the value select.
						System.out.println("Wrong value, please digit values consisten, letter is not acceptable");
						input.next();
					}
					int option_2 = input.nextInt();
					if (option_2 == 1) { // if for validate the value select

						continue;
					} else if (option_2 == 2) {
						System.out.println("                             Ok, You Want to get out, and save the game");
						break;
					} else if (option_2 == 3) {
						saveGame();
						System.out.println("                             Ok, You Want to get out, and save the game");
						break;
					}
				} while (!shipsleft);

				menuGame();

			}
			int variable = input_2.nextInt();
			if (variable == 2) {

				loadGame();

			}
			if (variable == 3) {

				System.out.println("rule set");
				System.out.println("rule set");
				System.out.println("rule set");
				System.out.println("rule set");
				System.out.println("rule set");
				System.out.println("rule set");
				System.out.println("rule set");
				System.out.println("rule set");
				saveGame();
			}

			if (variable > 4 || variable <= 0) {

				System.out.println("                            *Wrong Option Try Again*");
			}

			if (variable == 4) {

				variable_control = false;
				System.out.println("               Game over, thanks to play!");
			}

		}

	}

	public static int[][] convertCharToInt(char[][] charArray) {
		
		//process to conver the char in to int
		int numRows = charArray.length;
		int numCols = charArray[0].length;
		int[][] intArray = new int[numRows][numCols];

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				intArray[i][j] = Character.getNumericValue(charArray[i][j]);
			}
		}

		return intArray;
	}

	public static void menuGame() throws InterruptedException, IOException {
		
		
		//the main structure of the code, here there is some loops to block the code and run until the game finish

		System.out.println("\033[0;36m" + " "
				+ "            _____                                                                          _____ \r\n"
				+ "            ( ___ )                                                                        ( ___ )\r\n"
				+ "             |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   | \r\n"
				+ "             |   |  ____            _     _     _             _____   _       _             |   | \r\n"
				+ "             |   | |  _ \\          | |   | |   | |           / ____| | |     (_)            |   | \r\n"
				+ "             |   | | |_) |   __ _  | |_  | |_  | |   ___    | (___   | |__    _   _ __      |   | \r\n"
				+ "             |   | |  _ <   / _` | | __| | __| | |  / _ \\    \\___ \\  | '_ \\  | | | '_ \\     |   | \r\n"
				+ "             |   | | |_) | | (_| | | |_  | |_  | | |  __/    ____) | | | | | | | | |_) |    |   | \r\n"
				+ "             |   | |____/   \\__,_|  \\__|  \\__| |_|  \\___|   |_____/  |_| |_| |_| | .__/     |   | \r\n"
				+ "             |   |                                                               | |        |   | \r\n"
				+ "             |   |                                                               |_|        |   | \r\n"
				+ "             |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___| \r\n"
				+ "            (_____)                                                                        (_____)");

		System.out.println("\033[1;32m" + "                                                     |__\r\n"
				+ "                                                     |\\/\r\n"
				+ "                                                     ---\r\n"
				+ "                                                     / | [\r\n"
				+ "                                              !      | |||\r\n"
				+ "                                            _/|     _/|-++'\r\n"
				+ "                                        +  +--|    |--|--|_ |-\r\n"
				+ "                                     { /|__|  |/\\__|  |--- |||__/\r\n"
				+ "                                    +---------------___[}-_===_.'____                 /\\\r\n"
				+ "                                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\r\n"
				+ "                 __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\r\n"
				+ "                |                                                                     BB-61/\r\n"
				+ "                 \\_________________________________________________________________________|\r\n");

		System.out.println();

		boolean variable_control = true;
		Scanner input_2 = new Scanner(System.in);

		while (variable_control) {
			System.out.println(
					"\033[1;37m" + "                              _____________________________________________");
			System.out.println("                             |                                             |");
			System.out.println("                             |        To Start select Options Below:       |");
			System.out.println("                             |             1-New Game                      |");
			System.out.println("                             |             2-Load game                     |");
			System.out.println("                             |             3-Ruleset                       |");
			System.out.println("                             |             4-Exit the Game                 |");
			System.out.println("                             |_____________________________________________|");

			while (input_2.hasNextInt() == false) { // while for validate the value select.

				System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

				input_2.next();
			}

			int variable = input_2.nextInt();

			if (variable == 1) {

				System.out.println();
				System.out.println("\033[1;37m"
						+ "                   Welcome to the BattleShip Game!, Please put your name Before to Start: ");

				Scanner input = new Scanner(System.in);

				while (input.hasNextInt() == true) { // while for validate the value select.

					System.out.println("Wrong value, please digit values consisten, letter is not acceptable");

					input.next();
				}
				name = input.next();

				System.out.println();
				System.out.println();

				printGridPlayer();
				placeShipPlayer();
				System.out.println();
				printGridPlayer();
				System.out.println();
				placeShipComputer();
				System.out.println();
				printGridComputer();

				do {// loop until the game has a result

					playerHit();
					System.out.println();
					printGridComputer();
					System.out.println();
					computerHit();
					System.out.println();
					printGridPlayer();

					System.out.println("");
					System.out.println("                        Press 1 to keep, 2 to get out, or 3 to Save the game.");
					while (input.hasNextInt() == false) { // while for validate the value select.
						System.out.println("Wrong value, please digit values consisten, letter is not acceptable");
						input.next();
					}
					int option_2 = input.nextInt();
					if (option_2 == 1) { // if for validate the value select

						continue;
					} else if (option_2 == 2) {
						System.out.println("                             Ok, You Want to get out!");
						for (int i = 0; i < grid1.length; i++) {

							for (int j = 0; j < grid1.length; j++) {

								grid1[i][j] = base;
							}
						}

						for (int i = 0; i < grid1.length; i++) {

							for (int j = 0; j < grid1.length; j++) {

								grid1[i][j] = base;
							}
						}
						break;
					} else if (option_2 == 3) {
						saveGame();
						System.out.println("                             Ok, You Want to get out, and save the game");
						break;
					}
				} while (!shipsleft);


			}

			if (variable == 2) {

				loadGame();

			}
			if (variable == 3) {

				System.out.println("                                 Welcome to the Battle ship game, here there");
				System.out.println("                                 are some informations about the game");
				System.out.println("                                 First, your mission is to sink the ship from your enemy,");
				System.out.println("                                 for this you should to select on a field 10x10");
				System.out.println("                                 in a range A-J to 0-9. Every player will be ");
				System.out.println("                                 with two ships with different sizes and angles.");
				System.out.println();
				System.out.println("                                 When you start the game you must select ");
				System.out.println("                                 the position of your (Horizontal Ships) the size with 3 Squares,");
				System.out.println("                                 After that you must to select your second ");
				System.out.println("                                 ships with the size with 5 squares, in a range A-J to 0-9");
				System.out.println();
				System.out.println("                                 When the Battle Start you have to select the FIELD,");
				System.out.println("                                 trying to guess where your enemy is hidden");
				System.out.println("                                 if you hit your enemy, will show up (X),");
				System.out.println("                                 if not will appear (*), win who hit all ships from your enemy.");
				
				
			}

			if (variable > 4 || variable <= 0) {

				System.out.println("                            *Wrong Option Try Again*");
			}

			if (variable == 4) {

				variable_control = false;
				System.out.println("               Game over, thanks to play!");
			}

		}

		

	}

	public static void gameOver() throws InterruptedException, IOException {
		
		//method to finish the game and create some warning about the situation of the user.

		if (!computerships) {

			System.out.println("Congrats: " + name + " You Won the Computer");
		}
		if (!playerships) {

			System.out.println("Computer Won, Try again: " + name);
		}
		System.out.println("GAME OVER");
		menuGame();
	}

}
