package step2.domain.participant;

import step2.domain.Coordinate;
import step2.exception.LadderGameException;

import java.util.Objects;

import static step2.util.StringUtil.isNullOrEmpty;

public class Participant {

	private static final int MAX_NAME_LENGTH = 5;
	private static final String NAME_SHOULD_NOT_NULL_OR_EMPTY = "참가자의 이름이 공백일 수 없습니다.";
	private static final String NAME_LENGTH_CAN_NOT_OVER_N = "참가자 이름의 길이가 %d자를 넘을 수 없습니다.";

	private final String name;

	private final Coordinate startCoordinate;

	public Participant(String name, Coordinate startCoordinate) {
		validateName(name);
		this.name = name;
		this.startCoordinate = startCoordinate;
	}

	public String getName() {
		return name;
	}

	public Coordinate getStartCoordinate() {
		return startCoordinate;
	}

	private void validateName(String name) {
		if(isNullOrEmpty(name)) {
			throw new LadderGameException(NAME_SHOULD_NOT_NULL_OR_EMPTY);
		}
		if(isOverMaxNameLength(name)) {
			throw new LadderGameException(String.format(NAME_LENGTH_CAN_NOT_OVER_N, MAX_NAME_LENGTH));
		}
	}

	private boolean isOverMaxNameLength(String name) {
		return name.length() > MAX_NAME_LENGTH;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Participant that = (Participant) o;
		return name.equals(that.name) &&
				startCoordinate.equals(that.startCoordinate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, startCoordinate);
	}
}
