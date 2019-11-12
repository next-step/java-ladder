package ladder.domain.line;

import ladder.domain.point.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class Line {

	final List<Point> points = new ArrayList<>();

	public void connectLinesVertically(Line line) {
		for (int i = 0, end = points.size(); i < end; i++) {
			getPoint(i).connectWithPointVertically(line.getPoint(i));
		}
	}

	Point getPoint(int index) {
		return points.get(index);
	}

	Point getNextPoint(int index) {
		return points.get(index + 1);
	}

	public List<Point> getPoints() {
		return points;
	}

}
