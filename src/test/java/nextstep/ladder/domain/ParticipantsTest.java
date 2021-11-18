package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
	@DisplayName("List 로 부터 생성된 Participants size 를 검증한다.")
	@Test
	void size() {
		// given
		List<String> names = Arrays.asList("a", "b", "c", "d", "e");

		// when
		Participants participants = Participants.createWithNames(names);

		// then
		assertThat(participants.size()).isEqualTo(names.size());
	}

	@DisplayName("Participants list 가 비어있을 경우 예외 발생")
	@Test
	void validateSize() {
		// given
		List<String> emptyNames = Collections.emptyList();

		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Participants.createWithNames(emptyNames));
	}
}
