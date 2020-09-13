package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

	@DisplayName(value = "사다리 라인이 연속으로 생성되지 않는지 테스트")
	@Test
	void getPoints() {
		Line line = Line.init(5);
		List<Boolean> expected = Arrays.asList(true, true);
		assertThat(line.getPoints()).doesNotContainSequence(expected);
	}

	@DisplayName(value = "라인 각 위치의 포인트 값 확인 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0:false", "1:true", "2:false", "3:false", "4:false"}, delimiter = ':')
	void pointOrNotTest(int index, boolean expected) {
		List<Boolean> points = new ArrayList<>(Arrays.asList(false, true, false, false, false));
		Line line = new Line(points);
		assertThat(line.isPoint(index)).isEqualTo(expected);
	}
}
