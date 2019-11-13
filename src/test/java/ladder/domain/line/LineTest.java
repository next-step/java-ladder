package ladder.domain.line;

import ladder.domain.Direction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LineTest {

	@Test
	void 선을_만들면_수평으로_연결된다() {
		// |-----|     |
		// given
		String[] names = new String[]{"사람1", "사람2", "사람3"};

		// when
		Line line = new MiddleLine(() -> true, names);

		// then
		assertThat(line.getPoint(0).hasConnection(Direction.HORIZONTAL)).isTrue();
		assertThat(line.getPoint(1).hasConnection(Direction.HORIZONTAL)).isFalse();
	}

	@Test
	void 수직으로_선이_연결된다() {
		// |-----|
		// |-----|
		// given
		String[] names = new String[]{"사람1", "사람2"};
		Line upperLine = new MiddleLine(() -> true, names);
		Line lowerLine = new MiddleLine(() -> true, names);

		// when
		upperLine.connectLinesVertically(lowerLine);

		// then
		assertThat(upperLine.getPoint(0).hasConnection(Direction.VERTICAL)).isTrue();
		assertThat(upperLine.getPoint(1).hasConnection(Direction.VERTICAL)).isTrue();
		assertThat(lowerLine.getPoint(0).hasConnection(Direction.VERTICAL)).isFalse();
		assertThat(lowerLine.getPoint(1).hasConnection(Direction.VERTICAL)).isFalse();
	}

}
