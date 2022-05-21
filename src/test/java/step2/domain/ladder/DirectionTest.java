package step2.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

	@ParameterizedTest(name = "{displayName} : {0} : {1} => {2}")
	@CsvSource(
		delimiter = ':',
		value = {
			"LEFT:5:4",
			"STRAIGHT:5:5",
			"RIGHT:5:6"
		}
	)
	void 방향에_따라서_다음_라인의_출발위치를_반환(Direction direction, int currentIndex, int nextIndex) {
		assertThat(direction.nextIndex(currentIndex)).isEqualTo(nextIndex);
	}

}