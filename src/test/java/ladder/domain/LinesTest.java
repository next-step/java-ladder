package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.util.ManualPointGenerator;
import ladder.util.PointGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinesTest {
	private static final PointGenerator POINT_GENERATOR = new ManualPointGenerator();

	@Test
	@DisplayName("원하는 사다리 길이 만큼 사다리가 생성되는지 확인")
	void 사다리_길이_확인() {
		List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		People people = new People(nameList);
		Height heightCount = new Height(5);

		Lines ladder = Lines.of(people, heightCount, POINT_GENERATOR);

		assertThat(ladder.line()).hasSize(5);
	}
}
