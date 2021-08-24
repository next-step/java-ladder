package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.enums.LadderStatus;
import nextstep.ladder.exceptions.LadderStatusAddFailureException;

class LadderTest {

	@DisplayName("이전 사다리 연결된 상태이면 연결 불가")
	@Test
	void generateLineExceptionTest() {
		assertThatExceptionOfType(LadderStatusAddFailureException.class)
			.isThrownBy(() -> {
				Ladder.of((v) -> {
					Line line = new Line();

					for (int i = 0; i < 3; i++) {
						line.addLadderStatus(LadderStatus.LINKED);
					}

					return line;
				}, 5, 5);
			})
			.withMessage("이전 사다리가 연결된 상태입니다.");
	}
}