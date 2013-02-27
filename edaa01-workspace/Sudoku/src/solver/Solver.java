package solver;

import javax.swing.*;
import sudoku.OneLetterField;
import java.awt.*;

public class Solver {
	
	private int[][] sudoku;

	public Solver() {
		sudoku = new int[9][9];
	}
	public void printSudoku(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				int n = sudoku[j][i];
				System.out.print(n + " ");
			}
			System.out.println("");
		}
	}
	
	private void createMatrix(OneLetterField[][] field) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] =field[i][j].getText().charAt(0) - 48;
			}
		}
	}
	
	public boolean solve(OneLetterField[][] field) {
		createMatrix(field);
		return solve2(0, 0);
	}
	
	public int[][] getSolved() {
		return sudoku;
	}
	
	private boolean solving(int row, int column) {
		if(row <= 8 && column <= 8) {
			if(sudoku[column][row] != 0) {
				if(solving(row, column + 1) &&	solving(row + 1, column)) {
					return true;
				}
			} else {
				for (int i = 1; i <= 9; i++) {
					if(horizontal(row, i) && vertical(column, i) && inRegion(column, row, i)) {
						sudoku[column][row] = i;
						if(solving(row, column + 1) &&	solving(row + 1, column)) {
							return true;
						} else {
							sudoku[column][row] = 0;
						}
					}
				}
			}
		} else {
			return true;
		}
		return false;
	}
	
	private boolean solve2(int row, int column) {
		if (column == 9) {
			row++;
			column = 0;
		}
		if(sudoku[column][row] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(horizontal(row, i) && vertical(column, i) && inRegion(column, row, i)) {
					sudoku[column][row] = i;
					if (row == 8 && column == 8) {
						return true;
					}
					if(solve2(row, column + 1)) {
						return true;
					} else {
						sudoku[column][row] = 0;
					}
				}
			}
			return false;
		} else {
			if (row == 8 && column == 8) {
				return true;
			}
			if(solve2(row, column +1)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean horizontal(int row, int value) {
		for(int i = 0; i < 9; i++) {
			if (sudoku[i][row] == value) {
				return false;
			}
		}
		return true;
	}
	
	private boolean vertical(int column, int value) {
		for(int i = 0; i < 9; i++) {
			if (sudoku[column][i] == value) {
				return false;
			}
		}
		return true;
	}
	
	private boolean inRegion(int column, int row, int value) {
//		int region = Region.getRegion(column, row);
//		int startC = Region.getStartColumn(region);
//		int endC = Region.getEndColumn(region);
//		int startR = Region.getStartRow(region);
//		int endR = Region.getEndRow(region);
//		for (int i = startR; i <= endR; i++){
//			for(int k = startC; k <= endC; k++){
//				if(sudoku[k][i] == value){
//					return false;
//				}
//			}
//		}
		for(int i = (column/3)*3; i <= (column/3)*3 + 2; i++) {
			for (int j = (row/3)*3; j <= (row/3)*3 + 2; j++) {
				if (sudoku[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
