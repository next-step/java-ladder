package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by seungwoo.song on 2022-10-17
 */
class PersonTest {

	@Test
	void 생성성공() {
		Person person = new Person("12345");

		assertThat(person.getName()).isEqualTo("12345");
	}

	@Test
	void 생성실패_이름6글자() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Person("123456"));
	}
}