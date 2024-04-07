package ladder.domain.ladder;

import ladder.domain.ladder.point.RandomPointAdd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
	@DisplayName("사용자수의 -1 만큼 라인이 생긴다.")
	@Test
	void makeLineCountOfPersonMinusOne() {
		// given
		int countOfPerson = 4;

		// when
		Line line = Line.createPointLine(countOfPerson, new RandomPointAdd());

		// then
		assertThat(line.size()).isEqualTo(3);
	}
}
