package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-10-17
 */
class LadderTest {

	@Test
	void 생성() {
		List<LadderRow> ladderRows = new ArrayList<>();
		ladderRows.add(new LadderRow(4));
		ladderRows.add(new LadderRow(4));

		Ladder ladder = new Ladder(ladderRows);

		assertThat(ladder).hasSize(2);
	}
}