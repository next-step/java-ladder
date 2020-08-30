package step2.domain.participant;

import step2.exception.LadderGameException;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Participants {

	private static final String PLEASE_INPUT_NOT_DUPLICATE_PARTICIPANT = "중복되지 않은 참가자를 입력해주세요.";

	private final Map<String, Participant> participants;

	public Participants(Participant[] participants) {
		try {
			this.participants = Arrays.stream(participants)
									.collect(Collectors.toUnmodifiableMap(Participant::getName, Function.identity()));
		} catch (IllegalStateException e) {
			throw new LadderGameException(PLEASE_INPUT_NOT_DUPLICATE_PARTICIPANT, e);
		}
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
