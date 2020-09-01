package ladder;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;

public class LineTest {

	@Test
	public void lineCreateTest() {
		int countOfPerson = 4;
		Line line = Line.of(countOfPerson);
		assertThat(line).isNotNull();
	}

	@Test
	public void radderCrateTest() {
		int height = 5;
		int countOfPerson = 4;
		Ladder ladder = Ladder.of(IntStream.range(0, height)
										   .mapToObj(i -> Line.of(countOfPerson))
										   .collect(toList()));

		assertThat(ladder).isNotNull();
	}

	@Test
	public void nextPointTest() {
		Line line = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

		assertThat(line.next()).isEqualTo(Boolean.TRUE);
		assertThat(line.next()).isEqualTo(Boolean.FALSE);
		assertThat(line.next()).isEqualTo(Boolean.TRUE);
		assertThat(line.next()).isEqualTo(Boolean.FALSE);
	}

	@Test
	public void widthTest() {
		Line line = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

		assertThat(line.getWidth()).isEqualTo(5);
	}


}
