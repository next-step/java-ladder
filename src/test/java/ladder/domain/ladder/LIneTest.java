package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LIneTest {
	@DisplayName("사용자수의 -1 만큼 라인이 생긴다.")
	@Test
	void makeLineCountOfPersonMinusOne() {
		// given
		int countOfPerson = 4;

		// when
		Line line = Line.createLine(countOfPerson);

		// then
		assertThat(line.size()).isEqualTo(3);
	}
}
