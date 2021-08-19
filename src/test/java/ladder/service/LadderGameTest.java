package ladder.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.model.GameResults;
import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Players;
import ladder.model.Point;

class LadderGameTest {

	@Test
	@DisplayName("사다리 라이들과 플레이어들을 입력하면 결과값을 반환한다.")
	public void startLadderGame() {
		Lines lines = new Lines(getLine());
		Players players = new Players("cross,pie,kim");
		GameResults gameResults = LadderGame.startLadderGame(lines, players);

		assertThat(gameResults.findResultOfPerson("cross")).extracting("position").containsExactly(0);
		assertThat(gameResults.findResultOfPerson("pie")).extracting("position").containsExactly(2);
		assertThat(gameResults.findResultOfPerson("kim")).extracting("position").containsExactly(1);
	}

	private List<Line> getLine() {
		List<Line> lines = new ArrayList<>();
		lines.add(new Line(getPoints()));
		return lines;
	}

	private List<Point> getPoints() {
		List<Point> points = new ArrayList<>();
		points.add(new Point(false));
		points.add(new Point(true));
		points.add(new Point(false));
		return points;
	}
}