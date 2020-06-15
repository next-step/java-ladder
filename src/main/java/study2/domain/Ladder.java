package study2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	
	private List<Line> lines;
	
	public Ladder(Players players, Height height) {
		this.lines = makeLadder(players, height);
	}

	private List<Line> makeLadder(Players players, Height height) {
		int playerNumbers = players.getPlayersCount();
		
		
		
		return IntStream.rangeClosed(1, height.getHeight())
				.mapToObj(i -> new Line(playerNumbers, RandomGenerator.randomGenratoring()))
				.collect(Collectors.toList());
	}
	
	public List<Line> getLine() {
		return lines;
	}
	
}
