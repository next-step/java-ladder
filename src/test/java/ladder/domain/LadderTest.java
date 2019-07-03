package ladder.domain;

import ladder.exception.DifferentRailCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

	@DisplayName("개수가 다른 가로열 추가 시도")
	@Test
	void addRowWithDifferentRails() {
		// Arrange
		Ladder ladder = new Ladder();

		HorizontalStepList fiveRailsRow = new HorizontalStepList(5, getPredefineStepProviderForFiveRails());
		ladder.addRow(fiveRailsRow);

		HorizontalStepList threeRailsRow = new HorizontalStepList(3, getPredefineStepProviderForFiveRails());

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