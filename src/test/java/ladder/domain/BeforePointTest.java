package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BeforePointTest {

	@DisplayName("이전 좌표 생성")
	@ValueSource(booleans = {true, false})
	@ParameterizedTest
	void test1(boolean input) {
		assertThat(new BeforePoint(input)).isEqualTo(new BeforePoint(input));
	}
}
