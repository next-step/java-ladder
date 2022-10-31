package ladder.dto;

import ladder.domain.LadderGameResults;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class InputDTO {

	public static final String SEPARATOR = ",";

	private final Persons persons;
	private final int height;
	private final LadderGameResults ladderGameResults;

	private InputDTO(Persons persons, int height, LadderGameResults ladderGameResults) {
		this.persons = persons;
		this.height = height;
		this.ladderGameResults = ladderGameResults;
	}

	public static InputDTO from(String names, int height, String ladderGameResults) {
		validate(names, height, ladderGameResults);

		Persons people = toPersons(names);
		LadderGameResults results = toLadderGameResults(ladderGameResults);

		if (people.size() != results.size()) {
			throw new IllegalArgumentException("참여자수와 결과 갯수는 같아야 합니다.");
		}

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
		String replaced = ladderGameResults.replace(" ", "");
		return LadderGameResults.of(Arrays.asList(replaced.split(SEPARATOR)));
	}

	private static Persons toPersons(String names) {
		List<Person> persons = new ArrayList<>();
		String[] tokens = names.split(SEPARATOR);
		for (int i = 0; i < tokens.length; i++) {
			persons.add(new Person(tokens[i], i));
		}

		return Persons.of(persons);
	}

	public Persons getPersons() {
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
