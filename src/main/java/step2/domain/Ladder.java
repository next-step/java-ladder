package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Ladder {
	private final List<User> users;
	private final List<Line> lines;

	public Ladder(List<User> users, List<Line> lines) {
		this.users = users;
		this.lines = lines;
	}

	public static Ladder makeLadder(List<User> users, int height) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			lines.add(new Line(users.size()));
		}
		return new Ladder(users, lines);
	}

	public String users() {
		return users.stream()
				.map(user -> String.format("%6s", user.toString()))
				.collect(Collectors.joining());
	}

	public String lines() {
		StringBuilder sb = new StringBuilder();
		lines.forEach(line -> sb.append(line.toString()).append(System.lineSeparator()));
		return sb.toString();
	}

}
