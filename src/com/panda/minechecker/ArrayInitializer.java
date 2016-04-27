package com.panda.minechecker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ArrayInitializer {

	public char [][] readSolution(String path){
		char [][] solution = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String dimensionLine = reader.readLine();
			String [] dimensions = dimensionLine.split(" ");
			int rows = Integer.parseInt(dimensions[0]);
			int cols = Integer.parseInt(dimensions[1]);
			solution= new char[rows][cols];
			for(int i = 0; i < rows; i++){
				String line = reader.readLine();
				for (int j=0; j < cols; j++) {
					solution[i][j] = line.charAt(j);
					
				}
				
			}
			reader.close();
			return solution;
		
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException | NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Formato invalido");
		
		}
		
		return solution;
	}
	
}
