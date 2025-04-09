package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.strategy.LineCreateStrategy;
import nextstep.ladder.domain.user.LadderUsersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineTest {

    private final LineCreateStrategy lineCreateStrategyStub = new LineCreateStrategy() {
        @Override
        public boolean createFirstPoint() {
            return true;
        }

        @Override
        public boolean createNextPoint(boolean prevPoint) {
            return !prevPoint;
        }
    };

    @DisplayName("Line 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Line(LadderUsersTest.LadderUSERS1, lineCreateStrategyStub));
    }

    @DisplayName("사다리 Line 출력 포멧")
    @Test
    public void testToString() {
        Line line = new Line(LadderUsersTest.LadderUSERS1, lineCreateStrategyStub);
        assertThat(line.toString()).isEqualTo("  |-----|     |-----|");
    }
}
