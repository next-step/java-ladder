package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
	public static final String REGEX = ",";
	private final List<Participant> participants;

	public Participants(String participantNames) {
		String[] names = participantNames.split(REGEX);
		this.participants = IntStream
			.range(0, names.length)
			.mapToObj(i -> new Participant(names[i], new Position(i + 1)))
			.collect(Collectors.toList());
	}

	public List<String> names() {
		return this.participants
			.stream()
			.map(Participant::name)
			.collect(Collectors.toList());
	}

	public int countOfPerson() {
		return this.participants.size();
	}

	public void playLadder(Ladder ladder) {
		this.participants.forEach(participant -> ladder.play(participant));
	}

	public Participant findByName(String name) {
		return this.participants
			.stream()
			.filter(participant -> participant.name().equals(name))
			.findFirst()
			.get();
	}

	public List<Participant> participants() {
		return this.participants;
	}
}
