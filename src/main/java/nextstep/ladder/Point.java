package nextstep.ladder;

public class Point {
	private boolean point;

	public Point(boolean point) {
		this.point = point;
	}

	public Point(DrawStrategy drawStrategy) {
		this.point = drawStrategy.isDraw();
	}

	public boolean isPoint() {
		return point;
	}

}
