package ladder.dto;

import ladder.domain.LadderGameResults;
import ladder.domain.Person;

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

	public InputDTO(String names, int height, String ladderGameResults) {
		this.persons = toPersons(names);
		this.height = height;
		this.ladderGameResults = toLadderGameResults(ladderGameResults);
	}

	private LadderGameResults toLadderGameResults(String ladderGameResults) {
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

	public int getHeight() {
		return height;
	}
}
