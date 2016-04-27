package com.panda.minechecker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BoardManager {

public Board createBoard(String path){
		
		Board board = null;
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));
			// Makes the board wider to save the trouble of checking board edges
			String dimensionLine = reader.readLine();
			String [] dimensions = dimensionLine.split(" ");
			int rows = Integer.parseInt(dimensions[0]) +2;
			int cols = Integer.parseInt(dimensions[1]) +2;
			char [][] matrix = new char[rows][cols];
			int z =0;
			for(int i = 1; i < rows-1; i++){
				String line = reader.readLine();
				for (int j=1; j < cols-1; j++) {
					z = j-1;
					matrix[i][j] = line.charAt(z);
					
				}
				
			}
			reader.close();
			board = new Board(matrix, rows, cols);
		
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException | NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Formato invalido");
		}
		return board;
		
	}


}
