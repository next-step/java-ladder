package ladder.domain;

import ladder.util.StringUtil;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-24
 */
public class LadderGameResults extends AbstractList<LadderGameResult> {

	private List<LadderGameResult> resultValues;

	private LadderGameResults(List<LadderGameResult> resultValues) {
		this.resultValues = resultValues;
	}

	public static LadderGameResults of(List<String> ladderGameResults) {
		List<LadderGameResult> results = ladderGameResults.stream()
			.filter(StringUtil::isNotBlank)
			.map(LadderGameResult::of)
			.collect(Collectors.toList());

		return new LadderGameResults(results);
	}

	public static LadderGameResults of(LadderGameResult resultValue) {
		return new LadderGameResults(List.of(resultValue));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LadderGameResults that = (LadderGameResults)o;
		return Objects.equals(resultValues, that.resultValues);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultValues);
	}

	@Override
	public LadderGameResult get(int index) {
		if (index < 0 || index >= resultValues.size()) {
			throw new IllegalArgumentException("잘못된 위치 입니다 " + index);
		}

		return resultValues.get(index);
	}

	@Override
	public int size() {
		return resultValues.size();
	}

	public LadderGameResult get(Person person) {
		if (isOdd(person.getPosition())) {
			throw new IllegalArgumentException("잘못된 위치 입니다. " + person);
		}

		return get(getIndex(person.getPosition()));
	}

	private int getIndex(int position) {
		return position / 2;
	}

	private boolean isOdd(int position) {
		return position % 2 != 0;
	}

	public LadderGameResults get(Persons persons) {
		List<LadderGameResult> collect = persons.stream()
			.map(this::get)
			.collect(Collectors.toList());

		return new LadderGameResults(collect);
	}
}