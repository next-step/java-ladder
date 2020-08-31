package laddergame.domain.result;

import laddergame.domain.Coordinate;
import laddergame.exception.LadderGameException;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prizes {

	private static final int START_INDEX = 0;
	private static final String PRIZES_COUNT_SHOULD_EQUAL_PARTICIPANT_COUNT = "사다리 타기 결과의 수는 참가자의 수와 같아야 합니다.";

	private final Map<Coordinate, String> resultMap;

	public Prizes(String[] names, int participantsCount) {
		if(names.length != participantsCount) {
			throw new LadderGameException(PRIZES_COUNT_SHOULD_EQUAL_PARTICIPANT_COUNT);
		}
		this.resultMap = IntStream.range(START_INDEX, names.length)
							.boxed()
							.collect(Collectors.toMap(Coordinate::new, index -> names[index], (integer1, integer2) -> integer1, LinkedHashMap::new));
	}

	public Collection<String> getPrizeNames() {
		return resultMap.values();
	}

	public String getResultByResultCoordinate(Coordinate resultCoordinate) {
		return resultMap.get(resultCoordinate);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Prizes prizes = (Prizes) o;
		return resultMap.equals(prizes.resultMap);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultMap);
	}
}
