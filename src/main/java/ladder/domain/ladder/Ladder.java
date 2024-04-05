package ladder.domain.ladder;

import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.User;
import ladder.domain.user.Users;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private final Height height;
	private final List<Line> lines;
	private final Users users;
	private final Results results;

	public Ladder(Height height, List<Line> lines, Users users, Results results) {
		this.height = height;
		this.lines = lines;
		this.users = users;
		this.results = results;
	}

	public static Ladder createLadder(Height height, Users users, Results results) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < height.getHeight(); i++) {
			lines.add(Line.createLine(users.getCountOfPerson()));
		}
		return new Ladder(height, lines, users, results);
	}

	public int getHeight() {
		return height.getHeight();
	}

	public List<Line> getLines() {
		return lines;
	}

	public List<User> getUsers() {
		return users.getUsers();
	}

	public List<Result> getResults() {
		return results.getResults();
	}
}
