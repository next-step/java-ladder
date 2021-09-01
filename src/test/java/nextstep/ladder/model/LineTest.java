package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.enums.LadderStatus;
import nextstep.ladder.exceptions.LadderStatusAddFailureException;

class LineTest {

	@DisplayName("이전 사다리 연결된 상태이면 연결 불가")
	@Test
	void addLadderStatusTest() {
		Line line = new Line();

		assertThatExceptionOfType(LadderStatusAddFailureException.class)
			.isThrownBy(() -> {
				line.addLadderStatus(LadderStatus.LINKED);
				line.addLadderStatus(LadderStatus.LINKED);
			})
			.withMessage("이전 사다리가 연결된 상태입니다.");
	}
}