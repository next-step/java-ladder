package step3.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Line;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
	private static Line line;

	@BeforeAll
	static void createLine() {
		line = new Line(2);
	}

	@DisplayName(value = "사다리 라인이 연속으로 생성되지 않는지 테스트")
	@Test
	void getPoints() {
		List<Boolean> expected = Arrays.asList(true, true);
		assertThat(line.getPoints()).doesNotContainSequence(expected);
	}
}
