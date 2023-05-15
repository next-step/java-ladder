package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrossesTest {

	@DisplayName("유효한 값으로 크로스 목록 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Crosses crosses = Crosses.of(true, false, true);
		assertThat(crosses).isEqualTo(Crosses.of(true, false, true));
	}

	@DisplayName("이동 후, 인덱스를 반환한다.")
	@Test
	void test2() {
		Crosses crosses = Crosses.of(true, false, true);

		assertThat(crosses.move(0)).isEqualTo(1);
		assertThat(crosses.move(1)).isEqualTo(0);
		assertThat(crosses.move(2)).isEqualTo(3);
		assertThat(crosses.move(3)).isEqualTo(2);
	}
}
