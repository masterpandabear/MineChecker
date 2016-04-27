package com.panda.minechecker;

public class Board {
	
	private char[][] matrix;
	private int rows;
	private int cols;
	private char [][] hintMatrix;
	
	public Board(char[][] matrix, int rows, int cols) {
		this.matrix = matrix;
		this.rows = rows;
		this.cols = cols;
	}

	public char[][] getHintMatrix() {
		return hintMatrix;
	}

	public void setHintMatrix(char[][] hintMatrix) {
		this.hintMatrix = hintMatrix;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
	
	public void displayHintBoard(){
		System.out.println(arrayToString(hintMatrix));
	}
	
	private String arrayToString(char [][] array){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				sb.append(array[i][j]);
			}
			sb.append("/n");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Board [rows=" + rows + ", cols=" + cols + "]/n" +arrayToString(matrix);
	}
	
	
	
	
	

}
