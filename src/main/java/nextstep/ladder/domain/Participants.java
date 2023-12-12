package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Participants {
	private final List<User> participants;

	public Participants(List<User> participants) {
		this.participants = participants;
	}

	public List<User> participants() {
		return Collections.unmodifiableList(participants);
	}

	public int num() {
		return participants.size();
	}
}
