package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

import ladder.domain.line.LadderLine;

public class LadderLineTest {

	@Test
	public void init() {
		int sizeOfPerson = 5;
		LadderLine ladderLine = LadderLine.init(sizeOfPerson);
		assertThat(ladderLine.getWidth()).isEqualTo(sizeOfPerson);
	}

	@Test
	public void move() {
		LadderLine ladderLine = LadderLine.init(2);
		assertThat(ladderLine.hasNext()).isTrue();
	}
}
