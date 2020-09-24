package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Direction에 따른 인덱스 변경")
    void change() {
        Lane actual = Lane.of(0).change(Direction.RIGHT);
        Lane expected = Lane.of(1);
        assertEquals(expected, actual);
    }

}
