package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonsTest {
	@DisplayName("배열로 부터 생성된 Persons size 를 검증한다.")
	@Test
	void size() {
		// given
		String[] names = {"a", "b", "c", "d", "e"};

		// when
		Persons persons = Persons.create(names);

		// then
		assertThat(persons.size()).isEqualTo(names.length);
	}
}
