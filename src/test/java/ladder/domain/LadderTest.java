package ladder.domain;

import ladder.exception.DifferentRailCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderTest {



	@Test
	void addRow() {
		// Arrange
		Ladder ladder = new Ladder();

		HorizontalStepList rowOne = new HorizontalStepList(5, () -> new Random().nextBoolean());
		ladder.addRow(rowOne);

		HorizontalStepList rowTwo = new HorizontalStepList(5, () -> new Random().nextBoolean());
		ladder.addRow(rowTwo);

		assertThat(ladder.height()).isEqualTo(2);
	}

	@DisplayName("개수가 다른 가로열 추가 시도")
	@Test
	void addRowWithDifferentRails() {
		// Arrange
		Ladder ladder = new Ladder();

		HorizontalStepList fiveRailsRow = new HorizontalStepList(5, () -> new Random().nextBoolean());
		ladder.addRow(fiveRailsRow);

		HorizontalStepList threeRailsRow = new HorizontalStepList(3, () -> new Random().nextBoolean());

		// Action & Assertion
		assertThatExceptionOfType(DifferentRailCountException.class)
				.isThrownBy(() -> {
					ladder.addRow(threeRailsRow);
				});
	}

	private static StepProvider getPredefineStepProviderForFiveRails(){
		return new PredefinedStepProvider(Arrays.asList(true, false, false, true));
	}
}