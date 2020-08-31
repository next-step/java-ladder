package step2.domain.ladder;

import org.junit.jupiter.api.Test;
import step2.exception.LadderGameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {

	@Test
	void constructionTest() {
		int givenHeight = 2;
		assertThat(new LadderHeight(givenHeight)).isEqualTo(new LadderHeight(givenHeight));
	}

	@Test
	void constructionFailTest() {
		int givenHeight = 0;
		assertThrows(LadderGameException.class, () -> new LadderHeight(givenHeight));
	}

}
