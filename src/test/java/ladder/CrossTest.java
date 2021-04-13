package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.Cross;
import ladder.domain.Point;

public class CrossTest {

	@Test
	void right() {
		Point right = Point.first(true);
		Cross cross = new Cross(1, right);
		assertThat(cross.move()).isEqualTo(2);
	}

	@Test
	void left() {
		Point left = Point.first(true).last();
		Cross cross = new Cross(1, left);
		assertThat(cross.move()).isEqualTo(0);
	}

	@Test
	void pass() {
		Point pass = Point.first(false).last();
		Cross cross = new Cross(1, pass);
		assertThat(cross.move()).isEqualTo(1);
	}
}
