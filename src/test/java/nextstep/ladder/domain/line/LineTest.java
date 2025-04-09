package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.UsersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineTest {

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

    @DisplayName("Line 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Line(UsersTest.USERS1, lineCreateStrategyStub));
    }
}
