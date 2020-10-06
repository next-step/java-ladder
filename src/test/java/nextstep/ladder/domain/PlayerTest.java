package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static nextstep.ladder.TestUtil.asPointList;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi, 0", "honux, 1", "crong, 2", "jk, 3"})
    @DisplayName("팩토리 메소드 정상 작동")
    void of(String name, int index) {
        Lane lane = Lane.of(index);
        assertNotNull(Player.of(name, lane));
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생")
    void of_validate() {
        Lane lane = Lane.of(0);
        assertThatIllegalArgumentException().isThrownBy(() ->
                Player.of("abcdef", lane)
        );
    }

    @Test
    @DisplayName("한 줄 이동한 결과")
    void move() {
        // given
        String name = "pobi";
        Player actual = Player.of(name, Lane.of(0));
        Line line = Line.of(asPointList(true, false, true));

        // when
        actual.move(line);

        // then
        Player expected = Player.of(name, Lane.of(1));
        assertEquals(expected, actual);
    }
}
