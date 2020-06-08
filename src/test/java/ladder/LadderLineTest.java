package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

	@DisplayName("사람 수만큼의 좌표를 갖는다")
	@Test
	void ladderLinePointsSize() {
		LadderLine ladderLine = new LadderLine(5);
		LadderLinePoints ladderLinePoints = ladderLine.getLadderLinePoints();

		assertThat(ladderLinePoints.size()).isEqualTo(5);
	}
}