package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

	@DisplayName("높이 생성")
	@Test
	void test1() {
		assertThat(new Height(5)).isEqualTo(new Height(5));
	}

	@DisplayName("높이 예외 케이스")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Height(0));
	}
}
