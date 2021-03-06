package tictactoe;

import java.util.Scanner;

import baseClasses.Logic;
import baseClasses.Player;
import baseClasses.State;


public class TicTacToeLogic extends Logic
{
	boolean gameEnd;
	String player;
	String[][] board = new String[3][3];
	
	TicTacToeLogic(State s){
		gameEnd = s.gameEnd;
		player = "X";
	}
	
	void start()
	{
		fillBoard();
		Scanner in = new Scanner(System.in);
		
		while(!gameEnd){
			printBoard();
			System.out.print("Enter Col for " + player + ": ");
			int col = in.nextInt();	
			System.out.print("Enter Row for " + player + ": ");
			int row = in.nextInt();
	
			placePiece(row-1,col-1);
		}
		in.close();
		
	}
	
	public int getXCoordinate(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Col for " + player + ": ");
		int col = in.nextInt();	
		in.close();
		return col;
	}
	
	public int getYCoordinate(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Row for " + player + ": ");
		int row = in.nextInt();	
		in.close();
		return row;
	}

	public void fillBoard(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++)
				board[row][col] = "*";
		}
	}
	
	public void printBoard(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++)
				System.out.print(board[row][col] + "  ");
			System.out.println();
		}
	}
	
	public void placePiece(int row, int col){
		if (board[row][col] == "*")
			board[row][col] = player;
		checkWin();
		checkFull();
		switchPlayer();
	}
	
	public void switchPlayer(){
		if (player == "O")
			player = "X";
		else if (player == "X")
			player = "O";
	}
	
	public void checkWin(){
		//check horizontal
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != "*"){
			gameEnd = true;
		}
		if (board[1][0] == board[1][1] && board[1][1] == board[1][2]&& board[1][0] != "*"){
			gameEnd = true;
		}
		if (board[2][0] == board[2][1] && board[2][1] == board[2][2]&& board[2][0] != "*"){
			gameEnd = true;
		}
		//check vertical
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != "*"){
			gameEnd = true;
		}
		if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != "*"){
			gameEnd = true;
		}
		if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != "*"){
			gameEnd = true;
		}
		//check diagonal
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != "*"){
			gameEnd = true;
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != "*"){
			gameEnd = true;
		}
		
		if (gameEnd){
			printBoard();
			System.out.print("WINNER IS: " + player);
		}
	}
	
	public void checkFull(){		
		if (!gameEnd){
			String full = "";
			for (int row = 0; row < 3; row++){
				for (int col = 0; col < 3; col++){
					full += board[row][col];
				}
			}
			if (!full.contains("*")){
				gameEnd = true;
				printBoard();
				System.out.println("CATS GAME");
			}		
		}
	}

}

