package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LineTest {

	@Test
	void 선을_만들면_수직으로_연결된다() {
		// given
		Point point1 = Point.newInstance("철수");
		Point point2 = Point.newInstance();
		Point point3 = Point.newInstance();

		point1.connectPointVertically(point2);
		point2.connectPointVertically(point3);
		Line expectedLine = Line.of(Arrays.asList(point1, point2, point3));

		// when
		Line createdLine = Line.of("철수", 1);

		// then
		assertThat(createdLine).isEqualTo(expectedLine);
	}

}
