package ladder.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.model.GameResults;
import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Name;
import ladder.model.Player;
import ladder.model.Players;

class LadderGameTest {

	@Test
	@DisplayName("사다리 라이들과 플레이어들을 입력하면 결과값을 반환한다.")
	public void startLadderGame() {
		Lines lines = new Lines(getLine());
		Players players = new Players("cross,pie,kim");
		GameResults gameResults = LadderGame.startLadderGame(lines, players);

		Player player1 = new Player(new Name("cross"));
		Player player2 = new Player(new Name("pie"));
		Player player3 = new Player(new Name("kim"));
		assertThat(gameResults.findResultOfPerson(player1)).extracting("position").containsExactly(0);
		assertThat(gameResults.findResultOfPerson(player2)).extracting("position").containsExactly(2);
		assertThat(gameResults.findResultOfPerson(player3)).extracting("position").containsExactly(1);
	}

	private List<Line> getLine() {
		List<Line> lines = new ArrayList<>();
		lines.add(new Line(getPoints()));
		return lines;
	}

	private List<Boolean> getPoints() {
		List<Boolean> points = new ArrayList<>();
		points.add(false);
		points.add(false);
		points.add(true);
		return points;
	}
}