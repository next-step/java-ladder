package ladder.domain;

import ladder.model.NameGoalPair;
import ladder.test_double.PredefinedStepProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderHeaderTest {


	private LadderHeader header;

	@BeforeEach
	void generateContext(){
		LadderFooter footer = new LadderFooter(Arrays.asList("1", "2", "3"));

		List<Boolean> steps = Arrays.asList(true, false, false, true); // |-| | |-|
		StepProvider provider = new PredefinedStepProvider(steps);
		LadderBody ladderBody = new LadderBody(3, 1, provider, footer);

		this.header = new LadderHeader(Arrays.asList("A", "B", "C"), ladderBody);
	}

	@ParameterizedTest
	@CsvSource(value = {"A,2", "B,1", "C,3"})
	void getGoal(String player, String expectGoal) {
		assertThat(header.getGoal(player)).isEqualTo(expectGoal);
	}

	@ParameterizedTest
	@CsvSource(value = {"A,2", "B,1", "C,3"})
	void getResults(String player, String expectGoal){
		List<NameGoalPair> results = header.getResult();

		assertThat(results).contains(new NameGoalPair(player, expectGoal));
	}
}