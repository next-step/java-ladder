package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Participants;

public class ParticipantsTest {
	
	@Test
	@DisplayName(",를 기준으로 이름 나누기")
	void test() {
		String test = "pobi,honux,crong,jk";
		Participants participants = new Participants(test);

		assertThat(participants.names().size()).isEqualTo(4);
	}
}
