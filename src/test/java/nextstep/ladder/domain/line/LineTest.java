package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineTest {
    @DisplayName("Line 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Line(LadderUsersTest.LadderUSERS1, prevPoint -> !prevPoint));
    }

    @DisplayName("사다리 Line 출력 포멧")
    @Test
    public void testToString() {
        Line line = new Line(LadderUsersTest.LadderUSERS1, prevPoint -> !prevPoint);
        assertThat(line.toString()).isEqualTo("  |-----|     |-----|");
    }
}
