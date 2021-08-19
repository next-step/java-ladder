package ladder.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.model.Height;
import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Players;

public class LadderCreate {

	public static final int START_INCLUSIVE = 0;

	public static Lines createLadder(Players players, Height height) {
		return new Lines(IntStream.range(START_INCLUSIVE, height.getHeight())
			.mapToObj(i -> Line.createLine(players.findPlayerCount()))
			.collect(Collectors.toList()));
	}

}
