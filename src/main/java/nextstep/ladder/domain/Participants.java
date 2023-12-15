package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
	private final List<User> participants;

	public Participants(List<User> participants) {
		this.participants = participants;
	}

	public Participants(String str) {
		this.participants = Arrays.stream(str.split(","))
			.map(User::new)
			.collect(Collectors.toList());
	}

	public List<User> values() {
		return Collections.unmodifiableList(participants);
	}

	public int num() {
		return participants.size();
	}

	public boolean equalName(int index, String name) {
		return participants.get(index).equalName(name);
	}
}
