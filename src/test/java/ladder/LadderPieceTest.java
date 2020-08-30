package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ladder.domain.line.Line;
import ladder.domain.playing.LadderPiece;

public class LadderPieceTest {

	@Test
	public void ladderPieceTest() {
		Line line = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		int position0 = LadderPiece.move(0, line);
		int position1 = LadderPiece.move(1, line);
		int position2 = LadderPiece.move(2, line);
		int position3 = LadderPiece.move(3, line);

		assertThat(position0).isEqualTo(1);
		assertThat(position1).isEqualTo(0);
		assertThat(position2).isEqualTo(3);
		assertThat(position3).isEqualTo(2);
	}
}
