package ladder.dto;

import ladder.domain.LadderGameResults;
import ladder.domain.Person;
import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class InputDTO {

	public static final String SEPARATOR = ",";

	private List<Person> persons;
	private int height;
	private LadderGameResults ladderGameResults;

	private InputDTO(List<Person> persons, int height, LadderGameResults ladderGameResults) {
		this.persons = persons;
		this.height = height;
		this.ladderGameResults = ladderGameResults;
	}

	public static InputDTO from(String names, int height, String ladderGameResults) {
		validate(names, height, ladderGameResults);

		List<Person> people = toPersons(names);
		LadderGameResults results = toLadderGameResults(ladderGameResults);

		if (people.size() != results.)

		return new InputDTO(people, height, results);
	}

	private static void validate(String names, int height, String ladderGameResults) {
		if (StringUtil.isBlank(names)) {
			throw new IllegalArgumentException("이름은 필수값 입니다");
		}

		if (height < 1) {
			throw new IllegalArgumentException("높이는 1 이상 입니다.");
		}

		if (StringUtil.isBlank(ladderGameResults)) {
			throw new IllegalArgumentException("결과 값은 필수값 입니다");
		}
	}

	private static LadderGameResults toLadderGameResults(String ladderGameResults) {
		return LadderGameResults.of(Arrays.asList(ladderGameResults.split(SEPARATOR)));
	}

	private static List<Person> toPersons(String names) {
		return Arrays.stream(names.split(","))
			.map(Person::new)
			.collect(Collectors.toList());
	}

	public List<Person> getPersons() {
		return persons;
	}

	public int personCount() {
		return persons.size();
	}

	public int getHeight() {
		return height;
	}

	public LadderGameResults getLadderGameResults() {
		return ladderGameResults;
	}
}
