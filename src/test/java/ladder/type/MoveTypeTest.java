package ladder.type;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveTypeTest {

	@DisplayName("왼쪽,오른쪽,아래로 이동 시 다음 인덱스를 반환한다.")
	@Test
	void test1() {
		assertThat(MoveType.of(DirectionType.LEFT).move(3)).isEqualTo(2);
		assertThat(MoveType.of(DirectionType.RIGHT).move(3)).isEqualTo(4);
		assertThat(MoveType.of(DirectionType.DOWN).move(3)).isEqualTo(3);
	}
}
