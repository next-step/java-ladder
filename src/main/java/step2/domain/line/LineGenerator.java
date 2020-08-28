package step2.domain.line;

import step2.domain.Coordinate;
import step2.domain.point.Point;
import step2.domain.point.PointGenerator;

public class LineGenerator {

	private final PointGenerator pointGenerator;

	public LineGenerator() {
		this.pointGenerator = new PointGenerator();
	}

	public LineGenerator(PointGenerator pointGenerator) {
		this.pointGenerator = pointGenerator;
	}

	public Line generateLine(int participantCount) {
		int lastIndexOfLine = participantCount - 1;
		Line newLine = new Line();
		newLine.addPoint(pointGenerator.generateLineStartPoint());
		for (int i = 1; i < lastIndexOfLine; i++) {
			Point newPoint = pointGenerator.generateNextPoint(newLine.getLastPoint(), new Coordinate(i));
			newLine.addPoint(newPoint);
		}
		newLine.addPoint(pointGenerator.generateLineEndPoint(newLine.getLastPoint(), new Coordinate(lastIndexOfLine)));
		return newLine;
	}
}
