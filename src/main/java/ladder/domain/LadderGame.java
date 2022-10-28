package ladder.domain;

import ladder.dto.InputDTO;

/**
 * Created by seungwoo.song on 2022-10-25
 */
public class LadderGame {

	public Persons start(Ladder ladder, InputDTO inputDTO) {
		Persons persons = inputDTO.getPersons();

		for (LadderRow row : ladder) {
			persons.stream().forEach(row::movePerson);
		}

		return persons;
	}
}
