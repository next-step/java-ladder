package nextstep.ladder.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	private final List<Line> lines;
	private final Users users;

	public Ladder(Users users, int ladderHeight) {
		this.lines = IntStream.range(0, ladderHeight)
			.mapToObj((i) -> new Line(users.getUsers().size()))
			.collect(Collectors.toList());
		this.users = users;
	}

	@Override
	public String toString() {
		String userPrefix = users.toString();
		String ladder = this.lines.stream()
			.map(line -> String.format("    %s \n", line.toString()))
			.collect(Collectors.joining());

		return userPrefix + "\n" + ladder;
	}
}
