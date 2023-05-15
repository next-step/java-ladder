package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

	@DisplayName("유효한 좌표 목록으로 가로 라인 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Line line = Line.of(Crosses.of(true, false, true, false));
		assertThat(line).isEqualTo(Line.of(Crosses.of(true, false, true, false)));
	}

	@DisplayName("다음 라인으로 이동 후의 인덱스를 반환한다.")
	@Test
	void test2() {
		Line line = Line.of(Crosses.of(true, false, true, false));

		assertThat(line.nextIndex(0)).isEqualTo(1);
		assertThat(line.nextIndex(1)).isEqualTo(0);
		assertThat(line.nextIndex(2)).isEqualTo(3);
		assertThat(line.nextIndex(3)).isEqualTo(2);
	}
}
