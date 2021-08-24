package nextstep.ladder.enums;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nextstep.ladder.exceptions.NotFoundLadderStatusException;

class LadderStatusTest {

	@DisplayName("사다리 연결 상태 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1=true", "2=false"}, delimiter = '=')
	void ladderStatusTest(int value, boolean expected) {
		LadderStatus ladderStatus = LadderStatus.of(value);

		assertThat(ladderStatus.equals(LadderStatus.LINKED)).isEqualTo(expected);
	}

	@DisplayName("사다리 연결 상태 검증 테스트")
	@Test
	void ladderStatusExceptionTest() {
		assertThatExceptionOfType(NotFoundLadderStatusException.class)
			.isThrownBy(() -> LadderStatus.of(3))
			.withMessage("사다리 상태 코드가 잘못되었습니다.");
	}
}