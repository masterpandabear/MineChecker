package com.panda.minechecker;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MineChekcerTest {
	
	private ArrayInitializer ai;
	private String inputFilename;
	private String solutionFilename;
	
	

	public MineChekcerTest(String inputFilename, String solutionFilename) {
		this.ai = new ArrayInitializer();
		this.inputFilename = inputFilename;
		this.solutionFilename = solutionFilename;
	}


	@Parameters
	public static Collection<String []> getFileNames(){
		return Arrays.asList(new String [][]{
				{"example.txt", "solution.txt"}
		});
	}
	
	@Test
	public void testCompletedHintBoard() {
		BoardManager bm = new BoardManager();
		URL input = getClass().getResource(inputFilename);
		URL solution = getClass().getResource(solutionFilename);
		MineChecker mc = new MineChecker(bm.createBoard(input.getPath()));
		mc.completeHintBoard();
		char expected [][] = ai.readSolution(solution.getPath());
		assertArrayEquals(expected, mc.getHintBoard());
	}

}
