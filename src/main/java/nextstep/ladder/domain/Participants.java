package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
	public static final String REGEX = ",";
	private final List<Participant> participantNames;

	public Participants(String participantNames) {
		this.participantNames = Arrays
			.stream(participantNames.split(REGEX))
			.map(name -> new Participant(name))
			.collect(Collectors.toList());
	}

	public List<String> names() {
		return this.participantNames
			.stream()
			.map(Participant::name)
			.collect(Collectors.toList());
	}
}
