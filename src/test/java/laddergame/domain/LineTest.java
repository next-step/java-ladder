package laddergame.domain;

import static com.google.common.primitives.Booleans.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LineTest {

	@Test
	public void 라인_문자열_생성() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));

		assertThat(line.draw()).isEqualTo("     |-----|     |-----|");
	}

	@Test
	public void 라인_이동_현재_좌표에_선이_존재() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));

		assertThat(line.move(1)).isEqualTo(0);
	}

	@Test
	public void 라인_이동_현재_좌표에_선이_미존재() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));

		assertThat(line.move(1)).isEqualTo(1);
	}

	@Test
	public void 라인_이동_현재_좌표에_선이_존재안할때_다음_좌표에_선이_존재() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

		assertThat(line.move(1)).isEqualTo(2);
	}

	@Test
	public void 라인_이동_처음_좌표일때_다음_좌표에_선이_존재() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));

		assertThat(line.move(0)).isEqualTo(1);
	}

	@Test
	public void 라인_이동_처음_좌표일때_다음_좌표에_선이_미존재() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

		assertThat(line.move(0)).isEqualTo(0);
	}

	@Test
	public void 라인_이동_마지막_좌표일때_선이_존재() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));

		assertThat(line.move(3)).isEqualTo(2);
	}

	@Test
	public void 라인_이동_마지막_좌표일때_선이_미존재() {
		Line line = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

		assertThat(line.move(3)).isEqualTo(3);
	}
}
