package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;

import java.util.List;
import java.util.Optional;

import nextstep.ladder.exception.UserException;

public class User {
	private final String name;
	private Position position;

	public User(final String name, final Position position) {
		validateName(name);
		this.name = name;
		this.position = position;
	}

	public User(final String name, final int position) {
		this(name, new Position(position));
	}

	private void validateName(String name) {
		if (Optional.ofNullable(name).orElse("").length() > 5) {
			throw new UserException(NAME_SIZE_CHECK_FIVE);
		}
	}

	public User moveUser(List<Line> lines) {
		for (Line line : lines) {
			List<Root> root = line.getRoots();
			moveWithRoot(root);
		}
		return new User(this.name, this.position);
	}

	private void moveWithRoot(List<Root> roots) {
		for (int i = 0; i < roots.size(); i++) {
			this.position = this.position.move(roots.get(i), i);
		}
	}

	public String getName(){
		return this.name;
	}

	public int getPosition() {
		return position.getPosition();
	}

	@Override
	public String toString() {
		return this.name;
	}
}
