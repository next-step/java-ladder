package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    private static final int HEIGHT = 5;
    private static final String[] USER_NAMES = {"a", "b", "c", "d", "e"};

    @Test
    @DisplayName("유저가 5명, 높이가 5일때 lines, line의 갯수가 올바르게 생성이 되었는지 확인한다.")
    void createLadderTest() {

        Ladder ladder = Ladder.of(USER_NAMES.length, HEIGHT);

        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines())
            .map(Line::getPoints)
            .map(List::size)
            .allMatch(size -> size == USER_NAMES.length - 1);
    }
}
