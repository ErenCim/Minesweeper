/**
 * @(#)ErenGameGUI.java
 * Class for the GUI.
 * It holds the GUI that the user will interact with and is also the test class. 
 * Eren Cimentepe
 * Start Date: 06/01/2019
 * End Date: 21/01/2019
 */

	import javax.swing.*;

public class ErenGame 
{
	//A variable for the total number of buttons in the board (i.e if it is 7 by 10, then the total number is 70).
	int intTotalBoxes; 
	//An int for the total number of mines there will on the baord. 
	int intMines; 
	//When the randomizer creates a number, it doesn't apply to a two dimensional array, hence a byte for the row and column (location) of the n'th button is declared (n being the random number that is produced).
	//For exmaple if the random number is 35, the two bytes hold the row and column coordinations of the 35th button in the 2-D array.
	byte bytArrayRow;
	byte bytArrayColumn;
	//A player object is also declared, the toString written for the player object will be utilized in this class.
	ErenPlayer p; 
	//A byte is declared for the number of times a button that doesn't have a mine is clicked, so that it can be used in the logic of the win condition. 
	int intOCount; 
	
	//A default constructor that sets everything to their default values and the zeroes are casted to a byte if the variables are bytes/ 
	public ErenGame()
	{
		this.intTotalBoxes = 0; 
		this.intMines = 0; 
		this.bytArrayRow = (byte)0; 
		this.bytArrayColumn = (byte)0; 
		this.p = new ErenPlayer(); 
		this.intOCount = (byte)0; 
	}
	
	//An overloaded constructor that takes a string to call the overloaded constructor of the player class that takes a string and sets the name of the player as that string. 
	//The rest of the instance variables are set for the same values as the default constructor because they will be changed as the game progresses/ 
	public ErenGame(String name)
	{
		this.intTotalBoxes = 0; 
		this.intMines = 0; 
		this.bytArrayRow = (byte)0; 
		this.bytArrayColumn = (byte)0; 
		this.p = new ErenPlayer(name);
		this.intOCount = (byte)0; 
	}
	
	//A method is created for the randomizer that takes an int for total number of buttons there are in the board that was picked by the user. 
	//So that the randomizer can select a random button in that array to determine which ones will have mines. 
	public int randomNumber(int total) 
	{
		return (int)(Math.random() * total);
	}
	
	public void determineWinner(JButton btnClick, byte length, byte width )
	{
		//If the text of the button that was clicked is X, it indicates that there should be a bomb on that button.  
		if (btnClick.getActionCommand().equalsIgnoreCase("X"))
		{
			//So, it outputs a message telling the user that they lost and then closes the program. 
			JOptionPane.showMessageDialog(null, this.p.toString() + " Unfortunately, you clicked on a bomb. So you lost, please try again.");
			System.exit(0);
		}
		else
		{
			this.intOCount++; 
			System.out.println(this.intMines);
			//This part of the winning logic assumes that the user doesn't click a button more than once. 
			//If the total number of buttons in the array which is length times width minus the number of times the user clicked a button and didn't lose is equal to the number of mines on the board.
			//Then it means the user won and revealed all the buttons because the total minus the number of clicks on tiles without revealing bombs should be equal to mine number/ 
			if ((length * width) - this.intOCount == this.intMines)
			{
				//A message is shown telling the user that they won/ 
				JOptionPane.showMessageDialog(null, "Congradulations " + this.p.name + " you didn't click any of the mines. You won!");
				System.exit(0);
			}			
		}	
	}
}
