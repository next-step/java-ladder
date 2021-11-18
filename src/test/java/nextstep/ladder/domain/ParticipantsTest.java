package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
	@DisplayName("배열로 부터 생성된 Participants size 를 검증한다.")
	@Test
	void size() {
		// given
		String[] names = {"a", "b", "c", "d", "e"};

		// when
		Participants participants = Participants.create(names);

		// then
		assertThat(participants.size()).isEqualTo(names.length);
	}
}
