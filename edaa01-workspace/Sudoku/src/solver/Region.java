package solver;

public class Region {
	

	public static int getRegion(int column, int row) {
		if (column <= 3) {
			if (row <= 3) {
				return 1;
			} else if (row <= 6) {
				return 4;
			} else {
				return 7;
			}
		} else if (column <= 6) {
			if (row <= 3) {
				return 2;
			} else if (row <= 6) {
				return 5;
			} else {
				return 8;
			}
		} else {
			if (row <= 3) {
				return 3;
			} else if (row <= 6) {
				return 6;
			} else {
				return 9;
			}
		}
	}
	
	public static int getStartRow(int region) {
		if (region <= 3) {
			return 0;
		} else if (region <= 6) {
			return 3;
		} else {
			return 6;
		}
	}
	
	public static int getEndRow(int region) {
		if (region <= 3) {
			return 2;
		} else if (region <= 6) {
			return 5;
		} else {
			return 8;
		}
	}
	
	public static int getStartColumn(int region) {
		if (region == 1 || region == 4 || region == 7) {
			return 0;
		} else if (region == 2 || region == 5|| region == 8) {
			return 3;
		} else {
			return 6;
		}
	}
	public static int getEndColumn(int region) {
		if (region == 1 || region == 4 || region == 7) {
			return 2;
		} else if (region == 2 || region == 5|| region == 8) {
			return 5;
		} else {
			return 8;
		}
	}
	
}
