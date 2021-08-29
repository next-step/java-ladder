package nextstep.ladders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true", "false:false"}, delimiter = ':')
    void 생성_정상(boolean left, boolean right) {
        assertEquals(Direction.of(left, right), Direction.of(left, right));
    }

    @Test
    void 생성_둘다_참일경우_에러() {
        assertThrows(IllegalArgumentException.class, () -> Direction.of(true, true));
    }
}
