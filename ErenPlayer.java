/**
 * @(#)ErenGameGUI.java
 * A smaller class compared to the other two that only has a string instance variable for the name of the player, two contructors, and a toString method. 
 * However, the game class takes a player and utilizes the toString method written for this player. Furthermore, it is still important to have this class incase if anything extra is added to the player in which case it is more efficient to have a class for a player object.   
 * Eren Cimentepe
 * Start Date: 06/01/2019
 * End Date: 21/01/2019
 */

public class ErenPlayer 
{
	//An instance variable for the name of the player. 
	String name;
	//A default constructor that doesn't take any parameters and sets everything to default values.
	ErenPlayer()
	{
		this.name = "TBD";
	}
	
	//An overloaded constructor that takes a String and sets is as the name of the player. 
	//However, the score of the player is still set to 0 because when they are starting off their score is zero. 
	ErenPlayer(String name)
	{
		this.name = name; 
	}
	
	//A toString method that returns a textual representation of the player object.
	//It will mostly be displayed after every game is concluded (something that leads the results being displayed). 
	public String toString()
	{
		return this.name + " you've concluded your game.";
	}
}
