package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    private final int countOfPerson = 4;

    @ParameterizedTest
    @CsvSource(value = {"pobi, 0", "honux, 1", "crong, 2", "jk, 3"})
    @DisplayName("팩토리 메소드 정상 작동")
    void of(String name, int index) {
        Lane lane = Lane.of(countOfPerson, index);
        assertNotNull(Player.of(name, lane));
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생")
    void of_validate() {
        Lane lane = Lane.of(countOfPerson, 0);
        assertThatIllegalArgumentException().isThrownBy(() ->
                Player.of("abcdef", lane)
        );
    }
}
