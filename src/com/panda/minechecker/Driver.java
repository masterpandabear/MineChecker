package com.panda.minechecker;

public class Driver {
	
	public static void main(String[] args) {
		if(args.length <1){
			System.out.println("Favor de especificar archivo de entrada");
			return;
		}
		MineChecker mc = new MineChecker(args[0]);
		mc.displayHintBoard();
	}

}
