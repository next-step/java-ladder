package ladder.domain;

import ladder.dto.InputDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-17
 */
class LadderFactoryTest {

	@Test
	void 생성() {
		Ladder ladder = LadderFactory.create(InputDTO.from("a,b", 2, "100,꽝"));
		LadderRow fistColumn = ladder.get(0);

		assertThat(ladder).isNotNull();
		assertThat(ladder).hasSize(2);
		assertThat(fistColumn.size()).isEqualTo(3);
		assertThat(fistColumn.get(0)).isInstanceOf(LadderColumnEdge.class);
		assertThat(fistColumn.get(1)).isInstanceOf(LadderColumnWidth.class);
	}
}