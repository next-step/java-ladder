package step2.domain.ladder;

import step2.domain.line.Line;
import step2.domain.line.LineGenerator;
import step2.dto.GameConstructData;

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
