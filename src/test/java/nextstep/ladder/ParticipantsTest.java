package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.User;

public class ParticipantsTest {
	@DisplayName("participants 객체 생성시 콤마를 기준으로 참가자들을 나눈다.")
	@Test
	void validate_create_participants() {
		Participants participants = new Participants("김,광,현");
		assertThat(participants.values())
			.isEqualTo(List.of(
			new User("김"),
			new User("광"),
			new User("현")
		));
	}
}
