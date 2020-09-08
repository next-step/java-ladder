package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Ladder {
	private final Users users;
	private final List<Line> lines;

	public Ladder(Users users) {
		this.users = users;
		this.lines = new ArrayList<>();
	}

	public Ladder makeLadder(int height) {
		for (int i = 0; i < height; i++) {
			Line line = new Line(users.size());
			lines.add(line);
			this.moveUser(line);
		}
		return this;
	}

	private void moveUser(Line line) {
		for (int i = 0; i < users.size(); i++) {
			users.move(i, line.isPoint(i));
		}
	}

	public List<String> getUsersName() {
		return users.getUsers().stream()
				.map(User::toString)
				.collect(Collectors.toList());
	}

	public List<Line> getCreatedLadder() {
		return Collections.unmodifiableList(lines);
	}

}
