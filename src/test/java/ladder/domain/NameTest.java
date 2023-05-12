package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

	@DisplayName("유효한 문자열로 이름 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		assertThat(new Name("pobi")).isEqualTo(new Name("pobi"));
	}

	@DisplayName("빈 문자열로 이름 생성 시, 예외를 던진다.")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name(""));
	}

	@DisplayName("5자 초과 문자열로 이름 생성 시, 예외를 던진다.")
	@Test
	void test3() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name("pobipo"));
	}

	@DisplayName("`all` 문자열로 이름 생성 시, 예외를 던진다.")
	@Test
	void test4() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name("all"));
	}
}
