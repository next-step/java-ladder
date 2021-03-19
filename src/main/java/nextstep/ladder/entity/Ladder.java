package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.exception.UserException;

public class Ladder {
	private final List<Line> lines;
	private final Users users;

	public Ladder(Users users, List<Line> lines) {
		this.users = users;
		this.lines = lines;
	}

	public Ladder(Users users, int ladderHeight) {
		validateLadderHeight(ladderHeight);

		this.lines = IntStream.range(0, ladderHeight)
			.mapToObj((i) -> new Line(users.getUsers().size()))
			.collect(Collectors.toList());
		this.users = users;
	}

	private void validateLadderHeight(int ladderHeight) {
		if (ladderHeight < 0) {
			throw new UserException(NEGATIVE_NOT_AGRRESIVE);
		}
	}

	public Users getUsers() {
		return users;
	}

	public Ladder moveLadder() {

		List<User> userList = users.getUsers()
			.stream()
			.map(user -> user.moveUser(this.lines))
			.collect(Collectors.toList());
		return new Ladder(new Users(userList), this.lines);
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
