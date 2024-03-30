package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @DisplayName("사다리의 행을 생성하면 발판이 겹쳐서 나타나지 않는다.")
    @Test
    void constructor() {
        final Row row = new Row(new Count(4), () -> true);
        assertThat(row.rungs())
                .containsExactly(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
    }
}
