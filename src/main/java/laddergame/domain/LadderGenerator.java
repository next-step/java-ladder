package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

	public static List<Line> generate(int ladderHeight, int playerCount) {
		List<Line> lines = new ArrayList<>();
		while(lines.size() < ladderHeight) {
			lines.add(new Line(playerCount));
		}
		return lines;
	}
}
