package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserTest {

	@DisplayName(value = "입력한 이름 유효성 검사 성공 테스트")
	@Test
	void validateSuccessUserName() {
		assertThat(new User("dami")).hasFieldOrPropertyWithValue("name", "dami");
	}

	@DisplayName(value = "입력한 이름 유효성 검사 실패 테스트")
	@Test
	void validateFailUserName() {
		assertThatIllegalArgumentException().isThrownBy(() -> new User("mongzza"))
				.withMessage("참여자 이름은 최대 5자 까지 입력 가능합니다.");
	}

}