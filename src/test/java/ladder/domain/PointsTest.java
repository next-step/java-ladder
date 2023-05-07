package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointsTest {

	@DisplayName("유효한 좌표 목록으로 좌표 목록 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Points points = new Points(true, false, true, false);
		assertThat(points).isEqualTo(new Points(true, false, true, false));
	}

	@DisplayName("인접 좌표가 true로 겹치는 경우, 예외를 던진다.")
	@CsvSource(value = {"true,true,false,false", "false,true,true,false", "false,false,true,true"}, delimiter = ',')
	@ParameterizedTest
	void test2(boolean input1, boolean input2, boolean input3, boolean input4) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Points(input1, input2, input3, input4));
	}
}
