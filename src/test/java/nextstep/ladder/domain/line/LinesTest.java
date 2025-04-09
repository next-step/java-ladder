package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LinesTest {
    @DisplayName("Lines 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Lines(LadderUsersTest.LadderUSERS1, HeightTest.HEIGHT1, prevPoint -> !prevPoint));
    }

    @DisplayName("Lines 출력 포멧")
    @Test
    public void testToString() {
        Lines lines = new Lines(LadderUsersTest.LadderUSERS1, HeightTest.HEIGHT1, prevPoint -> !prevPoint);
        System.out.println(lines);
        assertThat(lines.toString())
            .isEqualTo(
                "  |-----|     |-----|\n" +
                    "  |-----|     |-----|\n" +
                    "  |-----|     |-----|"
            );
    }
}
