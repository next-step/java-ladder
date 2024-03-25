package ladder;

import ladder.domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
	@DisplayName("사용자의 이름길이 만큼 사다리의 넓이가 결정된다.")
	@Test
	void makeLineWidthByUserNameLength() {
		// given
		String userName = "pobi";

		// when
		Line line = Line.createLine(userName.length(), 0);

		// then
		assertThat(line.getWidth()).isEqualTo(4);
	}
}
