package nextstep.ladder.domain.strategy;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineRandomStrategyTest {
	@DisplayName(value = "랜덤 포인트 생성 ")
	@Test
	void randomStrategy() {
		LineStrategy lineStrategy = new LineRandomStrategy();

		Set<Boolean> randomPoints = Stream.generate(lineStrategy::createPoint)
			.limit(20)
			.collect(Collectors.toSet());

		assertThat(randomPoints).containsAll(Arrays.asList(true, false));
	}
}