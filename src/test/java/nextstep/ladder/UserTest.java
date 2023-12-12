package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.User;

public class UserTest {

	@DisplayName("이름은 빈 값일 수 없습니다.")
	@Test
	void validate_is_not_blank() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> new User(" "))
			.withMessage("이름은 공백일 수 없습니다.");
	}

	@DisplayName("이름은 최대 길이 제한을 넘을 수 없습니다.")
	@Test
	void validate_is_under_max_length() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> new User("김수한무두루미와거북이"))
			.withMessage("사용자 이름의 최대길이는 5를 넘을 수 없습니다.");
	}
}
