package nextstep.domain;

import domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PointStatusRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

	private Line line;
	private Integer personCount = 3;
	private PointStatusRandomGenerator generator;

	@BeforeEach
	void init() {
		generator = new PointStatusRandomGenerator();
		line = new Line(personCount, generator);
	}

	@DisplayName("가로 라인의 크기를 테스트")
	@Test
	void test_line_size() {
		assertThat(line.size()).isEqualTo(personCount - 1);
	}
}
