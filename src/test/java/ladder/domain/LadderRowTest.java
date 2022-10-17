package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-17
 */
class LadderRowTest {

	@Test
	void 생성_2인() {
		LadderRow ladderRow = new LadderRow(2, () -> true);
		List<LadderColumn> columns = ladderRow.getColumns();

		assertThat(columns).hasSize(3);
		assertThat(columns.get(0)).hasSameClassAs(new LadderColumnEdge());
		assertThat(columns.get(1)).hasSameClassAs(new LadderColumnWidth(true));
		assertThat(columns.get(2)).hasSameClassAs(new LadderColumnEdge());
	}

	@Test
	void 생성_3인이상() {
		LadderRow ladderRow = new LadderRow(3, () -> true);
		List<LadderColumn> columns = ladderRow.getColumns();

		assertThat(columns).hasSize(5);
		assertThat(columns.get(0)).hasSameClassAs(new LadderColumnEdge());
		assertThat(columns.get(1)).hasSameClassAs(new LadderColumnWidth(true));
		assertThat(columns.get(2)).hasSameClassAs(new LadderColumnEdge());
		assertThat(columns.get(3)).hasSameClassAs(new LadderColumnWidth(false));
		assertThat(columns.get(4)).hasSameClassAs(new LadderColumnEdge());
	}
}