package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

	@Test
	void generateLadder() {
		// Arrange
		Ladder ladder = new Ladder(5, 2, () -> new Random().nextBoolean());

		// Action & Assertion
		assertThat(ladder.getRows().count()).isEqualTo(2);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,3", "1,1", "2,0", "3,4", "4,2"})
	void getResult(int startRail, int expectGoal){
		List<Boolean> steps = new ArrayList<>();
		steps.addAll(Arrays.asList(true, false, false, true)); 	// |-| | |-|
		steps.addAll(Arrays.asList(false, true, false, false));	// | |-| | |
		steps.addAll(Arrays.asList(true, false, true, false));	// |-| |-| |
		StepProvider provider = new PredefinedStepProvider(steps);
		Ladder ladder = new Ladder(5, 3, provider);

		// Action
		int goalIndex = ladder.getResult(startRail);

		// Assertion
		assertThat(goalIndex).isEqualTo(expectGoal);
	}
}