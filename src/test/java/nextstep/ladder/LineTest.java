package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Line;

public class LineTest {

	@Test
	@DisplayName("사람의 수만큼 블록을 생성, 사람 수는 1보다 커야함")
	void test() {
		Line line = new Line(5);

		assertThat(line.blocks().size()).isEqualTo(5);

		assertThatThrownBy(() -> {
			new Line(1);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
