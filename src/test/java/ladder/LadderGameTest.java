package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.playing.LadderGame;

public class LadderGameTest {

	@Test
	public void ladderGameTest() {
		Line line1 = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line2 = Line.of(Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Line line3 = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line4 = Line.of(Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Line line5 = Line.of(Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));

		Ladder ladder = Ladder.of(Arrays.asList(line1, line2, line3, line4, line5));

		int line1Result = LadderGame.play(0, ladder);
		int line2Result = LadderGame.play(1, ladder);
		int line3Result = LadderGame.play(2, ladder);
		int line4Result = LadderGame.play(3, ladder);
		int line5Result = LadderGame.play(4, ladder);

		assertThat(line1Result).isEqualTo(3);
		assertThat(line2Result).isEqualTo(1);
		assertThat(line3Result).isEqualTo(2);
		assertThat(line4Result).isEqualTo(0);
		assertThat(line5Result).isEqualTo(4);

	}
}
