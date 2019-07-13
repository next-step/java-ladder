package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

	@Test
	void addRow() {
		// Arrange
		Ladder ladder = new Ladder(5, 2, () -> new Random().nextBoolean());
		assertThat(ladder.getRows().count()).isEqualTo(2);
	}

}