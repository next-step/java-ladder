package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Cross;
import ladder.domain.InputResult;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.Point;

public class LadderResultTest {

	private Ladder ladder;
	private Players players;

	@BeforeEach
	void setUp() {

		Line line1 = new Line(countOfPerson -> {
			Point first = Point.first(true);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(false)));
			crosses.add(new Cross(2, first.next(false).next(true)));
			crosses.add(new Cross(3, first.next(false).next(true).last()));
			return crosses;
		}, 4);

		Line line2 = new Line(countOfPerson -> {
			Point first = Point.first(false);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(true)));
			crosses.add(new Cross(2, first.next(true).next(false)));
			crosses.add(new Cross(3, first.next(true).next(false).last()));
			return crosses;
		}, 4);

		Line line3 = new Line(countOfPerson -> {
			Point first = Point.first(true);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(false)));
			crosses.add(new Cross(2, first.next(false).next(false)));
			crosses.add(new Cross(3, first.next(false).next(false).last()));
			return crosses;
		}, 4);

		Line line4 = new Line(countOfPerson -> {
			Point first = Point.first(false);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(true)));
			crosses.add(new Cross(2, first.next(true).next(false)));
			crosses.add(new Cross(3, first.next(true).next(false).last()));
			return crosses;
		}, 4);

		Line line5 = new Line(countOfPerson -> {
			Point first = Point.first(true);
			List<Cross> crosses = new ArrayList<>();
			crosses.add(new Cross(0, first));
			crosses.add(new Cross(1, first.next(false)));
			crosses.add(new Cross(2, first.next(false).next(true)));
			crosses.add(new Cross(3, first.next(false).next(true).last()));
			return crosses;
		}, 4);

		List<Line> lines = new ArrayList<>();
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
		lines.add(line4);
		lines.add(line5);

		ladder = new Ladder(lines);

		players = new Players("pobi,honux,crong,jk");
	}

	@Test
	@DisplayName("결과 계산")
	void calculateResultTest() {
		InputResult inputResult = new InputResult("꽝,5000,꽝,3000", players.size());
		LadderResult ladderResult = new LadderResult(ladder, players, inputResult);
		assertThat(ladderResult.getResult("pobi")).isEqualTo("꽝");
		assertThat(ladderResult.getResult("honux")).isEqualTo("3000");
		assertThat(ladderResult.getResult("crong")).isEqualTo("꽝");
		assertThat(ladderResult.getResult("jk")).isEqualTo("5000");
	}
}
