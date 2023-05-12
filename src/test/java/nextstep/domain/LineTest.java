package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void 라인을_생성한다() {
        // given & when & then
        assertDoesNotThrow(() -> {
            new Line(new LineRandom(), 5);
        });
    }
}
