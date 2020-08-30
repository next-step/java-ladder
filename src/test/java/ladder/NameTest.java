package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Name;

public class NameTest {
	@Test
	public void longNameExceptionTest() {
		assertThatThrownBy(() -> Name.of("pororo"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름은 5글자 이내로 입력해주세요.");
	}

	@Test
	public void nameToStringTest() {
		assertThat(Name.of("John").toString()).isEqualTo("John");
	}

	@Test
	public void nameEqualsTest() {
		assertThat(Name.of("John")).isEqualTo(Name.of("John"));
	}
}
