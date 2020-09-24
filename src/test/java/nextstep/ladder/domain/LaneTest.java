package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static nextstep.ladder.TestUtil.asPointList;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaneTest {

    @Test
    @DisplayName("팩토리 메소드 유효성 검사")
    void of_validateIndex() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Lane.of(-1)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "2, 3", "3, 2", "4, 4"})
    @DisplayName("하나의 Line을 이동한 결과 Lane 반환")
    void move(int beforeIndex, int afterIndex) {
        // given
        Line line = Line.of(asPointList(true, false, true, false));

        // when
        Lane actual = Lane.of(beforeIndex).move(line);

        // then
        Lane expected = Lane.of(afterIndex);
        assertEquals(expected, actual);
    }
}
