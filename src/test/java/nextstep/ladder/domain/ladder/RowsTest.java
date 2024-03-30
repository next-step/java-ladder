package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RowsTest {

    @DisplayName("Rows는 높이 만큼의 행을 가진다.")
    @Test
    void constructor() {
        assertThat(new Rows(new Height(5), new Count(3), () -> true).height())
                .isEqualTo(new Height(5));
    }
}
