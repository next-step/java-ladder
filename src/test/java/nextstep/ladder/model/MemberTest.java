package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

	@DisplayName("Member의 Name이 5글자가 넘어가면 예외 발생")
	@Test
	void memberNameValidTest() {
		assertThatExceptionOfType(MemberValidException.class)
			.isThrownBy(() -> new Member("testtest"))
			.withMessage("참여자 이름은 5글자를 넘길수 없습니다.");
	}
}