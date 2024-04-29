package nextstep.ladder;

import nextstep.ladder.domain.Line;

public class GameUser {
	private String userName;
	private Position position;

	public GameUser(String userName, Position position) {
		this.userName = userName;
		this.position = position;
	}

	public void move(Line line) {
		this.position = line.move(position);
	}

	public int getPosition() {
		return position.getPosition();
	}


	public String getUserName() {
		return userName;
	}

}
