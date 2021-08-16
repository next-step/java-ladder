package ladder.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.model.Height;
import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Players;

class LadderCreateTest {

	@Test
	@DisplayName("플에이어와 사디리 높이를 입력하면 라인들이 생성된다.")
	public void createLines() {
		Players players = new Players("aaa,bbb,ccc");
		Height height = new Height(3);

		Lines lines = DummyLadderCreate.createLadder(players, height);

		assertThat(lines.getLines().size()).isEqualTo(3);
		assertThat(lines.getLines()).containsExactly(new Line(getPoints()), new Line(getPoints()),
			new Line(getPoints()));
	}

	private List<Boolean> getPoints() {
		List<Boolean> points = new ArrayList<>();
		points.add(false);
		points.add(false);
		points.add(false);
		return points;
	}

	static class DummyLadderCreate {
		public static Lines createLadder(Players players, Height height) {
			return new Lines(IntStream.range(0, height.getHeight())
				.mapToObj(i -> new Line(createLinePoints(players)))
				.collect(Collectors.toList()));
		}

		private static List<Boolean> createLinePoints(Players players) {
			return getPoints(players.findPlayerCount());
		}

		private static List<Boolean> getPoints(int count) {
			return IntStream.range(0, count)
				.mapToObj(i -> false)
				.collect(Collectors.toList());
		}

	}

}