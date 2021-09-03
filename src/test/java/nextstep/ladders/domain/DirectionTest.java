package nextstep.ladders.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true", "false:false"}, delimiter = ':')
    @DisplayName("생성 테스트")
    void create(final boolean left, final boolean right) {
        assertEquals(Direction.of(left, right), Direction.of(left, right));
    }

    @Test
    @DisplayName("Direction 의 왼쪽 오른쪽이 둘다 참일경우 에러")
    void errorIfBothLeftAndRightOfDirectionAreTrue() {
        assertThrows(IllegalArgumentException.class, () -> Direction.of(true, true));
    }

    @Test
    @DisplayName("Direction 의 첫번째는 반드시 false")
    void theFirstOfDirectionMustBeFalse() {
        assertEquals(Direction.first(true), Direction.of(false, true));
        assertEquals(Direction.first(false), Direction.of(false, false));
    }

    @Test
    @DisplayName("Direction 의 마지막은 반드시 false")
    void theEndOfDirectionMustBeFalse() {
        Direction direction = Direction.of(true, false);
        assertEquals(direction.last(), Direction.of(false, false));
    }

    @Test
    @DisplayName("오른쪽이 참이면 다음 왼쪽은 거짓")
    void ifRightIsTrueThenLeftIsFalse() {
        Direction direction = Direction.of(false, true);
        assertEquals(direction.next(false), Direction.of(true, false));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("오른쪽이 거짓이면 다음 왼쪽은 생성 룰에 따라서")
    void ifTheRightIsFalseTheNextLeftIsAccordingToTheGenerationRule(final boolean next) {
        Direction direction = Direction.of(true, false);
        assertEquals(direction.next(next), Direction.of(false, next));
    }
}
