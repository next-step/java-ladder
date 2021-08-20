package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("이름을 입력하면 이름이 생성된다.")
	public void createName() {
		Name name = new Name("cross");

		assertThat(name).isEqualTo(new Name("cross"));
		assertThat(name.getName()).isEqualTo("cross");

		Name name2 = new Name("pie");

		assertThat(name2).isEqualTo(new Name("pie"));
		assertThat(name2.getName()).isEqualTo("pie");
	}

	@Test
	@DisplayName("이름에 빈값을입력하면 예외가 발생된다.")
	public void checkEmptyName() {
		assertThrows(IllegalArgumentException.class, () ->
			new Name("")
		);
	}

	@Test
	@DisplayName("이름이 6글자 이상이면 예외가 발생된다.")
	public void checkNameLimitLength() {
		assertThrows(IllegalArgumentException.class, () ->
			new Name("length")
		);
	}

	@Test
	@DisplayName("이름이 null 이상이면 예외가 발생된다.")
	public void checkNull() {
		assertThrows(IllegalArgumentException.class, () ->
			new Name(null)
		);
	}
}