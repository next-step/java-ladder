package nextstep.ladders.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true", "false:false"}, delimiter = ':')
    void 생성_정상(final boolean left, final boolean right) {
        assertEquals(Direction.of(left, right), Direction.of(left, right));
    }

    @Test
    void 생성_둘다_참일경우_에러() {
        assertThrows(IllegalArgumentException.class, () -> Direction.of(true, true));
    }

    @Test
    void 첫번째는_무조건_false() {
        assertEquals(Direction.first(true), Direction.of(false, true));
        assertEquals(Direction.first(false), Direction.of(false, false));
    }

    @Test
    void 마지막은_무조건_false() {
        Direction direction = Direction.of(true, false);
        assertEquals(direction.last(), Direction.of(false, false));
    }

    @Test
    void 오른쪽이_참이면_다음엔_왼쪽은_거짓() {
        Direction direction = Direction.of(false, true);
        assertEquals(direction.next(false), Direction.of(true, false));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 오른쪽이_거짓이면_다음_왼쪽은_생성_룰에_따라서(final boolean next) {
        Direction direction = Direction.of(true, false);
        assertEquals(direction.next(next), Direction.of(false, next));
    }
}
