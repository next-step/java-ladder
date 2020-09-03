package laddergame.domain.participant;

import laddergame.exception.LadderGameException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Participants {

	private static final int MIN_PARTICIPANT_COUNT = 2;
	private static final String PARTICIPANT_SHOULD_EQUAL_OR_OVER_N = "참가자 수는 %d명 이상이어야 합니다.";
	private static final String PLEASE_INPUT_NOT_DUPLICATE_PARTICIPANT = "중복되지 않은 참가자를 입력해주세요.";

	private final Set<Participant> participants;

	public Participants(List<Participant> participants) {
		this.participants = createParticipants(participants);
	}

	public int getCount() {
		return participants.size();
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	private Set<Participant> createParticipants(List<Participant> participants) {
		int originSize = participants.size();
		if(originSize < MIN_PARTICIPANT_COUNT) {
			throw new LadderGameException(String.format(PARTICIPANT_SHOULD_EQUAL_OR_OVER_N, MIN_PARTICIPANT_COUNT));
		}
		Set<Participant> distinctParticipants = new LinkedHashSet<>(participants);
		if(originSize != distinctParticipants.size()) {
			throw new LadderGameException(PLEASE_INPUT_NOT_DUPLICATE_PARTICIPANT);
		}
		return Collections.unmodifiableSet(distinctParticipants);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Participants that = (Participants) o;
		return participants.equals(that.participants);
	}

	@Override
	public int hashCode() {
		return Objects.hash(participants);
	}
}
