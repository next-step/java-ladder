package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.strategy.LineCreateStrategy;
import nextstep.ladder.domain.user.LadderUsersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LinesTest {

    private final LineCreateStrategy lineCreateStrategyStub = new LineCreateStrategy() {
        @Override
        public boolean createFirstPoint() {
            return false;
        }

        @Override
        public boolean createNextPoint(boolean prevPoint) {
            return false;
        }
    };

    @DisplayName("Lines 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Lines(LadderUsersTest.LadderUSERS1, HeightTest.HEIGHT1, lineCreateStrategyStub));
    }
}
