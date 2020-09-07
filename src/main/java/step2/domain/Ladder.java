package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
			lines.add(new Line(users.size()));
		}
		return this;
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
