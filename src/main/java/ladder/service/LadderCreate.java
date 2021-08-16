package ladder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.model.Height;
import ladder.model.Line;
import ladder.model.LineSketch;
import ladder.model.Lines;
import ladder.model.Players;

public class LadderCreate {

	public static final boolean LINE_INITIAL_POSITION = false;
	public static final int START_INCLUSIVE = 0;
	public static final int PREV_POSITION = 1;

	public static Lines createLadder(Players players, Height height) {
		return new Lines(IntStream.range(0, height.getHeight())
			.mapToObj(i -> new Line(createLinePoints(players)))
			.collect(Collectors.toList()));
	}

	private static List<Boolean> createLinePoints(Players players) {
		List<Boolean> points = new ArrayList<>();
		IntStream.range(START_INCLUSIVE, players.findPlayerCount())
			.forEach(position -> points.add(pointStatus(position, points)));
		return points;
	}

	private static boolean pointStatus(int position, List<Boolean> points) {
		if (position == 0) {
			return LINE_INITIAL_POSITION;
		}
		return LineSketch.drawLine(points.get(position - PREV_POSITION));
	}
}
