package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-17
 */
class LadderColumnTest {

	@Test
	void 생성_width() {
		assertThat(new LadderColumnWidth(true).isNotEmpty()).isTrue();
		assertThat(new LadderColumnWidth(false).isNotEmpty()).isFalse();
	}

	@Test
	void 생성_edge() {
		assertThat(new LadderColumnEdge().isNotEmpty()).isTrue();
	}
}