package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

	@DisplayName("참가할 사람 수 예외 케이스")
	@Test
	void test1() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(0, 5));
	}

	@DisplayName("높이 예외 케이스")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(4, 0));
	}
}
