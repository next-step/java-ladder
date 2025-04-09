package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

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

    @DisplayName("Line 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Line(2, lineCreateStrategyStub));
    }

    @DisplayName("유저 수가 1명 이하이면 예외를 반환한다.")
    @Test
    public void testConstructor_throwException() {
        assertThatThrownBy(() -> new Line(1, lineCreateStrategyStub))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유저는 2명 이상이여야 합니다.");
    }

}
