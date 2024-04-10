package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	void 라인_생성_테스트() {

		final int numberOfPeople = 4;
		final Line line = new Line(() -> true, numberOfPeople);
		assertThat(line.getBridges()).isEqualTo(List.of(Bridge.BRIDGE, Bridge.NON_BRIDGE, Bridge.BRIDGE));
	}
}