package solver;

import javax.swing.*;
import sudoku.OneLetterField;
import java.awt.*;

public class Solver {

	private int[][] sudoku;

	/**Skapar en 9x9-matris och innehåller metoder för att lösa en sudoku*/
	public Solver() {
		sudoku = new int[9][9];
	}
	/**Skapar en matris med samma innehåll som parametern field och ser till att inga otillåtena värden är instoppade.
	 * @param field matrisen av objekten OneLetterField som skall överföras till matrisen
	 * @return returnerar true om överföringen gick bra och false om otillåtena värden hade stopppats in*/
	public boolean createMatrix(OneLetterField[][] field) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (field[i][j].getText().equals("")) {
					sudoku[i][j] = 0;
				} else {
					sudoku[i][j] = field[i][j].getText().charAt(0) - 48;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int temp = sudoku[i][j];
				if (temp != 0) {
					sudoku[i][j] = 0;
					if (!horizontal(j, temp) || !vertical(i, temp)
							|| !inRegion(i, j, temp)) {
						return false;
					} else {
						sudoku[i][j] = temp;
					}
				}
			}
		}
		return true;
	}
	/**Löser sudokun.
	 * @param field matrisen av objekt av klassen OneLetterField som ska lösas
	 * @return returnerar true om sudokun gick att lösa*/

	public boolean solve() {
		return solver(0, 0);
	}
/**Skickar tillbaka en matris med Integer-objekt
 * @return returnerar en int-matris med sudokuns innehåll*/
	public int[][] getSolved() {
		return sudoku;
	}

	private boolean solver(int row, int column) {
		if (column == 9) {
			row++;
			column = 0;
		}
		if (sudoku[column][row] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (horizontal(row, i) && vertical(column, i)
						&& inRegion(column, row, i)) {
					sudoku[column][row] = i;
					if (row == 8 && column == 8) {
						return true;
					}
					if (solver(row, column + 1)) {
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
			if (solver(row, column + 1)) {
				return true;
			}
		}
		return false;
	}

	private boolean horizontal(int row, int value) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][row] == value) {
				return false;
			}
		}
		return true;
	}

	private boolean vertical(int column, int value) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[column][i] == value) {
				return false;
			}
		}
		return true;
	}

	private boolean inRegion(int column, int row, int value) {
		for (int i = (column / 3) * 3; i <= (column / 3) * 3 + 2; i++) {
			for (int j = (row / 3) * 3; j <= (row / 3) * 3 + 2; j++) {
				if (sudoku[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
