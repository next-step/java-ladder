package ladder.model.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"true,false", "false,true", "false,false"})
    @DisplayName("of로 가져올 때 같은 객체 가져오는 것 테스트")
    void ofGetSameObjectTest(boolean left, boolean right) {
        assertThat(Direction.of(left,right)).isSameAs(Direction.of(left,right));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true,false})
    @DisplayName("first()는 항상 left가 false인 것 테스트")
    void firstLeftIsFalseTest(boolean right) {
        assertFalse(Direction.first(right).left());
    }

    @ParameterizedTest
    @CsvSource(value = {"true,false", "false,true", "false,false"})
    @DisplayName("last()는 항상 right가 false인 것 테스트")
    void lastRightIsFalseTest(boolean left, boolean right) {
        assertFalse(Direction.of(left,right).last().right());
    }

    @Test
    @DisplayName("right이 true이면 next의 right 항상 false")
    void rightTrueLeftOfNextIsFalse() {
        assertFalse(Direction.of(false,true).next(true).right());
        assertFalse(Direction.of(false,true).next(false).right());
    }
}
