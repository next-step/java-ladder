package laddergame.domain.line;

import laddergame.domain.Coordinate;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.Point;
import laddergame.domain.point.PointGenerator;

import java.util.stream.IntStream;

public class LineGenerator {

	private static final int SECOND_POINT_INDEX = 1;

	private final PointGenerator pointGenerator;

	public LineGenerator() {
		this.pointGenerator = new PointGenerator();
	}

	public LineGenerator(PointGenerator pointGenerator) {
		this.pointGenerator = pointGenerator;
	}

	public Line generateLine(Participants participants) {
		int lastIndexOfLine = participants.getParticipantsCount() - 1;
		Line newLine = new Line();

		newLine.addPoint(pointGenerator.generateLineStartPoint());
		IntStream.range(SECOND_POINT_INDEX, lastIndexOfLine)
				.mapToObj(index -> pointGenerator.generateNextPoint(newLine.getLastPoint(), new Coordinate(index)))
				.forEach(newLine::addPoint);
		newLine.addPoint(pointGenerator.generateLineEndPoint(newLine.getLastPoint(), new Coordinate(lastIndexOfLine)));

		return newLine;
	}
}
