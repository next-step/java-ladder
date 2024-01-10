package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.util.ManualPointGenerator;
import ladder.util.PointGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
	private static final PointGenerator POINT_GENERATOR = new ManualPointGenerator();

	@Test
	@DisplayName("사다리가 사람수만큼 전략에 맞춰 생성되는지 확인")
	void 사다리_한_줄_생성확인() {
		List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		People people = new People(nameList);
		Direction direction = Direction.first(true);
		List<Direction> result = new ArrayList<>() {{
			add(direction);
			add(direction.next(false));
			add(direction.next(false).next(true));
			add(direction.end());
		}};

		Line ladderLine = Line.of(people, POINT_GENERATOR);

		assertThat(ladderLine.draw()).hasSize(people.count()).isEqualTo(result);
	}
}
