package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

	@DisplayName("채워진 좌표 개수를 검증한다.")
	@Test
	void test1() {
		assertThat(new Line(4).getPoints()).hasSize(3);
	}
}
