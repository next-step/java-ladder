package ladder.domain.ladder;

import ladder.domain.ladder.point.PointAddStrategy;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.User;
import ladder.domain.user.Users;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private final Height height;
	private final Lines lines;
	private final Users users;
	private final Results results;

	public Ladder(Height height, Users users, Results results, PointAddStrategy pointAddStrategy) {
		this.height = height;
		this.users = users;
		this.results = results;
		this.lines = Lines.createLines(height.getHeight(), users.getSize(), pointAddStrategy);
	}
	public static Ladder createLadder(Height height, Users users, Results results, PointAddStrategy pointAddStrategy) {
		return new Ladder(height, users, results, pointAddStrategy);
	}

	public int getHeight() {
		return height.getHeight();
	}

	public List<Line> getLines() {
		return lines.getLines();
	}

	public List<User> getUsers() {
		return users.getUsers();
	}

	public List<Result> getResults() {
		return results.getResults();
	}

	public String getMatchResult(String matchUser) {
		return null;
	}
}
