package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Participant;

public class ParticipantTest {
	@Test
	@DisplayName("이름이 5자를 초과할 수 없습니다.")
	void test() {
		assertThatThrownBy(() -> {
			new Participant("5자초과이름");
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
