/**
 * @(#)ErenGameGUI.java
 * Class for the GUI.
 * It holds the GUI that the user will interact with and is also the test class. 
 * Eren Cimentepe
 * Start Date: 06/01/2019
 * End Date: 21/01/2019
 */

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErenGameGUI implements ActionListener
{
	//NOTE: The word Bomb and Mine are interchangable and mean the same thing in the code as well as the comments.
	//Also please change the size of the GUI/move it arond to see the label when the game opens. 
	
	//Variables for the start up page.
	//A byte for the length of the minesweeper (GUI).
	byte bytLength;
	//A byte for the width of the minesweeper (GUI).
	byte bytWidth;
	//A button for one of the possible sizes of the board. 
	JButton fifteenbynine;
	//A button for one of the possible sizes of the board. 
	JButton tenbyseven;
	//A button for one of the possible sizes of the board. 
	JButton twentybyeleven;
	//Frame for the Start Page where the user will pick the size of the GUI they want to play in. 
	JFrame pickSize; 
	//A label to welcome the user and tell them to pick the size to play the game.
	JLabel welcome;
	//A label for some of the instructions.
	JLabel instructions;
	
	//Variables for the mineseeper GUI. 
	//A two-dimensional array to hold all the buttons for the minesweeper.
	static JButton[][] board; 
	//A frame for the minesweeper board. 
	JFrame mines; 
	//A byte for where the buttons are going to start in the length.
	int intLLocation;
	//A byte for when the buttons are going to start in the width.
	int intWLocation;
	//A game object as an instance variable, which has the randomizer and the winning methods. 
	ErenGame game;
	//A byte to keep track of the number of mines around a mine 
	byte bytBombNum; 
	//An integer is declared to keep track of the random number that is produced by the randomizer method to determine bombs that are random. 
	int rndNum = 0;
	 
	public ErenGameGUI() 
	{
		//A default constructor that sets everything to a default value and calls the default constructor for the game object. 
		this.createStartPage();
		this.intLLocation = 70;
		this.intWLocation = 150;
		this.bytLength = (byte)0;
		this.bytWidth = (byte)0;
		this.bytBombNum = (byte)0; 
		this.game = new ErenGame();
	}
	
	public ErenGameGUI(String name) 
	{
		//An overloaded constructor. All the instance variables are set to the same value as the default constructor except this constructor takes a string to set the name of the person object, which which is passed to the constructor of the game object. 
		this.createStartPage();
		this.intLLocation = 70;
		this.intWLocation = 150;
		this.bytLength = (byte)0;
		this.bytWidth = (byte)0;
		this.bytBombNum = (byte)0; 
		this.game = new ErenGame(name);
	}
	
	//A method is created to set the board if the button 15by9 is clicked. 
	public void setBoard()
	{
		//The length and the width are set to 15 and 9.
		 bytLength = (byte)15;
		 bytWidth = (byte) 9;
		//The GUI to pick the size of the board is disposed (closed).
		 this.pickSize.dispose();
		//The visibility of the board that has the minesweeper game is set to true to reveal the GUI where the game is going to be played. 
		 this.mines.setVisible(true);
		//Then the buttons and the 2-D that holds them are being initialized by calling the appropriate method and passing the length and the width as parameters. 
		 this.setButtons(bytLength, bytWidth);
		//The size of the frame is set to 1100 by 800, which is appropriate for the size of the board that is 15 by 9.
		 this.mines.setSize(1100, 800);
	}
	
	//A different method is created if the button 10 by 7 is clicked because the size of the board is going to be different. 
	public void setBoardSecond()
	{
		 //The length and the width are set to 10 and 7.
		 bytLength = (byte)10;
		 bytWidth = (byte)7;
		 //The GUI to pick the size of the board is disposed (closed).
		 this.pickSize.dispose();
		 //The visibility of the board that has the minesweeper game is set to true to reveal the GUI where the game is going to be played. 
		 this.mines.setVisible(true);
		 //Then the buttons and the 2-D that holds them are being initialized by calling the appropriate method and passing the length and the width as parameters. 
		 this.setButtons(bytLength, bytWidth);
		 //The size of the frame is set to 900 by 800, which is appropriate for the size of the board that is 20 by 11. 
		 this.mines.setSize(900, 800);
	}
	
	//Lastly, a method that sets the board if the 20 by 11 button is clicked. 
	public void setBoardThird()
	{
		 //The length and the width are set to 20 and 11.
		 bytLength = (byte)20;
		 bytWidth = (byte)11;
		 //The GUI to pick the size of the board is disposed (closed).
		 this.pickSize.dispose();
		 //The visibility of the board that has the minesweeper game is set to true to reveal the GUI where the game is going to be played. 
		 this.mines.setVisible(true);
		 //Then the buttons and the 2-D that holds them are being initialized by calling the appropriate method and passing the length and the width as parameters. 
		 this.setButtons(bytLength, bytWidth);
		 //The size of the frame is set to 1200 by 800, which is appropriate for the size of the board that is 20 by 11. 
		 this.mines.setSize(1200, 800);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		//If the button that is clicked is the fifteenbynine button the following code runs that calls the appropriate method. 
		if(e.getSource() == this.fifteenbynine)
		 {
			this.setBoard();
		 }
	 	 //If the button that is clicked is the tenbyseven button the following code runs that calls the appropriate method. 
		 else if (e.getSource() == this.tenbyseven)
		 {
			 this.setBoardSecond();
		 }
		 //If the button that is clicked is the twentybyeleven button the following code runs that calls the appropriate method. 
		 else if (e.getSource() == this.twentybyeleven)
		 {
			 this.setBoardThird();
		 }
		 else 
		 {
			 //This code runs if the text of the button that is clicked is X, which is only set on buttons that have a mine. 
			 if (e.getActionCommand().equalsIgnoreCase("X"))
			 {
				 //It calls the method that goes through the array and when it finds the button that was clicked, it sets it background image to a mine. 
				 this.goThroughArray((JButton)e.getSource());
				 //Then it calls the winner method written in the game class with the button that was clicked, the length and width variables as parameters. 
				 //This is because by clicking the button with a mine it means the user has lost, so the winner method will display the appropriate message.
				 this.game.determineWinner((JButton)e.getSource(), this.bytLength, this.bytWidth);
			 }
			 else
			 {
				 //If the text doesn't equal to X the following code runs because it means that the button didn't have a mine. 
				 this.revealAround((JButton)e.getSource());
				 this.bombCount();
				 this.game.determineWinner((JButton)e.getSource(), this.bytLength, this.bytWidth);
			 }
			  
		 }
	} 
	
	//A method is written so that when a button that doesn't have a mine is clicked, it searches aroud to find how many mines there are and sets the text of the button to that number. 
	public void revealAround(JButton clickedBtn)
	{
		//YOU CAN PROBABLY CHANGE THIS TO MAKE IT MORE EFFICIENT.
		for (int i = 0; i < board.length; i ++)
		{
			//System.out.println(board.length);
			for (int y = 0; y < board[i].length; y ++)
			{
				//System.out.println(board[i].length);
				if (board[i][y] == clickedBtn) 
				{
					if (i!=0 && i!=board.length-1 && y!=0 && y!=board[i].length -1)
					{
						//Calls appropriate search code that is written below this method. 
						this.insideBoard(i, y);
					}
					else if (y == 0)
					{

						//Calls appropriate search code that is written below this method. 
						this.firstColumn(i, y);
					}
					else if (y==board[i].length -1)
					{

						//Calls appropriate search code that is written below this method. 
						this.lastColumn(i, y);
					}
					else if (i==0)
					{

						//Calls appropriate search code that is written below this method. 
						this.firstRow(i, y);
					}
					else if (i==board.length-1)
					{

						//Calls appropriate search code that is written below this method. 
						this.lastRow(i, y);
					}
				}
			}
		}
	}
	
	//The search method for the inside of the board all of these take two ints for the coordinates of the button that was clicked so the buttons around it can be checked. 
	//The reason that there are different search methods is because the code changes depending on the location of the button so that it doesn't go out of the bonds of the array. 
	public void insideBoard (int i, int y)
	{
		//If it is inside searches all eight buttons around it by calling the method check one, then calls the method to set the text of the button.
		this.checkOne(board[i][y-1]);
		this.checkOne(board[i][y+1]);
		this.checkOne(board[i+1][y-1]);
		this.checkOne(board[i+1][y+1]);
		this.checkOne(board[i+1][y]);
		this.checkOne(board[i-1][y+1]);
		this.checkOne(board[i-1][y-1]);
		this.checkOne(board[i-1][y]);
		this.setNumBomb((byte)i, (byte)y);
	}
	
	//Search method for the first column of the board, same parameters and same logic as the previous search method. 
	public void firstColumn (int i, int y)
	{
		if (i == 0)
		{
			this.checkOne(board[i][y+1]);
			this.checkOne(board[i+1][y]);
			this.checkOne(board[i+1][y+1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else if (i == board.length -1)
		{
			this.checkOne(board[i][y+1]);
			this.checkOne(board[i-1][y]);
			this.checkOne(board[i-1][y+1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else 
		{
			this.checkOne(board[i][y+1]);
			this.checkOne(board[i+1][y+1]);
			this.checkOne(board[i+1][y]);
			this.checkOne(board[i-1][y+1]);
			this.checkOne(board[i-1][y]);
			this.setNumBomb((byte)i, (byte)y);
		}
	}
	
	//Search method for the last column of the board, same parameters and same logic as the previous search method. 
	public void lastColumn (int i, int y)
	{
		if (i == 0)
		{
			this.checkOne(board[i][y-1]);
			this.checkOne(board[i+1][y]);
			this.checkOne(board[i+1][y-1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else if (i == board.length -1)
		{
			this.checkOne(board[i][y-1]);
			this.checkOne(board[i-1][y]);
			this.checkOne(board[i-1][y-1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else
		{
			this.checkOne(board[i][y-1]);
			this.checkOne(board[i+1][y-1]);
			this.checkOne(board[i+1][y]);
			this.checkOne(board[i-1][y-1]);
			this.checkOne(board[i-1][y]);
			this.setNumBomb((byte)i, (byte)y);	
		}
	}
	
	//Search method for the first row of the board, same parameters and same logic as the previous search method. 
	public void firstRow(int i, int y)
	{
		if (y == 0)
		{
			this.checkOne(board[i][y+1]);
			this.checkOne(board[i-1][y]);
			this.checkOne(board[i-1][y+1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else if (y == board[i].length -1)
		{
			this.checkOne(board[i][y-1]);
			this.checkOne(board[i-1][y]);
			this.checkOne(board[i-1][y-1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else
		{
			this.checkOne(board[i][y-1]);
			this.checkOne(board[i][y+1]);
			this.checkOne(board[i+1][y-1]);
			this.checkOne(board[i+1][y+1]);
			this.checkOne(board[i+1][y]); 
			this.setNumBomb((byte)i, (byte)y);	
		}
	}
	
	//Search method for the first row of the board, same parameters and same logic as the previous search method. 
	public void lastRow (int i, int y)
	{
		if (y == 0)
		{
			this.checkOne(board[i][y+1]);
			this.checkOne(board[i-1][y]);
			this.checkOne(board[i-1][y+1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else if (y == board[i].length -1)
		{
			this.checkOne(board[i][y-1]);
			this.checkOne(board[i-1][y]);
			this.checkOne(board[i-1][y-1]);
			this.setNumBomb((byte)i, (byte)y);
		}
		else 
		{
			this.checkOne(board[i][y-1]);
			this.checkOne(board[i][y+1]);
			this.checkOne(board[i-1][y+1]);
			this.checkOne(board[i-1][y-1]);
			this.checkOne(board[i-1][y]); 
			this.setNumBomb((byte)i, (byte)y);
		}
	}
	
	public void setNumBomb(byte row, byte column)
	{
		//This is a method that sets the number of bombs around a button as its text. 
		//Gets the location of the button and then sets its text equal to the variable used to keep track of the number of mines. 
		board[row][column].setText("" + this.bytBombNum);
		//Then it sets the foreground colour to white to distinguish the text form the background grey colour.
		board[row][column].setForeground(Color.white);
		//lastly sets the font size of 16 and sets the variable back to 0 for the next button that is going to be clicked. 
		board[row][column].setFont(board[row][column].getFont().deriveFont(16.0f));
		this.bytBombNum = (byte)0;
		
	}
	
	//This method checks if the text of the button that is passed to this method is X and adds to the counter if it is. To keep track of how many mines there are around a button. 
	public void checkOne(JButton one)
	{
		if (one.getText().equalsIgnoreCase("X"))
			this.bytBombNum++;
	}
	
	//A method to go through the array and set the background image to a mine (it is called from action listener if the button that was clicked has a text of X)
	public void goThroughArray(JButton clickedBtn)
	{
		//Nested loop going through the 2-D array and then if the button that is clicked is equal to the button that is passed to this method, it sets the background image to a mine. 
		for (int i = 0; i < board.length; i ++)
		{	
			for (int y = 0; y < board[i].length; y ++)
			{
				if (board[i][y] == clickedBtn)
					board[i][y].setIcon(new ImageIcon("New Project (2).png"));
				
			}
		}
	}	
	
	public void createStartPage()
	{
		//Creates the frame for the start up page and sets is visibility and then it sets the type null as well as the size of the frame. 
		this.pickSize = new JFrame("Welcome to Minesweeper");
		this.pickSize.setVisible(true);
		this.pickSize.setSize(900, 550);
		this.pickSize.setLayout(null);
		this.pickSize.getContentPane().setBackground(Color.DARK_GRAY);
		//Make sure the program closes if the users exist the program. 
		this.pickSize.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates the 15 by 15 button. 
		this.twentybyeleven = new JButton("20 by 11");
		//Adds it to the frame.
		this.pickSize.add(this.twentybyeleven);
		//Sets its size and location. 
		this.twentybyeleven.setSize(150, 65);
    	this.twentybyeleven.setLocation(610, 340);
    	//Adds action listener to it, so that the action listener method is called when this button is clicked. 
    	this.twentybyeleven.addActionListener(this);
    	//Sets the background colour to white. 
    	this.twentybyeleven.setBackground(Color.white);
    	//Sets the opaque property of it to true so the background colour shows. 
    	this.twentybyeleven.setOpaque(true);
    	//Then sets an etched border with a red colour and a white shadow. 
    	this.twentybyeleven.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.white));
    	
    	//Creates the 5 by 5 button. 
    	this.fifteenbynine = new JButton ("15 by 9");
    	//Adds it to the frame.
    	this.pickSize.add(this.fifteenbynine);
    	//Sets its size and location. 
    	this.fifteenbynine.setSize(150, 65);
    	this.fifteenbynine.setLocation(380, 340);
    	//Adds action listener to it, so that the action listener method is called when this button is clicked. 
    	this.fifteenbynine.addActionListener(this);
    	//Sets the background colour to white. 
    	this.fifteenbynine.setBackground(Color.white);
    	//Sets the opaque property of it to true so the background colour shows.
    	this.fifteenbynine.setOpaque(true);
    	//Then sets an etched border with a red colour and a white shadow.
    	this.fifteenbynine.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.white));
    	
    	//Creates the 10 by 7 button. 
    	this.tenbyseven = new JButton ("10 by 7");
    	//Adds it to the frame.
    	this.pickSize.add(this.tenbyseven);
    	//Sets its size and location. 
    	this.tenbyseven.setSize(150, 65);
    	this.tenbyseven.setLocation(150, 340);
    	//Adds action listener to it, so that the action listener method is called when this button is clicked. 
    	this.tenbyseven.addActionListener(this);
    	//Sets the background colour to white. 
    	this.tenbyseven.setBackground(Color.white);
    	//Sets the opaque property of it to true so the background colour shows.
    	this.tenbyseven.setOpaque(true);
    	//Then sets an etched border with a red colour and a white shadow.
    	this.tenbyseven.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.white));
		
    	//Creates the label for the welcome word.
    	this.welcome = new JLabel("Welcome!", SwingConstants.CENTER);
    	//Sets its size and its location. 
    	this.welcome.setSize(450, 100);
    	this.welcome.setLocation(225, 75);
    	//Sets the colour of the text to white. 
    	this.welcome.setForeground(Color.white);
    	//Adds it to the frame. 
    	this.pickSize.add(this.welcome);
    	//Then sets the size of the font to 64.0
    	this.welcome.setFont(this.welcome.getFont().deriveFont(64.0f));
    	
    	//Creates the label for instructions and centers the text using "<div style='text-align: center;'>" and the swing constant. 
    	this.instructions = new JLabel ("<html><div style='text-align: center;'> This game is a luck based minesweeper where you get to pick the size of the board that you can play. Then you will see tiles which reveal as you click on them. Some of the buttons have mines on them, which you are trying to avoid. So, if you click on a tiles that has a mine, you will lose the game. However, if you click on a tiles that doesn’t have a mine, it reveals how many bombs there are around that tile. Your aim is to reveal al tiles that don’t have a mine on them. Please pick the size that you want the board to be and make sure that you don't click any of the buttons more than once. <br/><div style='text-align: center;'>The difficulty increases going from left to right <html>", SwingConstants.CENTER);
    	//Sets the size and location of the label.
    	this.instructions.setSize(650, 200);
    	this.instructions.setLocation(125, 140);
    	//Sets the colour of the text to white. 
    	this.instructions.setForeground(Color.white);
    	//Sets changes the size of the font to 16.
    	this.instructions.setFont(this.instructions.getFont().deriveFont(14.0f));
    	//Adds it to the frame.  
    	this.pickSize.add(this.instructions);	
	
    	//The GUi for the actual minesweeper board is created, the size is set.
    	this.mines = new JFrame("MineSweeper");
		this.mines.setSize(1200, 800);
		//The layout is set to null and the background colour is set to dark gray.
		this.mines.setLayout(null);
		this.mines.getContentPane().setBackground(Color.DARK_GRAY);
		//This is added so that it closes when exit is pressed.
		this.mines.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	//Method to set the buttons and the array (initialize)
	public void setButtons(byte x, byte z)
	{
		//Takes the measurements of the array. 
		board = new JButton[z][x];
		
		//nested loop that goes through the array.
		for (int i = 0; i < board.length; i++)
		{
			//Every time for the loop sets the variable for the x location of the button to 100 because it starts there.
			this.intLLocation = 100;
			
			for (int y = 0; y < board[i].length; y++)
			{
				//y is the rows and i is the column
				//Creates the button, sets the size and location with the correct variables
				//Sets the background and text to O but the background colour is the same as the button so that the suer doesn't recognize it.
				board[i][y] = new JButton();
				board[i][y].setSize(50, 50);
				board[i][y].setLocation(this.intLLocation, this.intWLocation);
				board[i][y].setOpaque(true);
				board[i][y].setBackground(Color.gray);
				board[i][y].setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
				board[i][y].addActionListener(this);
				board[i][y].setText("O");
				board[i][y].setForeground(Color.gray);
				//Adds it to the frame.
				mines.add(board[i][y]);
				//Adds 50 to the location of the length because one button is 50 tall.
				this.intLLocation += 50;
			}
			//Adds 50 to the width variable as well because the button is 50 wide,.
			this.intWLocation += 50;	
			
		}
		
		//If statement depending on which board was clicked. 
		if (x * z == 220)
			//The method to set the bomb is called and passed the needed info, the first parameter is a constant ratio to calcualte how many bombs there are. 
			setBomb((int)((x * z * 6) / 24), (x * z), x);	
		else if (x * z == 70)
			setBomb((int)((x * z * 6) / 24), (x * z), x);
		else 
			setBomb((int)((x * z * 6) / 24), (x * z), x);
		
	}
	
	public void setBomb (int bomb, int total, byte column)
	{ 
		//A method that sets the bombs randomly uwu. 
		for (int i = bomb; i >= 0; i--)
		{
			//Loop that goes on as many times as the bomb (which is how many bombs there should be)
			//A random number is created every time (called the method from the game class).
			this.rndNum = this.game.randomNumber(total);
			//The following two codes are math equations that determine the coordinates of the randomized number in the 2-D array/
			this.game.bytArrayRow = (byte)(Math.ceil((rndNum + 0.1)/ column));
			this.game.bytArrayColumn = (byte)((rndNum - ((this.game.bytArrayRow - 1) * column)));
			//Then sets the text of the button at that coordination to X indicating it is a mine but sets the colour to grey so that it is not shown to the user.
			board[this.game.bytArrayRow - 1][this.game.bytArrayColumn].setText("X");
			board[this.game.bytArrayRow - 1][this.game.bytArrayColumn].setForeground(Color.gray);			
		}
	}
	
	//This is method to count the number of mines on the board.
	public void bombCount()
	{
		//A variable inside this method is declared to keep track of the number of bombs.
		int intCounter = 0; 
		
		//A nested loop to go through my array and then if the text of any of the buttons is equal to X, it means that it is a mine and adds one to the counter. 
		for (int i = 0; i < board.length; i++)
		{
			
			for (int y = 0; y < board[i].length; y++)
			{
				if(board[i][y].getText().equalsIgnoreCase("X"))
					intCounter++;
			}
		}
		//Sets counter that is in the game class equal to the counter that was declared inside this method which counts how many mines there are on the board 
		this.game.intMines = intCounter; 
	}
	
	//The main, GUI is created in this and the user is asked for their name to pass on to the overloaded constructor.
	public static void main (String[] args)
	{ 
		ErenGameGUI p = new ErenGameGUI(JOptionPane.showInputDialog("Welcome to minesweeper! Please enter your name to begin."));
	}
		
