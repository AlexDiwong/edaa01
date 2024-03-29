package mountain;

public class Side {
	private Point a, b, middle;
	
	public Side(Point a, Point b, double dev) {
		this.a = a;
		this.b = b;
		middle = new Point((b.getX() + a.getX())/2.0, ((b.getY() + a.getY())/2.0) - RandomUtilities.randFunc(dev));
	}

	public boolean equals(Point a, Point b) {
		if(this.a.equals(a) && this.b.equals(b)) {
			return true;
		}
		if(this.a.equals(b) && this.b.equals(a)) {
			return true;
		}
		return false;
	}


	public Point getMiddle() {
		return middle;
	}
	
	public Point getA() {
		return a;
	}
	
	public Point getB() {
		return b;
	}
}
