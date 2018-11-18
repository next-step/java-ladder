package domain;

import com.google.common.base.Preconditions;

/**
 * Created by hspark on 18/11/2018.
 */
public class ConnectionPoint {
	private Point leftVertex;
	private Point rightVertex;

	public ConnectionPoint(Point leftPoint, Point rightPoint) {
		Preconditions.checkArgument(leftPoint.isAdjacent(rightPoint));
		Preconditions.checkArgument(leftPoint.getDiff(rightPoint) < 0);

		this.leftVertex = leftPoint;
		this.rightVertex = rightPoint;
	}

	public boolean isConnection(Point point) {
		return (leftVertex.equals(point) || rightVertex.equals(point));
	}

	public Point getConnectionPoint(Point point) {
		if (!isConnection(point)) {
			throw new IllegalArgumentException();
		}
		if (leftVertex.equals(point)) {
			return rightVertex;
		}
		return leftVertex;
	}
}
