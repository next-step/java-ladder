package nextstep.ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.ladder.util.CollectionUtils;

public class Participants {
	private static final String EMPTY_MESSAGE = "participant 리스트가 비어있습니다.";

	private final List<Participant> values;

	private Participants(List<Participant> values) {
		validateSize(values);
		this.values = new ArrayList<>(values);
	}

	private void validateSize(List<Participant> values) {
		if (CollectionUtils.isEmpty(values)) {
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}

	public static Participants create(List<Participant> values) {
		return new Participants(values);
	}

	public static Participants create(String[] names) {
		return Arrays.stream(names)
			.map(Participant::create)
			.collect(collectingAndThen(toList(), Participants::new));
	}

	public int size() {
		return values.size();
	}

	public List<Participant> getValues() {
		return Collections.unmodifiableList(values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Participants participants = (Participants)obj;

		return Objects.equals(values, participants.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
