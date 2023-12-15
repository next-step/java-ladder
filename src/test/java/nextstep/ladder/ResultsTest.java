package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Width;

public class ResultsTest {
	@DisplayName("Results 객체 생성시 콤마를 기준으로 당첨 결과를 나눈다.")
	@Test
	void validate_create_results() {
		Results results = new Results("치킨,우동,김밥", new Width(3));
		assertThat(results.values())
			.isEqualTo(List.of(
				new Result("치킨"),
				new Result("우동"),
				new Result("김밥")
			));
	}

	@DisplayName("참가자 수와 당첨 결과의 수가 같아야 한다.")
	@Test
	void validate_is_same_size() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Results("치킨,우동,김밥", new Width(4)))
			.withMessage("참가자 수와 당첨 결과 수는 같아야합니다.");
	}
}
