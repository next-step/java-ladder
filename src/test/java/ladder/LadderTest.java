package ladder;

import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

	@DisplayName("높이와 사람 수를 입력하면 사다리를 생성한다.")
	@Test
	void testMethodNameHere() {
		// given
		int height = 5;
		int countOfPerson = 4;

		// when
		Ladder ladder = Ladder.createLadder(height, countOfPerson);

		// then
		assertThat(ladder.getHeight()).isEqualTo(5);
	}
}
