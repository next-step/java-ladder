package ladder.domain.ladder;

import ladder.domain.LadderExecutionResult;
import ladder.domain.Direction;
import ladder.domain.LadderInput;
import ladder.domain.Participants;
import ladder.domain.line.FirstLine;
import ladder.domain.line.LastLine;
import ladder.domain.line.Line;
import ladder.domain.line.MiddleLine;
import ladder.domain.point.Point;
import ladder.domain.policy.PointConnectPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

	private final List<Line> lines = new ArrayList<>();

	public Ladder(PointConnectPolicy policy, LadderInput ladderInput, int lineHeight) {
		makeLinesHorizontally(policy, ladderInput, lineHeight);
		makeConnectionsVertically();
	}

	public Ladder(PointConnectPolicy policy, Participants participants, int lineHeight) {
		LadderInput newLadderInput = new LadderInput(participants);
		makeLinesHorizontally(policy, newLadderInput, lineHeight);
		makeConnectionsVertically();
	}

	private void makeLinesHorizontally(PointConnectPolicy policy, LadderInput ladderInput, int lineHeight) {
		lines.add(new FirstLine(ladderInput));
		for (int i = 0; i < lineHeight; i++) {
			lines.add(new MiddleLine(policy, ladderInput));
		}
		lines.add(new LastLine(ladderInput));
	}

	private void makeConnectionsVertically() {
		for (int i = 0, end = lines.size() - 1; i < end; i++) {
			getLine(i).connectLinesVertically(getNextLine(i));
		}
	}

	private Line getLine(int index) {
		return lines.get(index);
	}

	private Line getNextLine(int index) {
		return lines.get(index + 1);
	}

	public String getResult(String name) {
		Line firstLine = getFirstLine();
		Point targetPoint = firstLine.getPoints().stream()
				.filter(point -> name.equals(point.getName()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("%s의 사다리는 없습니다", name)));
		return targetPoint.getResultFrom(Direction.VERTICAL);
	}

	public LadderExecutionResult getAllResult() {
		List<String> names = getNames();
		LadderExecutionResult resultMap = new LadderExecutionResult();
		for (String name : names) {
			resultMap.add(name, getResult(name));
		}
		return resultMap;
	}

	private List<String> getNames() {
		return getFirstLine().getPoints().stream()
				.map(Point::getName)
				.collect(Collectors.toList());
	}

	private Line getFirstLine() {
		return getLine(0);
	}

	public List<Line> getLines() {
		return lines;
	}

}
