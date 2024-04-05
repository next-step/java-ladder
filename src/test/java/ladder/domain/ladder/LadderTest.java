package ladder.domain.ladder;

import ladder.domain.result.Results;
import ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

	@DisplayName("높이와 사람과 결과값을 입력하면 사다리를 생성한다.")
	@Test
	void testMethodNameHere() {
		// given
		int height = 5;
		Users users = new Users("a,b,c,d,e");
		Results results = new Results("꽝,5000,꽝,3000,꽝", 5);


		// when
		Ladder ladder = Ladder.createLadder(Height.createHeight(height), users, results);

		// then
		assertThat(ladder.getHeight()).isEqualTo(5);
	}
}
