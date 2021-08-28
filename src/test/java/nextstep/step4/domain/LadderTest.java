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
		Players players = Players.from("pobi,crong,honux,jk");
		Prizes prizes = Prizes.from("꽝,1000,2000,3000");
		Ladder ladder = new Ladder(players, prizes, createLines());
		Result result = ladder.play();

		assertThat(result.of(new Player("pobi"))).isEqualTo(new Prize("2000"));
		assertThat(result.of(new Player("crong"))).isEqualTo(new Prize("꽝"));
		assertThat(result.of(new Player("honux"))).isEqualTo(new Prize("1000"));
		assertThat(result.of(new Player("jk"))).isEqualTo(new Prize("3000"));
	}

	/*
		player	 pobi crong honux    jk
					|     |     |-----|
					|-----|     |-----|
					|     |-----|     |
		prize      꽝  1000  2000  3000
		player	crong honux  pobi    jk
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
