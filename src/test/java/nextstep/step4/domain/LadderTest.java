package nextstep.step4.domain;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

	@DisplayName("사다리 게임을 실행한 후 결과를 반환한다.")
	@Test
	void play() {
		Ladder ladder = new Ladder(4, createLines());
		Result result = ladder.play();
		assertThat(result.of(0)).isEqualTo(2);
		assertThat(result.of(1)).isEqualTo(0);
		assertThat(result.of(2)).isEqualTo(1);
		assertThat(result.of(3)).isEqualTo(3);
	}

	/*
		player	0     1     2     3
				|     |     |-----|
				|-----|     |-----|
				|     |-----|     |
		end		0  	  1     2     3
		player	1	  2	    0     3
	 */
	private List<Line> createLines() {
		List<Line> lines = new ArrayList<>();
		lines.add(new Line(Arrays.asList(straight(0), straight(1), right(2), left(3))));
		lines.add(new Line(Arrays.asList(right(0), left(1), right(2), left(3))));
		lines.add(new Line(Arrays.asList(straight(0), right(1), left(2), straight(3))));
		return lines;
	}

	private Point left(int position) {
		return new Point(position, Direction.of(TRUE, FALSE));
	}

	private Point straight(int position) {
		return new Point(position, Direction.of(FALSE, FALSE));
	}

	private Point right(int position) {
		return new Point(position, Direction.of(FALSE, TRUE));
	}

}
