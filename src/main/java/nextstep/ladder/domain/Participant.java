package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.exception.ParticipantNameSizeException;

public class Participant {
	public static final int SIZE_OF_NAME = 5;

	private final String name;

	private Participant(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		if (name.length() > 5) {
			throw new ParticipantNameSizeException();
		}
	}

	public static Participant create(String name) {
		return new Participant(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Participant participant = (Participant)obj;

		return Objects.equals(name, participant.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
