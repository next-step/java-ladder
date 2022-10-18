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
		LadderFactory ladderFactory = new LadderFactory();
		Ladder ladder = ladderFactory.create(new InputDTO("a,b", 2));

		assertThat(ladder).isNotNull();
		assertThat(ladder.getLadderRows()).hasSize(2);
		assertThat(ladder.getLadderRows().get(0).getColumns().size()).isEqualTo(3);
		assertThat(ladder.getLadderRows().get(0).getColumns().get(0)).isInstanceOf(LadderColumnEdge.class);
		assertThat(ladder.getLadderRows().get(0).getColumns().get(1)).isInstanceOf(LadderColumnWidth.class);
	}
}