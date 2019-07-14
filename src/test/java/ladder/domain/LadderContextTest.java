package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderContextTest {

	@Test
	void getGoal() {
		List<Boolean> steps = Arrays.asList(true, false, false, true); // |-| | |-|
		StepProvider provider = new PredefinedStepProvider(steps);
		Ladder ladder = new Ladder(5, 1, provider);

		List<String> players = Arrays.asList("A", "B", "C", "D", "E");
		List<String> goals = Arrays.asList("1", "2", "3", "4", "5");
		LadderContext context = new LadderContext(players, goals, ladder);

		assertThat(context.getGoal("A")).isEqualTo("2");
	}
}