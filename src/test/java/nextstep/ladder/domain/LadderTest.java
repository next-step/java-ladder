package nextstep.ladder.domain;

import static nextstep.ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

	@DisplayName("사다리 게임을 실행 후 결과를 확인한다.")
	@Test
	void play() {
		Players players = Players.from("pobi,crong,honux,jk");
		Ladder ladder = new Ladder(players, createLines());
		Result result = ladder.play();

		assertThat(result.of(new Player("pobi"))).isZero();
		assertThat(result.of(new Player("crong"))).isEqualTo(2);
		assertThat(result.of(new Player("honux"))).isEqualTo(3);
		assertThat(result.of(new Player("jk"))).isEqualTo(1);
	}

	/*
		player	0     1     2     3
				|-----|     |-----|
				|-----|     |     |
				|     |-----|     |
		end		0  	  1     2     3
		player	0	  3	    1     2
	 */
	private List<Line> createLines() {
		List<Line> lines = new ArrayList<>();
		lines.add(new Line(Arrays.asList(right(0), left(1), right(2), left(3))));
		lines.add(new Line(Arrays.asList(right(0), left(1), straight(2), straight(3))));
		lines.add(new Line(Arrays.asList(straight(0), right(1), left(2), straight(3))));
		return lines;
	}

}