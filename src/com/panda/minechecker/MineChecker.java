package com.panda.minechecker;

public class MineChecker {

	private Board board;
	
	public MineChecker(String path) {
		BoardManager bm = new BoardManager();
		board = bm.createBoard(path);
	}

	public void completeHintBoard() {
		if(board == null) return;
		char [][] hintMatrix = new char[board.getRows()-2][board.getCols()-2];
		for (int i = 1; i < board.getRows()-1; i++) {
			for (int j = 1; j < board.getCols()-1; j++) {
				if(hasMine(i,j)) hintMatrix [i-1][j-1] = '*';
				else hintMatrix [i-1][j-1] =  countMinesInNeighbors(i, j);
				
			}
			
		}
		board.setHintMatrix(hintMatrix);
		
	}
	
	private char countMinesInNeighbors(int i, int j){
		int counter =0;
		
		if(hasMine(i-1,j-1)) counter++;
		if(hasMine(i-1,j)) counter++;
		if(hasMine(i-1,j+1)) counter++;
		if(hasMine(i,j-1)) counter++;
		if(hasMine(i,j+1)) counter++;
		if(hasMine(i+1,j-1)) counter++;
		if(hasMine(i+1,j)) counter++;
		if(hasMine(i+1,j+1)) counter++;
		
		return Character.forDigit(counter, 10);
	}
	private boolean hasMine(int i, int j){
		return board.getMatrix()[i][j] == '*';
	}
	

	public Object[] getHintBoard() {
		return board.getHintMatrix();
	}
	
	public void displayHintBoard(){
		if (board.getHintMatrix() == null) completeHintBoard();
		board.displayHintBoard();
	}

}
