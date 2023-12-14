package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.User;

public class ResultsTest {
	@DisplayName("Results 객체 생성시 콤마를 기준으로 당첨 결과를 나눈다.")
	@Test
	void validate_create_results() {
		Participants participants = new Participants("치킨,우동,김밥");
		assertThat(participants.values())
			.isEqualTo(List.of(
				new User("치킨"),
				new User("우동"),
				new User("김밥")
			));
	}
}
