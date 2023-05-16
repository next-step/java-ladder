package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrossTest {

	@DisplayName("왼쪽으로 이동한다.")
	@Test
	void test1() {
		Cross cross = new Cross(1, Point.first(true).last());
		assertThat(cross.move()).isEqualTo(0);
	}

	@DisplayName("오른쪽으로 이동한다.")
	@Test
	void test2() {
		Cross cross = new Cross(0, Point.first(true));
		assertThat(cross.move()).isEqualTo(1);
	}

	@DisplayName("아래로 이동한다.")
	@Test
	void test3() {
		Cross cross = new Cross(0, Point.first(false).next(false));
		assertThat(cross.move()).isEqualTo(0);
	}
}
