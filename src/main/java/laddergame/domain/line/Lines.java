package laddergame.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.result.DisplayLadder;
import laddergame.domain.result.DisplayLine;

public class Lines {

	private List<Line> lines;

	private Lines(List<Line> lines) {
		this.lines = lines;
	}

	public static Lines from(int ladderHeight, int playerCount) {
		List<Line> lines = new ArrayList<>();
		while(lines.size() < ladderHeight) {
			lines.add(Line.from(playerCount));
		}
		return from(lines);
	}

	public static Lines from(List<Line> lines) {
		return new Lines(lines);
	}

	public int move(int index) {
		int currentIndex = index;
		for (Line line : lines) {
			currentIndex = line.move(currentIndex);
		}
		return currentIndex;
	}

	public String getDisplayLines() {
		return lines.stream()
				.map(Line::getDisplayLine)
				.map(DisplayLine::draw)
				.collect(Collectors.joining(DisplayLadder.NEW_LINE));
	}
}
