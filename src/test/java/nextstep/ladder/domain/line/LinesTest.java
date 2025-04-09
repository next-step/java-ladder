package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    private final LineCreateStrategy lineCreateStrategyStub =  new LineCreateStrategy() {
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
        assertDoesNotThrow(() -> new Lines(LadderUsersTest.LadderUSERS1, 2, lineCreateStrategyStub));
    }

    @DisplayName("높이가 0 이하이면 예외를 반환한다.")
    @Test
    public void testConstructor_throwException() {
        assertThatThrownBy(() -> new Lines(LadderUsersTest.LadderUSERS1, 0, lineCreateStrategyStub))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("높이는 1 이상이여야 합니다.");
    }
}
