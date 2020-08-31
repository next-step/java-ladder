package laddergame.domain.ladder;

import laddergame.domain.line.Line;
import laddergame.domain.line.LineGenerator;
import laddergame.dto.GameConstructData;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGenerator {

	private final LineGenerator lineGenerator;

	public LadderGenerator() {
		this.lineGenerator = new LineGenerator();
	}

	public LadderGenerator(LineGenerator lineGenerator) {
		this.lineGenerator = lineGenerator;
	}

	public Ladder generateLadder(GameConstructData constructData) {
		List<Line> lines = constructData.getLadderHeight().getLadderRange()
							.mapToObj(index -> lineGenerator.generateLine(constructData.getParticipants()))
							.collect(Collectors.toList());
		return new Ladder(lines);
	}
}
