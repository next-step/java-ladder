package laddergame.domain;

import static laddergame.domain.Ladder.NEW_LINE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public String getDisplayLines() {
		return lines.stream()
				.map(Line::draw)
				.collect(Collectors.joining(NEW_LINE));
	}

	public int move(int index) {
		int currentIndex = index;
		for (Line line : lines) {
			currentIndex = line.move(currentIndex);
		}
		return currentIndex;
	}
}
