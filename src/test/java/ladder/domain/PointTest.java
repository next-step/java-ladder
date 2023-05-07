package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PointTest {

	@DisplayName("좌표 생성")
	@ValueSource(booleans = {true, false})
	@ParameterizedTest
	void test1(boolean input) {
		assertThat(Point.of(input)).isEqualTo(Point.of(input));
	}
}
