package nextstep.ladder.domain.ladder;

import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;

import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.util.painter.PaintingStrategy;

public class Ladder {

	private Players players;
	private final Lines lines;
	private final PaintingStrategy paintingStrategy;

	private Ladder(Players players, Height height, PaintingStrategy paintingStrategy) {
		this.players = players;
		this.paintingStrategy = paintingStrategy;
		this.lines = drawLines(height);
	}

	public static Ladder ofLadder(Players players, Height height, PaintingStrategy paintingStrategy) {
		return new Ladder(players, height, paintingStrategy);
	}

	private Lines drawLines(Height height) {
		int playerCount = players.getSize();
		int heightCount = height.getHeightValue();

		return IntStream.range(0, heightCount)
			.mapToObj(index -> Line.ofLine(playerCount, paintingStrategy))
			.collect(collectingAndThen(toList(), Lines::ofLines));
	}

	public Players determinePlayersPositionResult() {
		Players updatedPlayers = this.lines.determinePlayersPositionResult(this.players);
		this.players = updatedPlayers;
		return this.players;
	}

	public Players getPlayers() {
		return players;
	}

	public Lines getLines() {
		return lines;
	}
}
