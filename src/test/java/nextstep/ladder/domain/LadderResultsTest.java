package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderResultsTest {


    @DisplayName("player 수와 결과 리스트 수가 맞지 않으면 fail")
    @Test
    void create() {
        assertThrows(IllegalArgumentException.class,
                () -> new LadderResults(
                        Arrays.asList(new Player("AAA"), new Player("BBB")),
                        Arrays.asList("꽝", "1000", "2000"))
        );
    }
}