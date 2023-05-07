package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

	@DisplayName("이름을 생성한다.")
	@Test
	void test1() {
		assertThat(new Name("pobi")).isEqualTo(new Name("pobi"));
	}

	@DisplayName("이름 생성 예외 케이스 - 빈값")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name(""));
	}

	@DisplayName("이름 생성 예외 케이스 - 최대 글자수 초과")
	@Test
	void test3() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name("pobipo"));
	}
}
