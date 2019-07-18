package ladder.domain;

import ladder.RandomStepProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

	private List<String> playerNames = Arrays.asList("A", "B", "C");
	private List<String> goals = Arrays.asList("10", "20", "30");
	private StepProvider provider = new RandomStepProvider();

	@DisplayName("최소 높이보다 낮게 지정된 경우")
	@Test
	void builderWithZeroHeight() {
		Ladder.Builder builder = Ladder.builder()
				.setPlayerNames(playerNames)
				.setGoals(goals)
				.setStepProvider(provider)
				.setHeight(0);


		assertThatExceptionOfType(IllegalStateException.class)
			.isThrownBy(() -> builder.build());

	}

	@DisplayName("최소 높이보다 낮게 지정된 경우")
	@Test
	void builderWithDifferentPlayerAndGoal() {
		Ladder.Builder builder = Ladder.builder()
				.setPlayerNames(playerNames)
				.setGoals(Arrays.asList("one", "two"))
				.setStepProvider(provider);


		assertThatExceptionOfType(IllegalStateException.class)
			.isThrownBy(() -> builder.build());

	}
}