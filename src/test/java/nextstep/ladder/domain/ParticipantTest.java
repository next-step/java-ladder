package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.exception.ParticipantNameSizeException;

class ParticipantTest {
	@DisplayName("참가자 이름이 5자가 넘을 경우 예외 발생")
	@Test
	void createWithInvalidName() {
		// given
		String invalidName = "123456";

		// when then
		assertThatExceptionOfType(ParticipantNameSizeException.class)
			.isThrownBy(() -> Participant.create(invalidName));
	}
}
