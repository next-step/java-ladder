package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderContextTest {

	@ParameterizedTest
	@CsvSource(value = {"A,2", "B,1", "C,3"})
	void getGoal(String player, String expectGoal) {
		List<Boolean> steps = Arrays.asList(true, false, false, true); // |-| | |-|
		StepProvider provider = new PredefinedStepProvider(steps);
		Ladder ladder = new Ladder(3, 1, provider);

		List<String> players = Arrays.asList("A", "B", "C");
		List<String> goals = Arrays.asList("1", "2", "3");
		LadderContext context = new LadderContext(players, goals, ladder);

		assertThat(context.getGoal(player)).isEqualTo(expectGoal);
	}
}