package domain;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderLine {
	private ConnectionPoint connectionPoint;
	private boolean drawn;

	public LadderLine(Point lefPoint, Point rightPoint) {
		this.connectionPoint = new ConnectionPoint(lefPoint, rightPoint);
	}

	public void draw() {
		this.drawn = true;
	}

	public boolean isDrawn() {
		return drawn;
	}

	public boolean isPassable(Point point) {
		return connectionPoint.isConnection(point) && isDrawn();
	}

	public Point getMovePosition(Point point) {
		if (!isPassable(point)) {
			throw new IllegalArgumentException();
		}
		return connectionPoint.getConnectionPoint(point);
	}

}
