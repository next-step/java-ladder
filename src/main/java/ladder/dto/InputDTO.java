package ladder.dto;

import ladder.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class InputDTO {

	private List<Person> persons;
	private int height;

	public InputDTO(String names, int height) {
		this.persons = toPersons(names);
		this.height = height;
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
