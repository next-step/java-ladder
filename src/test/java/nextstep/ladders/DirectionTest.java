package nextstep.ladders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true", "false:false"}, delimiter = ':')
    void 정상생성(boolean left, boolean right) {
        Assertions.assertEquals(Direction.of(left, right), Direction.of(left, right));
    }
}
