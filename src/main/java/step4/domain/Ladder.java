package step4.domain;

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
			Line line = Line.init(users.size());
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

	public List<String> getAllUserName() {
		return users.getUsers().stream()
				.map(User::toString)
				.collect(Collectors.toList());
	}
	
	public String getUserName(int index) {
		return users.getUsers().get(index).toString();
	}

	public List<Line> getCreatedLadder() {
		return Collections.unmodifiableList(lines);
	}
	
	public boolean containUser(String name) {
		return this.getAllUserName().contains(name);
	}
	
	public int getUserPositionOf(String name) {
		return users.getPositionOf(name);
	}
}
