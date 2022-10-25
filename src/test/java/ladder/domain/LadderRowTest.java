package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-17
 */
class LadderRowTest {

	@Test
	void 생성_2인() {
		LadderRow ladderRow = new LadderRow(2, () -> true);

		assertThat(ladderRow).hasSize(3);
		assertThat(ladderRow.get(0)).hasSameClassAs(new LadderColumnEdge());
		assertThat(ladderRow.get(1)).hasSameClassAs(new LadderColumnWidth(true));
		assertThat(ladderRow.get(2)).hasSameClassAs(new LadderColumnEdge());
	}

	@Test
	void 생성_3인이상() {
		LadderRow ladderRow = new LadderRow(3, () -> true);

		assertThat(ladderRow).hasSize(5);
		assertThat(ladderRow.get(0)).hasSameClassAs(new LadderColumnEdge());
		assertThat(ladderRow.get(1)).hasSameClassAs(new LadderColumnWidth(true));
		assertThat(ladderRow.get(2)).hasSameClassAs(new LadderColumnEdge());
		assertThat(ladderRow.get(3)).hasSameClassAs(new LadderColumnWidth(false));
		assertThat(ladderRow.get(4)).hasSameClassAs(new LadderColumnEdge());
	}
}