package ladder.domain;

import ladder.test_double.PredefinedStepProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LadderBodyTest {

	@Test
	void generateLadder() {
		// Arrange
		LadderBody ladderBody = new LadderBody(5, 2, () -> new Random().nextBoolean(), null);

		// Action & Assertion
		assertThat(ladderBody.getNodes().size()).isEqualTo(10);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,3", "1,1", "2,0", "3,4", "4,2"})
	void getResult(int startRail, String expectGoal){
		List<Boolean> steps = new ArrayList<>();
		steps.addAll(Arrays.asList(true, false, false, true)); 	// |-| | |-|
		steps.addAll(Arrays.asList(false, true, false, false));	// | |-| | |
		steps.addAll(Arrays.asList(true, false, true, false));	// |-| |-| |
		StepProvider provider = new PredefinedStepProvider(steps);
		LadderFooter footer = new LadderFooter(Arrays.asList("0", "1", "2", "3", "4"));
		LadderBody ladderBody = new LadderBody(5, 3, provider, footer);

		// Action
		String goal = ladderBody.getResult(startRail);

		// Assertion
		assertThat(goal).isEqualTo(expectGoal);
	}
}