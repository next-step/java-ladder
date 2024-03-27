package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LineTest {
    @Test
    @DisplayName("fromWithStrategy 호출 시 매개변수로 정수(참가자 수)와 points 생성 전략을 받아 Line 반환")
    void create() {
        assertThatNoException().isThrownBy(() -> Line.from(5, (playerCount) -> List.of(true, false, true, false, true)));
    }
}
