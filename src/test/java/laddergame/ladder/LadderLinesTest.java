package laddergame.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 라인들은")
class LadderLinesTest {

    private static final int USER_COUNT = 4;

    @DisplayName("사람수, 사다리 높이, connection 사용하여 초기화")
    @Test
    void create_countOfPerson_height_connection() {
        Height height = new Height(5);
        assertThat(new LadderLines(height, USER_COUNT, () -> true))
                .isEqualTo(new LadderLines(height, USER_COUNT, () -> true));
    }
}
