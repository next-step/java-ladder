package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderContextTest {

	private Ladder ladder;

	private LadderContext context;

	@BeforeEach
	void generateContext(){
		List<Boolean> steps = Arrays.asList(true, false, false, true); // |-| | |-|
		StepProvider provider = new PredefinedStepProvider(steps);
		this.ladder = new Ladder(3, 1, provider);

		List<String> players = Arrays.asList("A", "B", "C");
		List<String> goals = Arrays.asList("1", "2", "3");
		this.context = new LadderContext(players, goals, ladder);
	}

	@ParameterizedTest
	@CsvSource(value = {"A,2", "B,1", "C,3"})
	void getGoal(String player, String expectGoal) {
		assertThat(context.getGoal(player)).isEqualTo(expectGoal);
	}

	@Test
	void getResults(){
		List<NameGoalPair> results = context.getResult();

		assertThat(results).contains(new NameGoalPair("A", "2"));
	}
}